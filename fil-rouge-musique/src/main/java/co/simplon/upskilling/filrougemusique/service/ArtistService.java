package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import co.simplon.upskilling.filrougemusique.model.Publication;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {

    /**
     * Create an Artist
     * @param artist
     * @return an Artist
     */
    Artist createArtist(Artist artist);

//    /**
//     * Get all Publications related to one Artist
//     * @param artist
//     * @return Page of Publications
//     */
//
//    Page<Publication> getPublicationsByArtist(Artist artist);

}
