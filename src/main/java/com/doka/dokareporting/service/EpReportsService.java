package com.doka.dokareporting.service;

import com.doka.dokareporting.model.DailySummaryReport;
import com.doka.dokareporting.model.LimitReport;
import com.doka.dokareporting.model.MemberDeposit;
import com.doka.dokareporting.model.RetailerRefundAmountReport;

import java.time.LocalDateTime;
import java.util.List;

public interface EpReportsService {
    DailySummaryReport dailySummaryReport(Integer retailerId, LocalDateTime start, LocalDateTime end);

    List<LimitReport> limitReport(Integer retailerId);

    List<MemberDeposit> memberDeposit(Integer retailerId, LocalDateTime start, LocalDateTime end);

    List<RetailerRefundAmountReport> retailerRefundAmountReport(Integer retailerId, LocalDateTime start, LocalDateTime end);
}
