package it.aulab.progetto_finale_java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.progetto_finale_java.models.Image;
import jakarta.transaction.Transactional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    // Transazionale poichè fa dei check di avvenuta operazione, in caso contrario torna tutto come se l’operazione non fosse mai avvenuta
    @Transactional
    void deleteByPath(String imageUrl);

}
