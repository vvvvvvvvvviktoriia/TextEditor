package com.example.texteditor.service;

import com.example.texteditor.model.Macro;
import java.util.List;

public interface MacroService {
    Macro createMacro(Macro macro);
    Macro getMacroById(int id);
    List<Macro> getAllMacros();
    Macro updateMacro(int id, Macro macro);
    void deleteMacro(int id);
}
