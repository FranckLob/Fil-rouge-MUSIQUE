package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.model.*;
import co.simplon.upskilling.filrougemusique.repository.PublicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    private ArtworkService artworkService;

    public PublicationServiceImpl(PublicationRepository publicationRepository, ArtworkService artworkService) {
        this.publicationRepository = publicationRepository;
        this.artworkService = artworkService;
    }

    @Override
    public Page<Publication> getAllPublications(Integer pageNumber, Integer pageSize) {
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

    @Override
    public Publication savePublication(Publication publication) throws Exception {
        if (publication.getArtist() != null || publication.getArtwork() != null || publication.getTitle() != null) {
            if (publication.getArtwork() != null && !artworkService.getAllArtworks().contains(publication.getArtwork())) {
                artworkService.saveArtwork(publication.getArtwork());
            }
            return publicationRepository.save(publication);
        } else {
            throw new MissingEntityException("Au moins un des 3 champs, artiste, album, titre, doit être renseigné.");
        }
    }

    @Override
    public void deletePublication(Long publicationId) {
        publicationRepository.deleteById(publicationId);
    }

    private int returnPageNumber(Integer pageNumber) {
        return (pageNumber != null) ? pageNumber : 0;
    }

    private int returnPageSize(Integer pageSize, int size) {
        return (pageSize != null) ? pageSize : size;
    }

}
