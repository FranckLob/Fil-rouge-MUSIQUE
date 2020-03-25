package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.service.PublicationService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public Page<Publication> getPublicationsSortedBySortCriteriaList(
            @ApiParam(value = "Query param for 'pageNumber'") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @ApiParam(value = "Query param for 'pageSize'") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @ApiParam(value = "Query param for 'sortCriteriaList'") @Valid @RequestParam(value = "sortCriteriaList", required = false) List<Sort.Order> sortCriteriaList) {
        return this.publicationService.getPublicationsSortedBySortCriteriaList
                (pageNumber, pageSize, sortCriteriaList);
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
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/publicationId")
    public void deletePublication(@PathVariable Long publicationId) {
        this.publicationService.deletePublication(publicationId);
    }
}
