package com.backend.librarymanagementsystem.Repository;

import com.backend.librarymanagementsystem.Entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecordRepository extends JpaRepository<Record,Integer> {
}
