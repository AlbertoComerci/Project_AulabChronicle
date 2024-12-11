package it.aulab.progetto_finale_java.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.aulab.progetto_finale_java.models.Role;
import it.aulab.progetto_finale_java.models.User;
import it.aulab.progetto_finale_java.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // System.out.println("Attempting to load user with email: " + username);

        User user = userRepository.findByEmail(username);
        if (user == null) {

            // System.out.println("User not found in the database.");

            throw new UsernameNotFoundException("Invalid credentials");
        } 
        // else {

        //      System.out.println("User details retrieved - Email: " + user.getEmail() + ", Password: " + user.getPassword());

        // }

        // System.out.println("Creating CustomUserDetails for user - Email: " + user.getEmail());

        return new CustomUserDetails(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRoles())
        );
    }


// questa funzione mappa i ruoli collegati al nostro utente.
// La funzione include anche un controllo per assegnare un ruolo predefinito agli utenti che non sono associati a nessun ruolo specifico. A questi utenti viene quindi assegnata 
// l'autorizzazione pari a quella di uno "user".

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

        Collection<? extends GrantedAuthority> mapRoles = null;

        if(roles.size() != 0) {
            mapRoles = roles.stream()    
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        } else {
            mapRoles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return mapRoles;
    }

    

}
