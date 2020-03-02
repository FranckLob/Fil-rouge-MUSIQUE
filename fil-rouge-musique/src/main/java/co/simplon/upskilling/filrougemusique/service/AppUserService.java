package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.AppUser;

import java.util.List;

public interface AppUserService {

    /**
     * for Admin AppUsers only :
     * @return
     * get complete list of AppUsers (to be able to delete them if needed)
     */
    List<AppUser> getAppUsers();

    /**
     * for Admin AppUsers only :
     * @param AppUserNickname to be searched based on its nickname
     * @return
     * get the AppUser from its nickname
     */

    AppUser getAppUserByNickname(String AppUserNickname);

    /**
     * For AnyUsers
     * @param appUserToBeCreated based on gitHub call
     * @return
     * AppUser created
     */
    AppUser createAppUser(AppUser appUserToBeCreated);


    /**
     * For Admin AppUsers only
     * @param appUserToBeDeleted
     * @return
     * boolean indicatiing creation OK/KO
     */
    boolean deleteAppUser (AppUser appUserToBeDeleted);

    
}
