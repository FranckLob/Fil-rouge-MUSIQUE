package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import co.simplon.upskilling.filrougemusique.model.Publication;
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
//     * Get all Artists related to one publication
//     * @param publication
//     * @return List of Artists
//     */
//
//    List<Artist> getArtistsByPublication(Publication publication);

}
