package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.model.*;
import co.simplon.upskilling.filrougemusique.repository.PublicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    private ArtworkService artworkService;
    private ArtistService artistService;

    public PublicationServiceImpl(PublicationRepository publicationRepository,
                                  ArtworkService artworkService,
                                  ArtistService artistService) {
        this.publicationRepository = publicationRepository;
        this.artworkService = artworkService;
        this.artistService = artistService;
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

    public Page<Publication> getPublicationsSortedBySortCriteriaList(Integer pageNumber,
                                                               Integer pageSize,
                                                               List<Sort.Order> sortByCriteriaList) {
        // By default sort on AppUser nickName
        String sortingCriteriaDefault = "nickName";
        // By default sorting ascending, but if user explicitely choose desc, then sort descending
        Sort.Direction sortingDirectionDefault = Sort.Direction.ASC;

        // If sorting criteria matches an aliment field name, then use it for sorting
        Field[] fields = Publication.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }

        String sortByChosenCriteria = null;
        Sort.Direction sortByChosenDirection = null;
        Page<Publication> res = null;

        // If we had chosen a criteria list, we would have check each criteria (see below)
        for (int i = 0; i < sortByCriteriaList.size(); i++) {
            if (!(sortByCriteriaList.isEmpty()) && (possibleCriteria.contains(sortByCriteriaList.get(i)))) {
                sortByChosenCriteria = sortByCriteriaList.get(i).getProperty();
                sortByChosenDirection = sortByCriteriaList.get(i).getDirection();
                if (sortByChosenCriteria != null) {
                    if (sortByChosenDirection != null) {
                        res = publicationRepository.findAll(PageRequest.of(pageNumber, pageSize,
                                Sort.by(sortByChosenDirection, sortByChosenCriteria)));
                    } else
                        res = publicationRepository.findAll(PageRequest.of(pageNumber, pageSize,
                                Sort.by(sortingDirectionDefault, sortByChosenCriteria)));
                } else {
                    res = publicationRepository.findAll(PageRequest.of(pageNumber, pageSize,
                            Sort.by(sortingDirectionDefault, sortingCriteriaDefault)));
                }

            }
        }
        return res;
    }


    public Page<Publication> getSortedPublicationsByTitle(Long titleId, Integer pageNumber, Integer pageSize, String criterion, String direction) {
        return publicationRepository.getPublicationsByTitle_IdEquals(titleId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

    @Override
    public Page<Publication> getSortedPublicationsByArtist(Long artistId, Integer pageNumber, Integer pageSize, String criterion, String direction) {
        return publicationRepository.getPublicationsByTitle_IdEquals(artistId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));

    }

    @Override
    public Page<Publication> getSortedPublicationsByArtwork(Long artworkId, Integer pageNumber, Integer pageSize, String criterion, String direction) {
        return publicationRepository.getPublicationsByTitle_IdEquals(artworkId, PageRequest.of(returnPageNumber(pageNumber), returnPageSize(pageSize, 10)));
    }

    @Override
    public Publication savePublication(Publication publication) throws Exception {
        if (publication.getArtist() != null || publication.getArtwork() != null || publication.getTitle() != null) {
            if (publication.getArtwork() != null && !artworkService.getAllArtworks().contains(publication.getArtwork())) {
                artworkService.saveArtwork(publication.getArtwork());
            }
            // If Artist is provided (not null) and does not exist in Database(not found) => Create Artist
            if (publication.getArtist() != null) {
                if (artistService.getArtistByName(publication.getArtist().getName()) == null) {
                    artistService.createArtist(publication.getArtist());
                }
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
