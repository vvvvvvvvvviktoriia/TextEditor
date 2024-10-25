package com.example.texteditor.controller;

import com.example.texteditor.model.Macro;
import com.example.texteditor.service.MacroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/macros")
public class MacroController {

    private final MacroService macroService;

    @Autowired
    public MacroController(MacroService macroService) {
        this.macroService = macroService;
    }

    @PostMapping
    public ResponseEntity<Macro> createMacro(@RequestBody Macro macro) {
        return new ResponseEntity<>(macroService.createMacro(macro), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Macro> getMacroById(@PathVariable int id) {
        Macro macro = macroService.getMacroById(id);
        return macro != null ? ResponseEntity.ok(macro) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Macro>> getAllMacros() {
        return ResponseEntity.ok(macroService.getAllMacros());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Macro> updateMacro(@PathVariable int id, @RequestBody Macro macroDetails) {
        Macro updatedMacro = macroService.updateMacro(id, macroDetails);
        return updatedMacro != null ? ResponseEntity.ok(updatedMacro) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMacro(@PathVariable int id) {
        macroService.deleteMacro(id);
        return ResponseEntity.noContent().build();
    }
}
