package com.example.copsboot.report.web;

import com.example.copsboot.infrastructure.security.ApplicationUserDetails;
import com.example.copsboot.report.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {

    private final ReportService reportService;

    public ReportRestController(ReportService reportService){

        this.reportService = reportService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReportDto createReport(@AuthenticationPrincipal ApplicationUserDetails userDetails,
                                  // @Valid // Removed to accept multipart/form-data
                                  @RequestBody CreateReportParameters parameters) {

        return ReportDto.fromReport(reportService.createReport(userDetails.getUserId(),
                parameters.getDateTime(),
                parameters.getDescription(),
                parameters.getImage()));
    }
}
