package com.example.mirrorbackend.Report;

import com.example.mirrorbackend.API.API;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/report")
public class ReportController {

    private final ReportService reportService;



    @GetMapping
    public ResponseEntity<List<Report>> getReports(){
        return ResponseEntity.status(HttpStatus.OK).body(reportService.getReports());

    }


    @PostMapping
    public ResponseEntity<API> addReport(@RequestBody @Valid Report report){
        // for now w/o principles

        reportService.addReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New Report Added" , 201));
    }



    // get report by id
    @GetMapping("reportId")
                          // report in singular
    public ResponseEntity getReport(@PathVariable String reportId){
        // check if null or not
        if(reportService.getReport(reportId) == null){
            return ResponseEntity.status(400).body(new API("Report not found or does not exist check Id",400));
        }
        return ResponseEntity.status(HttpStatus.OK).body(reportService.getReport(reportId));
    }

}

