package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
}
