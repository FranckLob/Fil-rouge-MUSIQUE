package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.repository.AppUserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.management.OperatingSystemMXBean;
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
        return appUserRepository.save(appUserToBeCreated);
    }

//    @Override
//    public List<AppUser> getAppUsersSortedBySortCriteria(Sort sortCriteria) {
//        return appUserRepository.findAll ("nickName", "authorities");
//    }
//
    @Override
    public Optional<AppUser> getOneAppUserByNickname(String appUserNickname) {
        return appUserRepository.findOneByNickName(appUserNickname);
    }

    @Override
    public Optional<AppUser> getAppUserById(Long appUserId){
        Optional<AppUser> appUserOptional = appUserRepository.findById(appUserId);
        return  appUserOptional;
    }


    @Override
    public AppUser updateAppUser(AppUser appUserToBeUpdate) {
        Optional<AppUser> appUserOptional = appUserRepository.findById(appUserToBeUpdate.getId());
        if(appUserOptional.isPresent()){
            return appUserOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteAppUser(Long appUserIdToBeDeleted) {
        appUserRepository.deleteById(appUserIdToBeDeleted);
    }
}
