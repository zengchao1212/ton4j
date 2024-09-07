package org.ton.java.smartcontract.types;

import lombok.Builder;
import lombok.Data;
import org.ton.java.smartcontract.wallet.v5.WalletActions;

import java.math.BigInteger;

@Builder
@Data
public class WalletV5Config implements WalletConfig{
    int op;
    long walletId;
    long seqno;
    long validUntil;
    long createdAt;
    boolean bounce;
    WalletActions body;
    boolean signatureAllowed;
    BigInteger amount;
    long queryId;
}