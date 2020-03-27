package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title,Long> {
}
