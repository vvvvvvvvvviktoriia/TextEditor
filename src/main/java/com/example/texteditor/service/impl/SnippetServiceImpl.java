package com.example.texteditor.service.impl;

import com.example.texteditor.model.Snippet;
import com.example.texteditor.repository.SnippetRepository;
import com.example.texteditor.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnippetServiceImpl implements SnippetService {

    private final SnippetRepository snippetRepository;

    @Autowired
    public SnippetServiceImpl(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    @Override
    public Snippet createSnippet(Snippet snippet) {
        return snippetRepository.save(snippet);
    }

    @Override
    public Snippet getSnippetById(int id) {
        Optional<Snippet> snippet = snippetRepository.findById(id);
        return snippet.orElseThrow(() -> new RuntimeException("Snippet not found with id " + id));
    }

    @Override
    public List<Snippet> getAllSnippets() {
        return snippetRepository.findAll();
    }

    @Override
    public Snippet updateSnippet(int id, Snippet snippet) {
        if (snippetRepository.existsById(id)) {
            snippet.setId(id);
            return snippetRepository.save(snippet);
        }
        throw new RuntimeException("Snippet not found with id " + id);
    }

    @Override
    public void deleteSnippet(int id) {
        if (snippetRepository.existsById(id)) {
            snippetRepository.deleteById(id);
        } else {
            throw new RuntimeException("Snippet not found with id " + id);
        }
    }
}
