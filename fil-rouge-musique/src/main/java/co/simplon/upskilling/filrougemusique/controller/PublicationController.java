package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.service.PublicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/publications")
public class PublicationController {

    private PublicationService publicationService;

    private PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public Page<Publication> getPublications(
            @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        return this.publicationService.getAllPublications(pageNumber, pageSize);
    }

    @GetMapping("/sort")
    public Page<Publication> getPublicationsSorted(
            @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @Valid @RequestParam(value = "sort", required = false) List<Sort.Order> sortCriteriaList) {
        return this.publicationService.getPublicationsSortedBySortCriteriaList
                (pageNumber, pageSize, sortCriteriaList);
    }

    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestBody Publication newPublication) {
        try {
            return ResponseEntity.ok(this.publicationService.savePublication(newPublication));
        } catch (MissingEntityException e) {
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
