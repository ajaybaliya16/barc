package com.test_core.thingsboard.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Metadata {
    private String customer;
    private String comment;
    private String version;
    @JsonProperty("custom_metadata")
    private String customMetaData;
}
