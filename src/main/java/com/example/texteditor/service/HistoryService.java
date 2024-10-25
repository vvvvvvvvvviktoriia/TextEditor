package com.example.texteditor.service;

import com.example.texteditor.model.History;
import java.util.List;

public interface HistoryService {
    History createHistory(History history);
    History getHistoryById(int id);
    List<History> getAllHistoryRecords();
    History updateHistory(int id, History history);
    void deleteHistory(int id);
}
