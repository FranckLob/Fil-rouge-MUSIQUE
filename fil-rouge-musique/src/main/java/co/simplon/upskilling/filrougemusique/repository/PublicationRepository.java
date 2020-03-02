package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.model.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PublicationRepository extends PagingAndSortingRepository<Publication, Long> {

    Page<Publication> getPublicationsByArtistSetEquals

    Page<Publication> getPublicationsByAppUser_IdEquals(Long appUserId, Pageable pageable);


}