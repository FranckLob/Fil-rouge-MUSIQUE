package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.Title;
import co.simplon.upskilling.filrougemusique.repository.TitleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Title createTitle(Title titleToCreate) {
        return titleRepository.save(titleToCreate);
    }

    @Override
    public void deleteTitle(Long titleToDeleteId) {
        titleRepository.deleteById(titleToDeleteId);
    }

    @Override
    public Page<Title> getTitles(Integer pageNumber, Integer pageSize) {
        return titleRepository.findAll(PageRequest.of((pageNumber != null) ? pageNumber : 0,
                                                      (pageSize != null)   ? pageSize  : 10));
    }

}
