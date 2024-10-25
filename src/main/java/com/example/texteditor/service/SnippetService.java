package com.example.texteditor.service;

import com.example.texteditor.model.Snippet;
import java.util.List;

public interface SnippetService {
    Snippet createSnippet(Snippet snippet);
    Snippet getSnippetById(int id);
    List<Snippet> getAllSnippets();
    Snippet updateSnippet(int id, Snippet snippet);
    void deleteSnippet(int id);
}

