package com.example.texteditor.service.impl;

import com.example.texteditor.model.History;
import com.example.texteditor.repository.HistoryRepository;
import com.example.texteditor.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History createHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History getHistoryById(int id) {
        Optional<History> history = historyRepository.findById(id);
        return history.orElseThrow(() -> new RuntimeException("History not found with id " + id));
    }

    @Override
    public List<History> getAllHistoryRecords() {
        return historyRepository.findAll();
    }

    @Override
    public History updateHistory(int id, History history) {
        if (historyRepository.existsById(id)) {
            history.setId(id);
            return historyRepository.save(history);
        }
        throw new RuntimeException("History not found with id " + id);
    }

    @Override
    public void deleteHistory(int id) {
        if (historyRepository.existsById(id)) {
            historyRepository.deleteById(id);
        } else {
            throw new RuntimeException("History not found with id " + id);
        }
    }
}
