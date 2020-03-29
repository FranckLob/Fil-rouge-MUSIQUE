package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.model.Style;
import co.simplon.upskilling.filrougemusique.service.StyleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/style")
@CrossOrigin("*")
public class StyleController {
    StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping
    public List<Style> getAllTypes() {
        return this.styleService.getAllStyles();
    }
}
