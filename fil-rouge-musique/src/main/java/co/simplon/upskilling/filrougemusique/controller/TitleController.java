package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.exception.MissingEntityException;
import co.simplon.upskilling.filrougemusique.model.Title;
import co.simplon.upskilling.filrougemusique.service.TitleService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/title")
@CrossOrigin("*")
public class TitleController {
    TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    /**
     * Controller method enabling Title list retrieval with pagination and sorting.
     *
     * @param pageNumber the page number we want to get (default is 0)
     * @param pageSize   the page size we want to define (default is 10)
     * @param criterion   the sorting criterion (default is name)
     * @param direction  the sorting direction (default is ascending)
     * @return a Page object containing Titles.
     */
    @GetMapping
    public Page<Title> getTitles(
        @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
        @Valid @RequestParam(value = "sort", defaultValue = "name") String criterion,
        @Valid @RequestParam(value = "direction", defaultValue = "asc") String direction){
            return this.titleService.getTitles(pageNumber, pageSize, criterion, direction);
        }

    @PostMapping
    public ResponseEntity<Title> createTitle(@RequestBody Title titleToCreate) {
        try {
            return ResponseEntity.ok(titleService.createTitle(titleToCreate));
        } catch (Exception e){
            return ResponseEntity.badRequest().header("title is not valid ! ").build();
        }
    }

    @DeleteMapping("/{titleId}")
    public void deleteTitle(@PathVariable Long titleId) {
        this.titleService.deleteTitle(titleId);
    }


}
