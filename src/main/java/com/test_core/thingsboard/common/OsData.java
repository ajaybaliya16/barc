package com.test_core.thingsboard.common;


import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OsData {
    private Long id;
//    @ApiModelProperty(position = 2, value = "Os Type")
    @NotNull(message = "OsType cannot be null !")
    private String osType;
//    @ApiModelProperty(position = 3, value = "Hardware Version Name")
    @NotNull(message = "Hardware Version cannot be null !")
    private String hardwareVersion;
//    @ApiModelProperty(position = 4, value = "ConflictedComponents is a list of conflicted components")
    private List<String> conflictedComponents;
//    @ApiModelProperty(position = 5, value = "Mandatory Params is a list of conflicted components")
    private List<String> mandatoryParams;
}
