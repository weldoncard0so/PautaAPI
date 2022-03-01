package com.weldoncardoso.PautaAPI.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CpfDTO implements Serializable {
    @JsonProperty("status")
    private String status;
}
