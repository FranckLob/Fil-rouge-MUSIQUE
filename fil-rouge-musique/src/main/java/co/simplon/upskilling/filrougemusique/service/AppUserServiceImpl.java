package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.repository.AppUserRepository;
import org.springframework.stereotype.Service;

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
        Optional<AppUser> appUserOptional = appUserRepository.findById(appUserToBeCreated.getId());
        if (!(appUserOptional.isPresent())) {
            return appUserRepository.save(appUserOptional.get());
        } else {
            return null;
        }
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
        return appUserRepository.findAllByAuthorities(authority);
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
