package com.example.texteditor.service.impl;

import com.example.texteditor.model.Document;
import com.example.texteditor.repository.DocumentRepository;
import com.example.texteditor.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(int id) {
        Optional<Document> document = documentRepository.findById(id);
        return document.orElseThrow(() -> new RuntimeException("Document not found with id " + id));
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document updateDocument(int id, Document document) {
        if (documentRepository.existsById(id)) {
            document.setId(id);
            return documentRepository.save(document);
        }
        throw new RuntimeException("Document not found with id " + id);
    }

    @Override
    public void deleteDocument(int id) {
        if (documentRepository.existsById(id)) {
            documentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Document not found with id " + id);
        }
    }
}