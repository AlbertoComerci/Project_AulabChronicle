package it.aulab.progetto_finale_java.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//? Questa classe contiene tutti i metodi che indicano se un utente è attivo in piattaforma poiché indicano se l’account non è scaduto, se le credenziali non sono scadute, se 
//? l’account non è bloccato e se è abilitato
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String password;
    
    //? la Collection può contenere oggetti di qualsiasi classe che estende o implementa l'interfaccia GrantedAuthority
    //? authorities è l'insieme di autorizzazioni o ruoli di un utente
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //? restituisce l'insieme di autorizzazioni o ruoli di un utente
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return username;
    }

}
