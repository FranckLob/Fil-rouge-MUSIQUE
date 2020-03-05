package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.repository.ArtistRepository;
import co.simplon.upskilling.filrougemusique.repository.PublicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist createArtist(Artist artist) {
        // If artist already exist => do not create it inside of Artist table
        if(artistRepository.findById(artist.getId()) == null){
            artistRepository.save(artist);
        }
        return artist;
    }

//    @Override
//    public Page<Publication> getPublicationsByArtist(Artist artist) {
//        return publicationRepository.findPublicationsByArtist(artist);
//    }

}

