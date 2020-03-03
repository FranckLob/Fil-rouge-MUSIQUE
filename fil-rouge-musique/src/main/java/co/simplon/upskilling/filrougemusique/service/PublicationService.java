package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublicationService {

    /**
     * Get the complete list of publications
     *
     * @return the complete list
     */
    Page<Publication> getPublications(Integer pageNumber, Integer pageSize);

    /**
     * Get the filtered list of publications regarding user
     *
     * @return the filtered list
     */
    Page<Publication> getFilteredPublicationsByAppUser(Long appUserId, Integer pageNumber, Integer pageSize);

    /**
     * Get the filtered list of publications regarding artist
     *
     * @return the filtered list
     */
    Page<Publication> getFilteredPublicationsByArtist(Long artistId, Integer pageNumber, Integer pageSize);

    /**
     * Get the filtered list of publications regarding artwork
     *
     * @return the filtered list
     */
    Page<Publication> getFilteredPublicationsByArtwork(Long artworkId, Integer pageNumber, Integer pageSize);

    /**
     * Get the filtered list of publications regarding title
     *
     * @return the filtered list
     */
    Page<Publication> getFilteredPublicationsByTitle(Long titleId, Integer pageNumber, Integer pSize);

//    /**
//     * Get the filtered list of publications regarding style
//     *
//     * @return the filtered list
//     */
//    List<Publication> getFilteredPublicationsByStyle(Style style, Pageable pageable);
//
//    /**
//     * Get the filtered list of publications regarding type
//     *
//     * @return the filtered list
//     */
//    List<Publication> getFilteredPublicationsByType(Type type, Pageable pageable);

}
