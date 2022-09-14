package com.doka.dokareporting.service.restclients;



import com.doka.dokareporting.model.DailySummaryReport;
import com.doka.dokareporting.model.LimitReport;
import com.doka.dokareporting.model.MemberDeposit;
import com.doka.dokareporting.model.RetailerRefundAmountReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "retail-service", url = "${retail-service.url}")
public interface RetailRestService {




    @GetMapping("Retailer/Report/{retailerId}")
    ResponseEntity<DailySummaryReport> dailySummaryReport(@PathVariable Integer retailerId,
                                                                         @RequestParam String startDate,
                                                                         @RequestParam String endDate);

    @GetMapping("Retailer/LimitReport/{retailerId}")
    ResponseEntity<List<LimitReport>> limitReport(@PathVariable Integer retailerId);


    @PostMapping("Retailer/Report/MemberDeposit/{retailerId}")
    ResponseEntity<List<MemberDeposit>> memberDeposit(@PathVariable Integer retailerId,
                                                      @RequestParam String startDate,
                                                      @RequestParam String endDate,
                                                      @RequestParam Boolean groupByMember, @RequestBody String body);


    @GetMapping("Retailer/RetailerRefundAmountReport/{retailerId}")
    ResponseEntity<List<RetailerRefundAmountReport>> retailerRefundAmountReport(@PathVariable Integer retailerId,
                                                                                @RequestParam String startDate,
                                                                                @RequestParam String endDate);


}
