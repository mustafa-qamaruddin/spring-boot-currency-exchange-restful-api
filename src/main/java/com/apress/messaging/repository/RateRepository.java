package com.apress.messaging.repository;

import java.util.Date;
import java.util.List;
import com.apress.messaging.domain.Rate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, String> {
    
    List<Rate> findByDate(Date date);
    Rate findByDateAndCode(Date date, String code);
}