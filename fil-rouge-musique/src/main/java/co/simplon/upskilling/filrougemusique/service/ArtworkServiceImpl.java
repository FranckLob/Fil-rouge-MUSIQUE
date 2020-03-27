package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artwork;
import co.simplon.upskilling.filrougemusique.repository.ArtworkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Artwork getArtworkByName(String artworkName) {
        Optional<Artwork> artworkOptional = artworkRepository.findArtworkByName(artworkName);
        if (artworkOptional.isPresent()){
            return artworkOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Artwork saveArtwork(Artwork artwork) {
        return this.artworkRepository.save(artwork);
    }
}
