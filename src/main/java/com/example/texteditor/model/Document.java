package com.example.texteditor.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String filename;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String encoding;

    @Column(nullable = false)
    private String syntaxHighlight;

    @CreationTimestamp  // Эта аннотация автоматически задаст время создания
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp  // Эта аннотация автоматически обновит время при изменении
    @Column(nullable = false)
    private Timestamp updatedAt;

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getSyntaxHighlight() {
        return syntaxHighlight;
    }

    public void setSyntaxHighlight(String syntaxHighlight) {
        this.syntaxHighlight = syntaxHighlight;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
