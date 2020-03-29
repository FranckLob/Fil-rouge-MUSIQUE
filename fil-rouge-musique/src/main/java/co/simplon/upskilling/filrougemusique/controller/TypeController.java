package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.model.Type;
import co.simplon.upskilling.filrougemusique.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type")
@CrossOrigin("*")
public class TypeController {
    TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> getAllTypes() {
        return this.typeService.getAllTypes();
    }
}