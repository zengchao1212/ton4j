package org.ton.java.tlb.types;

import lombok.Builder;
import lombok.Data;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;

@Builder
@Data
public class AccountStateUninit implements AccountState {
    int magic;

    @Override
    public Cell toCell() {
        return CellBuilder.beginCell()
                .storeUint(0, 2)
                .endCell();
    }

    public static AccountStateUninit deserialize(CellSlice cs) {
        return null;
    }
}
