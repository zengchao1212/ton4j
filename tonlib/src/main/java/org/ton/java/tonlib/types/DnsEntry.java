package org.ton.java.tonlib.types;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class DnsEntry {
    @SerializedName("@type")
    final String type = "dns.entry";
    String name;
    String category;
    DnsEntryData entry;
}