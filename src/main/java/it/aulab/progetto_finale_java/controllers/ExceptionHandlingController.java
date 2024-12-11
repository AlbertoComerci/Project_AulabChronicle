package it.aulab.progetto_finale_java.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.qos.logback.core.model.Model;

public class ExceptionHandlingController {

    // Rotta per la gestione e cattura di errori
    @GetMapping("/error/{number}")
    public String accessDenied(@PathVariable int number, Model model) {

        // un metodo dinamico che riceve il codice dell’errore ed attiva delle logiche, l’unica attualmente presente se 
        // il codice è “403“ reindirizza l’utente verso la pagina home con un messaggio flash che specifica di non essere autorizzati
        if(number == 403) {
            return "redirect:/?notAuthorized";
        }

        return "redirect:/";
        
    }

}
