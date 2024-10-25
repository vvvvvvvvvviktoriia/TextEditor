package com.example.texteditor.service.impl;

import com.example.texteditor.model.Macro;
import com.example.texteditor.repository.MacroRepository;
import com.example.texteditor.service.MacroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MacroServiceImpl implements MacroService {

    private final MacroRepository macroRepository;

    @Autowired
    public MacroServiceImpl(MacroRepository macroRepository) {
        this.macroRepository = macroRepository;
    }

    @Override
    public Macro createMacro(Macro macro) {
        return macroRepository.save(macro);
    }

    @Override
    public Macro getMacroById(int id) {
        Optional<Macro> macro = macroRepository.findById(id);
        return macro.orElseThrow(() -> new RuntimeException("Macro not found with id " + id));
    }

    @Override
    public List<Macro> getAllMacros() {
        return macroRepository.findAll();
    }

    @Override
    public Macro updateMacro(int id, Macro macro) {
        if (macroRepository.existsById(id)) {
            macro.setId(id);
            return macroRepository.save(macro);
        }
        throw new RuntimeException("Macro not found with id " + id);
    }

    @Override
    public void deleteMacro(int id) {
        if (macroRepository.existsById(id)) {
            macroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Macro not found with id " + id);
        }
    }
}
