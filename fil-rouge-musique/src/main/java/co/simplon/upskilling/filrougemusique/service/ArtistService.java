package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import org.springframework.stereotype.Service;

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

}
