package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.*;
import co.simplon.upskilling.filrougemusique.repository.PublicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<Publication> getPublications(Integer pageNumber, Integer pageSize) {
        return publicationRepository.findAll(PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

    @Override
    public Page<Publication> getFilteredPublicationsByAppUser(Long appUserId, Integer pageNumber, Integer pageSize) {
        return publicationRepository.getPublicationsByAppUser_IdEquals(appUserId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

    @Override
    public Page<Publication> getFilteredPublicationsByArtist(Long artistId, Integer pageNumber, Integer pageSize) {
        return publicationRepository.getPublicationsByArtist_IdEquals(artistId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

    @Override
    public Page<Publication> getFilteredPublicationsByArtwork(Long artworkId, Integer pageNumber, Integer pageSize) {
        return publicationRepository.getPublicationsByArtwork_IdEquals(artworkId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

    @Override
    public Page<Publication> getFilteredPublicationsByTitle(Long titleId, Integer pageNumber, Integer pageSize) {
        return publicationRepository.getPublicationsByTitle_IdEquals(titleId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

//    @Override
//    public List<Publication> getFilteredPublicationsByStyle(Style style) {
//        return null;
//    }
//
//    @Override
//    public List<Publication> getFilteredPublicationsByType(Type type) {
//        return null;
//    }

    public int returnPageNumber(Integer pageNumber) {
        return (pageNumber != null) ? pageNumber : 0;
    }

    public int returnPageSize(Integer pageSize, int size) {
        return (pageSize != null) ? pageSize : size;
    }
}