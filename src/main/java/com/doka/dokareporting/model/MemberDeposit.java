package com.doka.dokareporting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDeposit {
    /*
            "memberId": 208594,
            "phoneNumber": "05427811546",
            "depositAmount": 1000.00,
            "showDepositAmount": "1.000",
            "createdDate": "2022-08-18T17:00:38.550578"
     */
    private Integer memberId;
    private String phoneNumber;
    private BigDecimal depositAmount;
    private String showDepositAmount;
    private String createdDate;



}
