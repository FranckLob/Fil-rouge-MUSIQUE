package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TitleService {

    /**
     * Title list retrieval.
     *
     * @param pageNumber the page number to get
     * @param pageSize   the page size to choose
     * @param criterion  the sorting criterion
     * @param direction  the sorting direction
     * @return a page object with titles
     */
    Page<Title> getTitles(Integer pageNumber, Integer pageSize, String criterion, String direction);

    /**
     * For AnyUsers
     *
     * @param titleToCreate based on gitHub call
     * @return title created
     */

    Title createTitle(Title titleToCreate);

    /**
     * For Admin AppUsers only
     *
     * @param titleToDeleteId
     * @return void
     */
    void deleteTitle(Long titleToDeleteId);
}
