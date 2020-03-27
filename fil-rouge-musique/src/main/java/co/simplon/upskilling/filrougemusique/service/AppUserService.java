package co.simplon.upskilling.filrougemusique.service;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface AppUserService {

    /**
     * For AnyUsers
     * @param appUserToBeCreated based on gitHub call
     * @return
     * AppUser created
     */
    AppUser createAppUser(AppUser appUserToBeCreated);

//    /**
//     * for Admin AppUsers only :
//     * @return
//     * get complete list of AppUsers sorted by sortCriteria below :
//     * - nickname (to be able to delete them if needed)
//     * - authorityLevel
//     */
//    List<AppUser> getAppUsersSortedBySortCriteria(Sort sortCriteria);

    /**
     * For Admin only :
     * @return
     * Get List of all AppUsers
     */
    List<AppUser> getAllAppUsers();

    /**
     * For Admin only
     * @param authority
     * @return
     * get list of User having a defined authority
     */
    List<AppUser> getAllAppUsersByAuthority(String authority);
    /**
     * For AnyUsers
     * @param appUserId based on gitHub call
     * @return
     * AppUser Optionnal
     */
    Optional<AppUser> getAppUserById (Long appUserId);

    /**
     * for Admin AppUsers only :
     * @param appUserNickname to be searched based on its nickname
     * @return
     * get the AppUser from its nickname
     */

    Optional<AppUser> getOneAppUserByNickname(String appUserNickname);

    /**
     * For AnyUsers
     * @param appUserToBeUpdate based on gitHub call
     * @return
     * AppUser updated
     */
    AppUser updateAppUser(AppUser appUserToBeUpdate);

    /**
     * For Admin AppUsers only
     * @param appUserIdToBeDeleted
     * @return
     * void
     */
    void deleteAppUser (Long appUserIdToBeDeleted);

}
