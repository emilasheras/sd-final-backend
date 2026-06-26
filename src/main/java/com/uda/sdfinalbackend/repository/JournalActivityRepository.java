package com.uda.sdfinalbackend.repository;

import com.uda.sdfinalbackend.model.JournalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface JournalActivityRepository extends JpaRepository<JournalActivity, Long> {

    // Spring Data derives: WHERE user_sub = ? AND date = ? ORDER BY hour_slot ASC
    List<JournalActivity> findByUserSubAndDateOrderByHourSlotAsc(String userSub, LocalDate date);
}