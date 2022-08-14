package com.bmj.termsearcher.service;


import com.bmj.termsearcher.entity.Record;
import com.bmj.termsearcher.repository.RecordRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RecordServiceTest {
    
    private static final String TERM = "term";
    private static final List<Record> RECORDS = List.of(
            new Record("record1 containing term", 1.0), 
            new Record("record2 containing term", 1.0), 
            new Record("record3 containing term", 1.0));
    
    private RecordService service;
    
    
    @BeforeEach
    public void setup() {
        RecordRepository repository = mock(RecordRepository.class);
        when(repository.findByTermContaining(anyString())).thenReturn(List.of());
        when(repository.findByTermContaining(TERM)).thenReturn(RECORDS);
        service = new RecordService(repository);
    }

    @Test
    public void testRecordService_fetchesRecords() {
        List<Record> records = service.fetchRecordsByTerm(TERM);
        assertEquals(RECORDS, records);
    }
    
    @Test
    public void testRecordService_fetchesNoRecords() {
        List<Record> records = service.fetchRecordsByTerm("non existing term");
        assertEquals(List.of(), records);
    }
    
}