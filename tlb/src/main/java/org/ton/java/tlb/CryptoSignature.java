package org.ton.java.tlb;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;

/**
 * <pre>
 * ed25519_signature#5 R:bits256 s:bits256 = CryptoSignatureSimple;  // 516 bits
 * _ CryptoSignatureSimple = CryptoSignature;
 * </pre>
 */
@Builder
@Data

public class CryptoSignature {
    int magic;
    BigInteger r;
    BigInteger s;

    public Cell toCell() {
        return CellBuilder.beginCell()
                .storeUint(0x5, 8)
                .storeUint(r, 256)
                .storeUint(s, 256)
                .endCell();
    }

    public static CryptoSignature deserialize(CellSlice cs) {
        long magic = cs.loadUint(4).longValue();
        assert (magic == 0x5) : "CryptoSignature: magic not equal to 0x5, found 0x" + Long.toHexString(magic);

        return CryptoSignature.builder()
                .magic(0x5)
                .r(cs.loadUint(256))
                .s(cs.loadUint(256))
                .build();
    }
}
