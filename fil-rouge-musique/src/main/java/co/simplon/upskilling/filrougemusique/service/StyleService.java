package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Style;
import org.springframework.stereotype.Service;

@Service
public interface StyleService {

    Style createStyle(Style styleToCreate);

    void deleteStyle(Long StyleToDeleteId);
}
