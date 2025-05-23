package org.ton.java.tlb;

import lombok.Builder;
import lombok.Data;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;

import java.util.Collections;
import java.util.List;

/**
 *
 *
 * <pre>
 * vm_tupref_nil$_ = VmTupleRef 0;
 * vm_tupref_single$_ entry:^VmStackValue = VmTupleRef 1;
 * vm_tupref_any$_ {n:#} ref:^(VmTuple (n + 2)) = VmTupleRef (n + 2);
 * </pre>
 */
@Builder
@Data
public class VmTupleRef implements VmStackValue {
  List<VmTuple> values;

  @Override
  public Cell toCell() {
    throw new Error("wrong usage");
  }

  public Cell toCell(int len) {
    if (len == 0) {
      return CellBuilder.beginCell().endCell();
    }
    if (len == 1) {
      return CellBuilder.beginCell().storeRef(((VmStackValue) values.get(0)).toCell()).endCell();
    }
    return CellBuilder.beginCell().storeRef(VmTuple.toCell(values)).endCell();
  }

  public static Cell toCell(List<VmTuple> pValues) {
    if (pValues.isEmpty()) {
      return CellBuilder.beginCell().endCell();
    }
    if (pValues.size() == 1) {
      return CellBuilder.beginCell().storeRef(pValues.get(0).toCell()).endCell();
    }
    return CellBuilder.beginCell().storeRef(VmTuple.toCell(pValues)).endCell();
  }

  public static Cell toCellS(List<VmStackValue> pValues) {
    if (pValues.isEmpty()) {
      return CellBuilder.beginCell().endCell();
    }
    if (pValues.size() == 1) {
      return CellBuilder.beginCell().storeRef(pValues.get(0).toCell()).endCell();
    }
    return CellBuilder.beginCell().storeRef(VmTuple.toCellS(pValues)).endCell();
  }

  public static VmTuple deserialize(CellSlice cs, int len) {
    if (len == 0) {
      return VmTuple.builder().values(Collections.emptyList()).build();
    } else if (len == 1) {
      return VmTuple.builder()
          .values(
              Collections.singletonList(
                  VmStackValue.deserialize(CellSlice.beginParse(cs.loadRef()))))
          .build();
    }

    return VmTuple.deserialize(CellSlice.beginParse(cs.loadRef()), len);
  }
}
