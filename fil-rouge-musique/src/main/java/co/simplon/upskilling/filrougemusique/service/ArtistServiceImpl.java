package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Artist;
import co.simplon.upskilling.filrougemusique.repository.ArtistRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist getArtistByName(String artistName) {
        Optional<Artist> artistOptional = artistRepository.findArtistByName(artistName);
        if (artistOptional.isPresent()){
            return artistOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Artist createArtist(Artist artist) {
        // If artist already exist => do not create it inside of Artist table
        //if id==null then save
        if(artist.getId() == null){
            return artistRepository.save(artist);
        }
        return artist;
    }
}

