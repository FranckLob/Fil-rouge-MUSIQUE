package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artwork;
import co.simplon.upskilling.filrougemusique.repository.ArtworkRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtworkServiceImpl implements ArtworkService {

    private ArtworkRepository artworkRepository;

    public ArtworkServiceImpl(ArtworkRepository artworkRepository) {
        this.artworkRepository = artworkRepository;
    }

    @Override
    public List<Artwork> getAllArtworks() {
        return this.artworkRepository.findAll();
    }

    @Override
    public Artwork saveArtwork(Artwork artwork) {
        return this.artworkRepository.save(artwork);
    }
}
