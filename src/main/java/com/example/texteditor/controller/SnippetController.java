package com.example.texteditor.controller;

import com.example.texteditor.model.Snippet;
import com.example.texteditor.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippets")
public class SnippetController {

    private final SnippetService snippetService;

    @Autowired
    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @PostMapping
    public ResponseEntity<Snippet> createSnippet(@RequestBody Snippet snippet) {
        return new ResponseEntity<>(snippetService.createSnippet(snippet), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snippet> getSnippetById(@PathVariable int id) {
        Snippet snippet = snippetService.getSnippetById(id);
        return snippet != null ? ResponseEntity.ok(snippet) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Snippet>> getAllSnippets() {
        return ResponseEntity.ok(snippetService.getAllSnippets());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable int id, @RequestBody Snippet snippetDetails) {
        Snippet updatedSnippet = snippetService.updateSnippet(id, snippetDetails);
        return updatedSnippet != null ? ResponseEntity.ok(updatedSnippet) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSnippet(@PathVariable int id) {
        snippetService.deleteSnippet(id);
        return ResponseEntity.noContent().build();
    }
}
