package org.ton.java.tlb;

import lombok.Builder;
import lombok.Data;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;

import java.math.BigInteger;

/**
 *
 *
 * <pre>
 * _ enqueued_lt:uint64 out_msg:^MsgEnvelope = EnqueuedMsg;
 * </pre>
 */
@Builder
@Data
public class EnqueuedMsg implements InMsg {
  BigInteger enqueuedLt;
  MsgEnvelope outMsg;

  @Override
  public Cell toCell() {
    return CellBuilder.beginCell().storeUint(enqueuedLt, 64).storeRef(outMsg.toCell()).endCell();
  }

  public static EnqueuedMsg deserialize(CellSlice cs) {
    return EnqueuedMsg.builder()
        .enqueuedLt(cs.loadUint(64))
        .outMsg(MsgEnvelope.deserialize(CellSlice.beginParse(cs.loadRef())))
        .build();
  }
}
