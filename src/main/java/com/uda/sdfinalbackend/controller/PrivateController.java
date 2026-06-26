package com.uda.sdfinalbackend.controller;

import com.uda.sdfinalbackend.dto.JournalActivityRequest;
import com.uda.sdfinalbackend.model.Item;
import com.uda.sdfinalbackend.model.JournalActivity;
import com.uda.sdfinalbackend.service.ItemService;
import com.uda.sdfinalbackend.service.JournalActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/private")
@RequiredArgsConstructor
public class PrivateController {

    private final ItemService itemService;
    private final JournalActivityService journalActivityService;

    // testing endpoints below. i used them in the beginning of the project. might remove later. might not. who knows
    @GetMapping("/hello")
    public Map<String, String> hello(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "message", "Hola, usuario autenticado!",
                "subject", jwt.getSubject()
        );
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.findAll();
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    // journal activity endpoints

    @GetMapping("/activities")
    public List<JournalActivity> getActivities(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @AuthenticationPrincipal Jwt jwt) {
        return journalActivityService.findByDate(jwt.getSubject(), date);
    }

    @PostMapping("/activities")
    public JournalActivity createActivity(
            @RequestBody JournalActivityRequest req,
            @AuthenticationPrincipal Jwt jwt) {
        return journalActivityService.create(req, jwt.getSubject());
    }

    @PutMapping("/activities/{id}")
    public JournalActivity updateActivity(
            @PathVariable Long id,
            @RequestBody JournalActivityRequest req,
            @AuthenticationPrincipal Jwt jwt) {
        return journalActivityService.update(id, req, jwt.getSubject());
    }

    @DeleteMapping("/activities/{id}")
    public void deleteActivity(
            @PathVariable Long id,
            @AuthenticationPrincipal Jwt jwt) {
        journalActivityService.delete(id, jwt.getSubject());
    }
}