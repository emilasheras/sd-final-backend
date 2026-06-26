package com.uda.sdfinalbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "journal_activities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userSub;      // Auth0 subject - set server-side, never from request
    private LocalDate date;
    private Integer hourSlot;    // 0–23 (start of the hour slot)
    private String description;
    private Integer enjoyment;   // 0–10
    private Integer importance;  // 0–10
}