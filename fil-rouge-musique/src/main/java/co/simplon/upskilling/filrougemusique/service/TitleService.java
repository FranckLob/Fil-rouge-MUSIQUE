package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Title;
import org.springframework.stereotype.Service;

@Service
public interface TitleService {

    /**
     * For AnyUsers
     * @param titleToCreate based on gitHub call
     * @return title created
     */
    Title createTitle(Title titleToCreate);

    /**
     * For Admin AppUsers only
     * @param titleToDeleteId
     * @return
     * void
     */
    void deleteTitle(Long titleToDeleteId);


}
