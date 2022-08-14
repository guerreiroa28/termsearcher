package com.bmj.termsearcher.repository;

import com.bmj.termsearcher.entity.Record;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByTermContaining(String term);
}
