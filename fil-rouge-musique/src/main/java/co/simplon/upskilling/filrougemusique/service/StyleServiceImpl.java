package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Style;
import co.simplon.upskilling.filrougemusique.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {

    private StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public Style createStyle(Style styleToCreate) {
        return styleRepository.save(styleToCreate);
    }

    @Override
    public void deleteStyle(Long styleToDeleteId) {
        styleRepository.deleteById(styleToDeleteId);
    }

    @Override
    public List<Style> getAllStyles() {
        return this.styleRepository.findAll();
    }
}
