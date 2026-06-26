package com.uda.sdfinalbackend.dto;

import lombok.Data;
import java.time.LocalDate;

// What the client sends. No userSub - the server owns that.
@Data
public class JournalActivityRequest {
    private LocalDate date;
    private Integer hourSlot;
    private String description;
    private Integer enjoyment;
    private Integer importance;
}