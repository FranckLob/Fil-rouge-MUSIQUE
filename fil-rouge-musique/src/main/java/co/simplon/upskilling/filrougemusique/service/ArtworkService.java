package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artwork;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ArtworkService {

    List<Artwork> getAllArtworks();

    Artwork getArtworkByName(String artworkName);

    Artwork saveArtwork(Artwork artwork);
}
