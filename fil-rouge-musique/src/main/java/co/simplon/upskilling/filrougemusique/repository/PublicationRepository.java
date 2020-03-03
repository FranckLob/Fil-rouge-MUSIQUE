package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.model.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends PagingAndSortingRepository<Publication, Long> {

    Page<Publication> getPublicationsByAppUser_IdEquals(Long appUserId, Pageable pageable);

    Page<Publication> getPublicationsByArtist_IdEquals(Long artistId, Pageable pageable);

    Page<Publication> getPublicationsByArtwork_IdEquals(Long artworkId, Pageable pageable);

    Page<Publication> getPublicationsByTitle_IdEquals(Long titleId, Pageable pageable);

//    Page<Publication> getPublicationsByStyleId(Long styleId, Pageable pageable);
}