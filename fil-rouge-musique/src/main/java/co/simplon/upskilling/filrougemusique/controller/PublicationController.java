package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.service.PublicationService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
        return this.publicationService.getPublications(pageNumber, pageSize);
    }
}
