package com.bmj.termsearcher.response;

import com.bmj.termsearcher.entity.Record;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ResponseTest {
    
    private static final List<Record> RECORDS = List.of(
            new Record("record1 containing term", 1.0), 
            new Record("record2 containing term", 2.0), 
            new Record("record3 containing term", 3.75));
    
    @Test
    public void testResponse_constructor() {
        Response response = new Response(RECORDS);
        assertEquals(6.75, response.getTotalHours());
        assertEquals(RECORDS, response.getMatchingRecords());
    }
}
