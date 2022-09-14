package com.doka.dokareporting.service;

import com.doka.dokareporting.model.DailySummaryReport;
import com.doka.dokareporting.model.LimitReport;
import com.doka.dokareporting.model.MemberDeposit;
import com.doka.dokareporting.model.RetailerRefundAmountReport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EpReportsServiceImpl implements EpReportsService {
    @Override
    public DailySummaryReport dailySummaryReport(Integer retailerId, LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public List<LimitReport> limitReport(Integer retailerId) {
        return null;
    }

    @Override
    public List<MemberDeposit> memberDeposit(Integer retailerId, LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public List<RetailerRefundAmountReport> retailerRefundAmountReport(Integer retailerId, LocalDateTime start, LocalDateTime end) {
        return null;
    }
}
