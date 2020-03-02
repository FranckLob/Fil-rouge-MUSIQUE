package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Title;
import org.springframework.stereotype.Service;

@Service
public interface TitleService {
    Title createTitle(Title titleToCreate);

    void deleteTitle(Long TitleToDeleteId);


}
