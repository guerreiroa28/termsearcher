package com.bmj.termsearcher.controller;

import com.bmj.termsearcher.entity.Record;
import com.bmj.termsearcher.response.Response;
import com.bmj.termsearcher.service.RecordService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("termsearcher")
public class RecordController {
    
    private static Logger logger = LoggerFactory.getLogger(RecordController.class);
    
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }
    
    @GetMapping("/quicksearch")
    public ResponseEntity<List<Record>> showRecords(@RequestParam String term) {
        logger.info("Querying database for a list of records containing the term '{}'", term);
        List<Record> records = recordService.fetchRecordsByTerm(term);
        logger.info("Fetched '{}' results", records.size());
        return new ResponseEntity(records, HttpStatus.OK);
    }
    
    @GetMapping("/search")
    public ResponseEntity<Response> showRecordsWithTotalHours(@RequestParam String term) {
        logger.info("Querying database with term '{}' and computing total hours", term);
        List<Record> records = recordService.fetchRecordsByTerm(term);
        Response content = new Response(records);
        logger.info("Fetched '{}' results with hours summing up to {}", records.size(), 
                content.getTotalHours());
        return new ResponseEntity(content, HttpStatus.OK);
    }
}
