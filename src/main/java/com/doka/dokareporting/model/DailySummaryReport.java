package com.doka.dokareporting.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailySummaryReport {

    private List <IddaaRetailerTransactions> iddaaRetailerTransactions ;
    private List <SporTotoRetailerTransactions> sporTotoRetailerTransactions ;
    private List <TotalRetailerTransactions> totalRetailerTransactions ;

}
