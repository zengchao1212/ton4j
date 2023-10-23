package org.ton.java.tlb.types;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;

import java.math.BigInteger;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Builder
@Getter
@Setter
@ToString
/**
 * addr_std$10 anycast:(Maybe Anycast)  workchain_id:int8 address:bits256  = MsgAddressInt;
 *
 * addr_var$11
 *   anycast:(Maybe Anycast)
 *   addr_len:(## 9)
 *   workchain_id:int32
 *   address:(bits addr_len) = MsgAddressInt;
 */
public class MsgAddressInt {
    int magic;
    Anycast anycast;
    int addrLen;
    int workchainId;
    BigInteger address;

    @Override
    public String toString() {
        return nonNull(address) ? (workchainId + ":" + address.toString(16)) : null;
    }

    public Cell toCellStd() {
        CellBuilder result = CellBuilder.beginCell();
        result.storeUint(2, 2);
        if (isNull(anycast)) {
            result.storeBit(false);
        } else {
            result.storeBit(true);
            result.writeCell(anycast.toCell());
        }
        result.storeUint(workchainId, 8)
                .storeUint(address, 256)
                .endCell();
        return result;
    }

    public Cell toCellVar() {
        CellBuilder result = CellBuilder.beginCell();
        result.storeUint(3, 2);
        if (isNull(anycast)) {
            result.storeBit(false);
        } else {
            result.storeBit(true);
            result.writeCell(anycast.toCell());
        }
        result.storeUint(addrLen, 9)
                .storeUint(workchainId, 32)
                .storeUint(address, addrLen)
                .endCell();
        return result;
    }
}
