package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.repository.ArtistRepository;

import java.util.List;

public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;
  //  private PublicationRepository publicationRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);

    }

//    @Override
//    public List<Artist> getArtistsByPublication(Publication publication) {
//        return publicationRepository.findAllBy(Publication publication);
//    }

}

