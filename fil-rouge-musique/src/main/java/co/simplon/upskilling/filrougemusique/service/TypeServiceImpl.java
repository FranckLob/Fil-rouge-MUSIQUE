package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Type;
import co.simplon.upskilling.filrougemusique.repository.TypeRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type createType(Type typeToCreate){
        return typeRepository.save(typeToCreate);
    }

    @Override
    public void deleteType(Long typeToDeleteId){
        typeRepository.deleteById(typeToDeleteId);
    }
}
