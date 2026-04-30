package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public String handleDatabaseError(Exception ex, Model model) {
        model.addAttribute("error", "Der Datenbankzugriff funktioniert aktuell nicht. Bitte stellen Sie sicher, dass die Datenbank (MySQL) gestartet ist.");
        return "error_db";
    }
}
