package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import co.simplon.upskilling.filrougemusique.model.Publication;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArtistService {

    /**
     * Create an Artist
     * @param artist
     * @return an Artist
     */
    Artist createArtist(Artist artist);

    /**
     * Find Artist by its Name (name being unique)
     * @param artistName
     * @return
     * One optional Artist
     */
    Artist getArtistByName(String artistName);

//    /**
//     * Get all Publications related to one Artist
//     * @param artist
//     * @return Page of Publications
//     */
//
//    Page<Publication> getPublicationsByArtist(Artist artist);

}
