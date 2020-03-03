package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Style;
import org.springframework.stereotype.Service;

@Service
public interface StyleService {

    /**
     * For AnyUsers
     * @param styleToCreate
     * @return type created
     */

    Style createStyle(Style styleToCreate);


    /**
     * For Admin AppUsers only
     * @param styleToDeleteId
     * @return
     * void
     */
    void deleteStyle(Long styleToDeleteId);
}
