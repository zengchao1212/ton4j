package org.ton.java.liteclient.api;

import lombok.Builder;import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Getter
@ToString
public class ResultConfig2 implements Serializable {
    private String minterSmcAddress;
}

