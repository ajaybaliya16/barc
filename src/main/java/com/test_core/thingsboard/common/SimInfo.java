package com.test_core.thingsboard.common;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class SimInfo {
    @NotNull(message = "Imsi is not provided")
    @NotBlank(message = "Imsi cannot be blank")
    @Size(min = 13, max = 15, message = "Imsi must be between 13 and 15 characters")
    @Pattern(regexp = "^[0-9]+$", message = "Imsi must contain only digits")
    private String imsi;
    @NotNull(message = "SIM Serial is not provided")
    @NotBlank(message = "SIM Serial cannot be blank")
    @Size(min = 1, max = 22, message = "SIM Serial must be between 1 and 22 characters")
    private String sim_serial;
    /*@NotNull(message = "PhoneNo is not provided")
    @NotBlank(message = "PhoneNo cannot be blank")
    @Size(min = 10, max = 10, message = "PhoneNo must be exactly 10 characters")*/
    @Pattern(regexp = "^(|[0-9]{10})$", message = "PhoneNo must contain only digits and be exactly 10 characters, or be empty")
    private String phone_no;
    @NotNull(message = "Service Provider is not provided")
    @NotBlank(message = "Service Provider cannot be blank")
    private String service_provider;
}
