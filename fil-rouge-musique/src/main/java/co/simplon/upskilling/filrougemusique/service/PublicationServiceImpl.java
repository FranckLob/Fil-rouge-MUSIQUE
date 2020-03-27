package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.exception.ExistingEntityException;
import co.simplon.upskilling.filrougemusique.model.*;
import co.simplon.upskilling.filrougemusique.repository.PublicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    private ArtworkService artworkService;
    private ArtistService artistService;
    private TitleService titleService;

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
    public Page<Publication> getPublicationsSortedBySortCriteria(Integer pageNumber,
                                                                 Integer pageSize,
                                                                 String sortByCriteria,
                                                                 String sortDirection) {
        // By default sort on AppUser nickName
        String sortingCriteriaDefault = "appUser";
        // By default sorting ascending, but if user explicitely choose desc, then sort descending
        Sort.Direction sortingDirectionDefault = Sort.Direction.ASC;

        // If sorting criteria matches an aliment field name, then use it for sorting
        Field[] fields = Publication.class.getDeclaredFields();
        List<String> possibleCriteria = new ArrayList<>();
        for (Field field : fields) {
            possibleCriteria.add(field.getName().toLowerCase());
        }

        // If we had chosen a criteria list, we would have check each criteria (see below)
        if (!(sortByCriteria.isEmpty() && (possibleCriteria.contains(sortByCriteria)))) {
            sortingCriteriaDefault = sortByCriteria;
        }

        if (sortDirection != null) {
            sortingDirectionDefault = sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        }

        return publicationRepository.findAll(PageRequest.of(returnPageNumber(pageNumber),returnPageSize(pageSize,10),
                Sort.by(sortingDirectionDefault, sortingCriteriaDefault)));
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
    public Publication getPublicationsByAppUserAndArtistAndArtworkAndTitle(AppUser appUser, Artist artist, Artwork artwork, Title title) {
        Optional<Publication> publicationOptional = publicationRepository.getPublicationsByAppUserAndArtistAndArtworkAndTitle(appUser, artist, artwork, title);
        if (publicationOptional.isPresent()){
            return publicationOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public Publication savePublication(Publication publication) throws Exception {
        if (publication.getArtist() != null || publication.getArtwork() != null || publication.getTitle() != null){
             // If Artist is provided (not null) and does not exist in Database(not found) => Create Artist
            if (publication.getArtist() != null) {
                if (artistService.getArtistByName(publication.getArtist().getName()) == null) {
                    publication.setArtist(artistService.createArtist(publication.getArtist()));
                }
                else {  publication.setArtist(artistService.getArtistByName(publication.getArtist().getName()));}
            }
            if (publication.getArtwork() != null) {
                if (artworkService.getArtworkByName(publication.getArtwork().getName()) == null) {
                    publication.setArtwork(artworkService.saveArtwork(publication.getArtwork()));
                }
                else {  publication.setArtwork(artworkService.getArtworkByName(publication.getArtwork().getName()));}
            }
            if (publication.getTitle() != null) {
                if (titleService.getTitleByName(publication.getTitle().getName()) == null) {
                    publication.setTitle(titleService.createTitle(publication.getTitle()));
                }
                else {  publication.setTitle(titleService.getTitleByName(publication.getTitle().getName()));}
            }

            //creer slt si pub inexistante
            if (getPublicationsByAppUserAndArtistAndArtworkAndTitle(publication.getAppUser(),publication.getArtist(),publication.getArtwork(),publication.getTitle()) == null) {
                return publicationRepository.save(publication);
            }
            else {
                throw new ExistingEntityException("Publication déjà existante");
            }
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

    private int returnPageSize(Integer pageSize, int sizeDefault) {
        return (pageSize != null) ? pageSize : sizeDefault;
    }

}
