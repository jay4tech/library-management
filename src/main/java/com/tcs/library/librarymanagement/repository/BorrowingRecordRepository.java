package com.tcs.library.librarymanagement.repository;

import com.tcs.library.librarymanagement.entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long>{

}
