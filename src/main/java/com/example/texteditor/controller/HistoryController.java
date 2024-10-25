package com.example.texteditor.controller;

import com.example.texteditor.model.History;
import com.example.texteditor.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping
    public ResponseEntity<History> createHistoryRecord(@RequestBody History history) {
        return new ResponseEntity<>(historyService.createHistory(history), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable int id) {
        History history = historyService.getHistoryById(id);
        return history != null ? ResponseEntity.ok(history) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<History>> getAllHistoryRecords() {
        return ResponseEntity.ok(historyService.getAllHistoryRecords());
    }

    @PutMapping("/{id}")
    public ResponseEntity<History> updateHistoryRecord(@PathVariable int id, @RequestBody History historyDetails) {
        History updatedHistory = historyService.updateHistory(id, historyDetails);
        return updatedHistory != null ? ResponseEntity.ok(updatedHistory) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoryRecord(@PathVariable int id) {
        historyService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
}

