package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.model.Authority;
import co.simplon.upskilling.filrougemusique.model.AuthorityLevel;

import co.simplon.upskilling.filrougemusique.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AuthorityServiceImpl implements AuthorityService {

//    private AuthorityRepository authorityRepository;
//
//
//    public AuthorityServiceImpl(AuthorityRepository authorityRepository){
//        this.authorityRepository = authorityRepository;
//    }
//
//    @Override
//    public void deleteAuthority(Long authorityId) {
//        authorityRepository.deleteById(authorityId);
//    }
//
//    @Override
//    public Authority updateAuthorityForUser(AppUser appUser) {
//        Optional<Authority> authorityOptional = authorityRepository.findOneByAppUsers(appUser);
//
//        if(authorityOptional.isPresent()){
//            return authorityRepository.save(authorityOptional.get());
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public List<Authority> getAuthorityAll() {
//        return authorityRepository.findAll();
//    }
//
//    @Override
//    public Optional<Authority> getAppUserAuthority(AppUser appUser) {
//        Optional<Authority> authorityOptional = authorityRepository.findOneByAppUsers(appUser);
//        return authorityOptional;
//    }
}
