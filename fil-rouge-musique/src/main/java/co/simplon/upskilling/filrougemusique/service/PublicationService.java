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
    Page<Publication> getPublications(Pageable pageable);

    /**
     * Get the filtered list of publications regarding user
     *
     * @return the filtered list
     */
    Page<Publication> getFilteredPublicationsByAppUser(Long appUserId, Pageable pageable);

    /**
     * Get the filtered list of publications regarding artist
     *
     * @return the filtered list
     */
    List<Publication> getFilteredPublicationsByArtist(Artist artist, Pageable pageable);

    /**
     * Get the filtered list of publications regarding artwork
     *
     * @return the filtered list
     */
    List<Publication> getFilteredPublicationsByArtwork(Artwork artwork, Pageable pageable);

    /**
     * Get the filtered list of publications regarding title
     *
     * @return the filtered list
     */
    List<Publication> getFilteredPublicationsByTitle(Title title, Pageable pageable);

    /**
     * Get the filtered list of publications regarding style
     *
     * @return the filtered list
     */
    List<Publication> getFilteredPublicationsByStyle(Style style, Pageable pageable);

    /**
     * Get the filtered list of publications regarding type
     *
     * @return the filtered list
     */
    List<Publication> getFilteredPublicationsByType(Type type, Pageable pageable);

}
