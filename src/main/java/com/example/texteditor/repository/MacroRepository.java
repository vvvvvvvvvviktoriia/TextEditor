package com.example.texteditor.repository;

import com.example.texteditor.model.Macro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacroRepository extends JpaRepository<Macro, Integer> {
}
