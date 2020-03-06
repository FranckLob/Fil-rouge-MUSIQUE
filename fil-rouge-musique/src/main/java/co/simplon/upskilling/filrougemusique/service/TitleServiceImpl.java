package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.exception.InvalidSortingCriterionException;
import co.simplon.upskilling.filrougemusique.model.Title;
import co.simplon.upskilling.filrougemusique.repository.TitleRepository;
import co.simplon.upskilling.filrougemusique.utility.Reflection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleServiceImpl implements TitleService {

    private TitleRepository titleRepository;


    public TitleServiceImpl(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @Override
    public Page<Title> getTitles(Integer pageNumber, Integer pageSize, String criterion, String direction) {
        if (!Reflection.isFieldName(Title.class, criterion)) {
            throw new InvalidSortingCriterionException(Title.class.getName(), criterion);
        }
        Sort.Direction sortingDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return titleRepository.findAll(PageRequest.of((pageNumber != null) ? pageNumber : 0,
                (pageSize != null) ? pageSize : 10,
                Sort.by(sortingDirection, criterion)));
    }

    @Override
    public Title createTitle(Title titleToCreate) {
        return titleRepository.save(titleToCreate);
    }

    @Override
    public void deleteTitle(Long titleToDeleteId) {
        titleRepository.deleteById(titleToDeleteId);
    }

}
