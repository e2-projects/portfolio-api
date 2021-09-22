package lt.e2projects.portfolio.api.controllers.profile;

import lt.e2projects.portfolio.api.models.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
interface ProfileMapping {

    String PROFILE = "/profile";
    // String PROFILE_UPDATE = "/profile/update";

    @GetMapping(PROFILE)
    Profile getProfile();

    @PostMapping(PROFILE)
    String createProfile(@RequestBody Profile profile);

    @PatchMapping(PROFILE)
    Profile updateProfile(
            @RequestHeader(required = false) String name,
            @RequestHeader(required = false) String surname,
            @RequestHeader(required = false) String position,
            @RequestHeader(required = false) String address,
            @RequestHeader(required = false) String companyName,
            @RequestHeader(required = false) String companyUrl
    );

}
