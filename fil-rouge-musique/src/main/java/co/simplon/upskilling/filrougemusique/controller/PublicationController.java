package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.exception.ExistingEntityException;
import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.service.PublicationService;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("api/publications")
@CrossOrigin("*")
public class PublicationController {

    private PublicationService publicationService;

    private PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public Page<Publication> getPublications(
            @ApiParam(value = "Query param for 'pageNumber'")   @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @ApiParam(value = "Query param for 'pageSize'")@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return this.publicationService.getAllPublications(pageNumber, pageSize);
    }

    @GetMapping("/sort")
    public Page<Publication> getPublicationsSortedBySortCriteria(
            @ApiParam(value = "Query param for 'pageNumber'") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @ApiParam(value = "Query param for 'pageSize'") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @ApiParam(value = "Query param for 'sortCriteria'") @Valid @RequestParam(value = "sortCriteria", required = false) String sortCriteria,
            @ApiParam(value = "Query param for 'sortDirection'") @Valid @RequestParam(value = "sortDirection", required = false) String sortDirection) {
        return this.publicationService.getPublicationsSortedBySortCriteria
                (pageNumber, pageSize, sortCriteria, sortDirection);
    }


    @GetMapping("/byartist/{artistId}")
    public Page<Publication> getPublicationsbyArtist(
            @ApiParam(value = "Query param for 'artistId'") @PathVariable(value = "artistId") Long artistId,
            @ApiParam(value = "Query param for 'pageNumber'") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @ApiParam(value = "Query param for 'pageSize'") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return this.publicationService.getFilteredPublicationsByArtist(artistId, pageNumber, pageSize);
    }

    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestBody Publication newPublication) {
        try {
                return ResponseEntity.ok(this.publicationService.savePublication(newPublication));
        } catch (MissingEntityException e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(456).build();
        } catch (ExistingEntityException e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(457).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Publication> updatePublication (@RequestBody Publication publicationToUpdate) {
        try {
            return ResponseEntity.ok(this.publicationService.savePublication(publicationToUpdate));
        } catch (MissingEntityException e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(456).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{publicationId}")
    public ResponseEntity<Publication> updatePublication(@RequestBody Publication publicationToUpdate,
                                                         @PathVariable Long publicationId) {
        try {
            Publication publicationRetrieved = publicationService.getPublicationById(publicationToUpdate.getId());
            if (publicationRetrieved !=null) {
                return ResponseEntity.ok(this.publicationService.savePublication(publicationRetrieved));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (MissingEntityException e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(456).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



    @DeleteMapping("/{publicationId}")
    public void deletePublication(@PathVariable Long publicationId) {
        this.publicationService.deletePublication(publicationId);
    }
}
