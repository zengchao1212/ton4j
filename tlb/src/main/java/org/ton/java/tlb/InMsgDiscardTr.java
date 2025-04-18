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
 * msg_discard_tr$111
 * in_msg:^MsgEnvelope
 * transaction_id:uint64
 * fwd_fee:Grams
 * proof_delivered:^Cell = InMsg;
 * </pre>
 */
@Builder
@Data
public class InMsgDiscardTr implements InMsg {
  MsgEnvelope inMsg;
  BigInteger transactionId;
  BigInteger fwdFee;
  Cell proofDelivered;

  @Override
  public Cell toCell() {
    return CellBuilder.beginCell()
        .storeUint(0b100, 3)
        .storeRef(inMsg.toCell())
        .storeUint(transactionId, 64)
        .storeCoins(fwdFee)
        .storeRef(proofDelivered)
        .endCell();
  }

  public static InMsgDiscardTr deserialize(CellSlice cs) {
    return InMsgDiscardTr.builder()
        .inMsg(MsgEnvelope.deserialize(CellSlice.beginParse(cs.loadRef())))
        .transactionId(cs.loadUint(64))
        .fwdFee(cs.loadCoins())
        .proofDelivered(cs.loadRef())
        .build();
  }
}
