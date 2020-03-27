package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.model.Authority;
import co.simplon.upskilling.filrougemusique.model.AuthorityLevel;
import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser createAppUser(AppUser appUserToBeCreated) {

            // For new User, Initialization of Authority to ROLE_USER
            Authority defaultAuthority = new Authority();
            defaultAuthority.setId(2L);
            defaultAuthority.setAuthority(AuthorityLevel.USER);
            List<Authority> authorities = new ArrayList<>();
            authorities.add(defaultAuthority);
            appUserToBeCreated.setAuthorities(authorities);

            // For new User, initialization of List of Publications to empty
            List<Publication> publications = new ArrayList<>();
            appUserToBeCreated.setPublicationList(publications);
            // update database
            return appUserRepository.save(appUserToBeCreated);
    }

    @Override
    public List<AppUser> getAllAppUsers(){return appUserRepository.findAll();}

    @Override
    public Optional<AppUser> getOneAppUserByNickname(String appUserNickname) {
        return appUserRepository.findOneByNickName(appUserNickname);
    }

    @Override
    public Optional<AppUser> getAppUserById(Long appUserId){
        return appUserRepository.findById(appUserId);
    }

    @Override
    public List<AppUser> getAllAppUsersByAuthority(String authority) {
        return appUserRepository.findAppUserByAuthorities(authority);
    }

    @Override
    public AppUser updateAppUser(AppUser appUserToBeUpdate) {
        Optional<AppUser> appUserOptional = appUserRepository.findById(appUserToBeUpdate.getId());
        if(appUserOptional.isPresent()){
            return appUserRepository.save(appUserOptional.get());
        } else {
            return null;
        }
    }

    @Override
    public void deleteAppUser(Long appUserIdToBeDeleted) {
        appUserRepository.deleteById(appUserIdToBeDeleted);
    }
}
