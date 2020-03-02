package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Type;
import org.springframework.stereotype.Service;

@Service
public interface TypeService {

    Type createType(Type typeToCreate);

    void deleteType(Long typeToDeleteId);
}
