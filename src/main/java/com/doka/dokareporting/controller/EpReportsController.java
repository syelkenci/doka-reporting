package com.doka.dokareporting.controller;

import com.doka.dokareporting.model.DailySummaryReport;
import com.doka.dokareporting.model.LimitReport;
import com.doka.dokareporting.model.MemberDeposit;
import com.doka.dokareporting.model.RetailerRefundAmountReport;
import com.doka.dokareporting.service.EpReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.doka.dokareporting.commons.DateUtils.convertToLocalDateTime;

@RestController
@RequestMapping("ep")
@RequiredArgsConstructor
public class EpReportsController {

    private final EpReportsService epReportsService;

    @GetMapping("/summary/{retailerId}")
    DailySummaryReport dailySummaryReport(@PathVariable Integer retailerId,
                                          @RequestParam long startTime,
                                          @RequestParam long endTime
    ){

        return epReportsService.dailySummaryReport(retailerId,convertToLocalDateTime(startTime),convertToLocalDateTime(endTime));
    }

    @GetMapping("/limit/{retailerId}")
    List<LimitReport> limitReport(@PathVariable Integer retailerId){

        return epReportsService.limitReport(retailerId);
    }


    @GetMapping("/member-deposit/{retailerId}")
    List<MemberDeposit> memberDeposit(@PathVariable Integer retailerId,
                                      @RequestParam long startTime,
                                      @RequestParam long endTime){
        return epReportsService.memberDeposit(retailerId,convertToLocalDateTime(startTime),convertToLocalDateTime(endTime));
    }


    @GetMapping("/retailer-refund-amount/{retailerId}")
    List<RetailerRefundAmountReport> retailerRefundAmountReport(@PathVariable Integer retailerId,
                                                                @RequestParam long startTime,
                                                                @RequestParam long endTime){

        return epReportsService.retailerRefundAmountReport(retailerId,convertToLocalDateTime(startTime),convertToLocalDateTime(endTime));
    }

}
