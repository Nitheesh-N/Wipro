package com.playstore.user.controller;

import com.playstore.user.dto.AppSummary;
import com.playstore.user.service.AppSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apps")
@CrossOrigin(origins = "*")
public class AppSearchController {

    private final AppSearchService service;

    public AppSearchController(AppSearchService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<List<AppSummary>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Double minRating
            ) {

        return ResponseEntity.ok(service.search(name, genre, minRating));
    }
}
