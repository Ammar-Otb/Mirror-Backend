package com.example.mirrorbackend.Report;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;


    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    public void addReport(Report report) {
        reportRepository.save(report);
    }

//    get Report by id
    public Report getReport(String reportId) {
        return reportRepository.findById(reportId).get();//possible throw some error handling here
    }
}
