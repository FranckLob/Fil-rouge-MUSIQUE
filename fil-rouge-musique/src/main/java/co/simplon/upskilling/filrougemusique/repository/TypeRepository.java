package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends PagingAndSortingRepository<Type,Long> {
}
