package com.doka.dokareporting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitReport {
    private String showText;
    private String showValue;
    private Integer order;
}
