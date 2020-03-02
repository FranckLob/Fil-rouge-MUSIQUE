package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.Title;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TitleRepository extends PagingAndSortingRepository<Title,Long> {
}
