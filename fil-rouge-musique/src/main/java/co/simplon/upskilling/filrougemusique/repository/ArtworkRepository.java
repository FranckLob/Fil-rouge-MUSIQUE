package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}
