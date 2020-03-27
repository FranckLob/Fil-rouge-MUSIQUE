package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublicationService {

    /**
     * Get the complete list of publications
     *
     * @return the complete list
     */

    Page<Publication> getAllPublications(Integer pageNumber, Integer pageSize);

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


    /**
     * Get sorted by sortedCriteria and sortedDirection
     * @param pageNumber
     * @param pageSize
     * @param sortByCriteria
     * @param SortDirection
     * @return
     */
    Page<Publication> getPublicationsSortedBySortCriteria
            (Integer pageNumber, Integer pageSize,
             String sortByCriteria, String SortDirection);

    /**
     * Get the sorted list of publications regarding title
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criterion  the sorting criterion
     * @param direction  the sorting direction
     * @return a page object with the sorted list
     */

    Page<Publication> getSortedPublicationsByTitle(Long titleId, Integer pageNumber, Integer pageSize, String criterion, String direction);

    /**
     * Get the sorted list of publications regarding artist
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criterion  the sorting criterion
     * @param direction  the sorting direction
     * @return a page object with the sorted list
     */

    Page<Publication> getSortedPublicationsByArtist(Long artistId, Integer pageNumber, Integer pageSize, String criterion, String direction);

    /**
     * Get the sorted list of publications regarding title
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criterion  the sorting criterion
     * @param direction  the sorting direction
     * @return a page object with the sorted list
     */

    Page<Publication> getSortedPublicationsByArtwork(Long artworkId, Integer pageNumber, Integer pageSize, String criterion, String direction);

    Publication savePublication(Publication publication) throws Exception;

    void deletePublication(Long publicationId);

    Publication getPublicationsByAppUserAndArtistAndArtworkAndTitle(AppUser appUser,Artist artist, Artwork artwork, Title title);

}
