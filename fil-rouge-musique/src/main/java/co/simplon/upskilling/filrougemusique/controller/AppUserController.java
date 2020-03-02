package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.model.AppUser;
import co.simplon.upskilling.filrougemusique.service.AppUserService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/share_music/user")
@CrossOrigin("*")
public class AppUserController {

    private AppUserService appUserService;

    public AppUserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<AppUser> createAppUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.createAppUser(appUser));
    }

    @GetMapping("{sortBy}")
    public ResponseEntity<List<AppUser>> getAllAppUsersBySortCriteria(@RequestParam Sort sortBy) {
        return ResponseEntity.ok(appUserService.getAppUsersSortedBySortCriteria(sortBy));
    }

    @GetMapping("/nickname")
    public ResponseEntity<AppUser> getAppUserByNickName(@RequestBody String nickName) {
        Optional<AppUser> appUserOptional = appUserService.getOneAppUserByNickname(nickName);
        if(appUserOptional.isPresent()) {
            return ResponseEntity.ok(appUserOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser appUser){
        Optional<AppUser> appUserOptional = appUserService.getAppUserById(appUser.getId());
        if(appUserOptional.isPresent()){
            return ResponseEntity.ok(appUserOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
