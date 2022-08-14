package com.bmj.termsearcher.service;

import com.bmj.termsearcher.entity.Record;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bmj.termsearcher.repository.RecordRepository;

@Service
public class RecordService {

    private final RecordRepository repository;
    
    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }
    
    public List<Record> fetchRecordsByTerm(String term) {
        List<Record> list = repository.findByTermContaining(term);
        return list;
    }
}
