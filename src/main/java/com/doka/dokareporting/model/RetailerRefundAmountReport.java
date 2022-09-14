package com.doka.dokareporting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetailerRefundAmountReport {
    /*
             "memberId": 208590,
            "phoneNumber": "05399261741",
            "amount": 100.00,
            "showDepositAmount": "100",
            "createdDate": "2022-08-18T11:54:42.161132"
     */

    private Integer memberId;
    private String phoneNumber;
    private BigDecimal amount;
    private String showDepositAmount;
    private String createdDate;
}
