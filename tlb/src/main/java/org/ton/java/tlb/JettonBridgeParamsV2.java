package org.ton.java.tlb;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;
import org.ton.java.address.Address;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;
import org.ton.java.cell.TonHashMapE;

@Builder
@Data
public class JettonBridgeParamsV2 implements JettonBridgeParams {
  int magic;
  Address bridgeAddress;
  Address oracleAddress;
  TonHashMapE oracles;
  int stateFlags;
  JettonBridgePrices prices;
  BigInteger externalChainAddress;

  public Cell toCell() {

    return CellBuilder.beginCell()
        .storeUint(0x00, 8)
        .storeAddress(bridgeAddress)
        .storeAddress(oracleAddress)
        .storeDict(
            oracles.serialize(
                k -> CellBuilder.beginCell().storeUint((BigInteger) k, 256).endCell().getBits(),
                v -> CellBuilder.beginCell().storeUint((BigInteger) v, 256).endCell()))
        .storeUint(stateFlags, 8)
        .storeRef(prices.toCell())
        .storeUint(externalChainAddress, 256)
        .endCell();
  }

  public static JettonBridgeParamsV2 deserialize(CellSlice cs) {
    return JettonBridgeParamsV2.builder()
        .magic(cs.loadUint(8).intValue())
        .bridgeAddress(cs.loadAddress())
        .oracleAddress(cs.loadAddress())
        .oracles(
            cs.loadDictE(256, k -> k.readUint(256), v -> CellSlice.beginParse(v).loadUint(256)))
        .stateFlags(cs.loadUint(8).intValue())
        .prices(JettonBridgePrices.deserialize(CellSlice.beginParse(cs.loadRef())))
        .externalChainAddress(cs.loadUint(256))
        .build();
  }
}
