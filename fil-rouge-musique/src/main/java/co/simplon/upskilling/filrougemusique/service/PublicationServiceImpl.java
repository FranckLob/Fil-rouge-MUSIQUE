package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.*;
import co.simplon.upskilling.filrougemusique.repository.PublicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Page<Publication> getPublications(Pageable pageable) {
        return publicationRepository.findAll(pageable);
    }

//    @Override
//    public Page<Publication> getFilteredPublicationsByAppUser(Long appUserId, Pageable pageable) {
//        return publicationRepository.getPublicationsByAppUser_IdEquals(appUserId, pageable);
//    }
//
//    @Override
//    public List<Publication> getFilteredPublicationsByArtist(Artist artist) {
//        return null;
//    }
//
//    @Override
//    public List<Publication> getFilteredPublicationsByArtwork(Artwork artwork) {
//        return null;
//    }
//
//    @Override
//    public List<Publication> getFilteredPublicationsByTitle(Title title) {
//        return null;
//    }
//
//    @Override
//    public List<Publication> getFilteredPublicationsByStyle(Style style) {
//        return null;
//    }
//
//    @Override
//    public List<Publication> getFilteredPublicationsByType(Type type) {
//        return null;
//    }
}
