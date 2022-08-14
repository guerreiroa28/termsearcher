package com.bmj.termsearcher.response;

import com.bmj.termsearcher.entity.Record;
import java.util.LinkedList;
import java.util.List;

public class Response {
    private double totalHours;
    private final List<Record> matchingRecords;
    
    public Response(List<Record> records) {
        this.totalHours = 0.0;
        this.matchingRecords = new LinkedList<>();       
        for(Record record: records) {
            this.totalHours += record.getHours();
            this.matchingRecords.add(record);
        }
    }

    public double getTotalHours() {
        return totalHours;
    }
        
    public List<Record> getMatchingRecords() {
        return matchingRecords;
    }
}
