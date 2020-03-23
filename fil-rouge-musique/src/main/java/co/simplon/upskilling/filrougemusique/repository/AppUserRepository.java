package co.simplon.upskilling.filrougemusique.repository;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository <AppUser, Long> {

    List<AppUser> findAppUserByAuthorities(String authority);

    Optional<AppUser> findOneByNickName(String appUserNickname);
}
