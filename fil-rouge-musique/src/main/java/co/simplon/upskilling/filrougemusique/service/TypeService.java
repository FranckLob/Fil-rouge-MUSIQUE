package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Type;
import org.springframework.stereotype.Service;

@Service
public interface TypeService {

    /**
     * For AnyUsers
     * @param typeToCreate based on gitHub call
     * @return type created
     */
    Type createType(Type typeToCreate);

    /**
     * For Admin AppUsers only
     * @param typeToDeleteId
     * @return
     * void
     */
    void deleteType(Long typeToDeleteId);
}