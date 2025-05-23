package org.ton.java.tlb;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;

@Builder
@Data
/** _ dns_root_addr:bits256 = ConfigParam 4; // root TON DNS resolver */
public class ConfigParams4 {
  BigInteger dnsRootAddr;

  public Cell toCell() {
    return CellBuilder.beginCell().storeUint(dnsRootAddr, 256).endCell();
  }

  public static ConfigParams4 deserialize(CellSlice cs) {
    return ConfigParams4.builder().dnsRootAddr(cs.loadUint(256)).build();
  }
}
