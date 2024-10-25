package com.example.texteditor.service;

import com.example.texteditor.model.Document;
import java.util.List;

public interface DocumentService {
    Document createDocument(Document document);
    Document getDocumentById(int id);
    List<Document> getAllDocuments();
    Document updateDocument(int id, Document document);
    void deleteDocument(int id);
}

