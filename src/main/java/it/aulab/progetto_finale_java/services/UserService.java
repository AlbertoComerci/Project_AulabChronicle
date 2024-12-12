package it.aulab.progetto_finale_java.services;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.aulab.progetto_finale_java.dtos.UserDto;
import it.aulab.progetto_finale_java.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

    //  Salva un nuovo utente tramite DTO
    void saveUser(UserDto userDto, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response);

    //  Riceve in input una email e ne cercerá l'utente
    User findUserByEmail(String email);

    User find(Long id);

}
