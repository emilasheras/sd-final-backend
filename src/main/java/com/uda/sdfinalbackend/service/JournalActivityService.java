package com.uda.sdfinalbackend.service;

import com.uda.sdfinalbackend.dto.JournalActivityRequest;
import com.uda.sdfinalbackend.model.JournalActivity;
import com.uda.sdfinalbackend.repository.JournalActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalActivityService {

    private final JournalActivityRepository repository;

    public List<JournalActivity> findByDate(String userSub, LocalDate date) {
        return repository.findByUserSubAndDateOrderByHourSlotAsc(userSub, date);
    }

    public JournalActivity create(JournalActivityRequest req, String userSub) {
        JournalActivity activity = new JournalActivity();
        activity.setUserSub(userSub);          // server sets this, not the client
        activity.setDate(req.getDate());
        activity.setHourSlot(req.getHourSlot());
        activity.setDescription(req.getDescription());
        activity.setEnjoyment(req.getEnjoyment());
        activity.setImportance(req.getImportance());
        return repository.save(activity);
    }

    public JournalActivity update(Long id, JournalActivityRequest req, String userSub) {
        JournalActivity activity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found: " + id));
        if (!activity.getUserSub().equals(userSub)) {
            throw new SecurityException("Forbidden");   // data-level authorization
        }
        activity.setDate(req.getDate());
        activity.setHourSlot(req.getHourSlot());
        activity.setDescription(req.getDescription());
        activity.setEnjoyment(req.getEnjoyment());
        activity.setImportance(req.getImportance());
        return repository.save(activity);
    }

    public void delete(Long id, String userSub) {
        JournalActivity activity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found: " + id));
        if (!activity.getUserSub().equals(userSub)) {
            throw new SecurityException("Forbidden");
        }
        repository.deleteById(id);
    }
}