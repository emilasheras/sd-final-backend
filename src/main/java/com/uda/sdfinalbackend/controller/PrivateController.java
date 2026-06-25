package com.uda.sdfinalbackend.controller;

import com.uda.sdfinalbackend.model.Item;
import com.uda.sdfinalbackend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * @AuthenticationPrincipal Jwt jwt - Spring Security injects the decoded JWT object here automatically.
 * jwt.getSubject() returns the Auth0 user ID (e.g. google-oauth2|1234... or auth0|1234...).
 */
@RestController
@RequestMapping("/api/private")
@RequiredArgsConstructor
public class PrivateController {

    private final ItemService itemService;

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
}