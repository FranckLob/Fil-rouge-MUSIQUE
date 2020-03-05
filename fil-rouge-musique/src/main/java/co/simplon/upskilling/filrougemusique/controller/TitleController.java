package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.model.Title;
import co.simplon.upskilling.filrougemusique.service.TitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        public List<Title> getTitles() {
//        return ResponseEntity.ok(titleService.getTitles()) ;
        return titleService.getTitles() ;
    }

    @PostMapping("/{titleid}")
    public ResponseEntity<Title> createTitle(@RequestBody Title titleToCreate) {
        try {
            return ResponseEntity.ok(titleService.createTitle(titleToCreate));
        } catch (Exception e){
//            return ResponseEntity.badRequest().build();
//            return (ResponseEntity<Title>) ResponseEntity.badRequest();
            return ResponseEntity.badRequest().header("title is not valid ! ").build();
        }
    }

}
