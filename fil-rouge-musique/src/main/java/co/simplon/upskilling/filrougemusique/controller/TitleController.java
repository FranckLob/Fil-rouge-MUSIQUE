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
public class TitleController {
    TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
//    public ResponseEntity<List<Title>> getTitles() {
//        return ResponseEntity.ok(titleService.getTitles()) ;
// //       return titleService.getTitles() ;
    public Page<Title> getTitles(
        @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
        @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
            return this.titleService.getTitles(pageNumber, pageSize);

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
