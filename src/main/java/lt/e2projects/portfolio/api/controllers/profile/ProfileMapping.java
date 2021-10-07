package lt.e2projects.portfolio.api.controllers.profile;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.models.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
interface ProfileMapping {

    String PROFILE = "/profile";
    // String PROFILE_UPDATE = "/profile/update";

    @ApiOperation(
            value = "Get profile",
            notes = "Get profile from Firebase. Object is used in Portfolio UI Home tab",
            response = Profile.class
    )
    @GetMapping(PROFILE)
    Profile getProfile();

    @ApiOperation(
            value = "Create profile",
            notes = "Create profile object in Firebase. Object is used in Portfolio UI Home tab",
            response = String.class
    )
    @PostMapping(PROFILE)
    String createProfile(@RequestBody Profile profile);

    @ApiOperation(
            value = "Update profile",
            notes = "Update profile object in Firebase. Object is used in Portfolio UI Home tab",
            response = Profile.class
    )
    @PatchMapping(PROFILE)
    Profile updateProfile(
            @RequestHeader(required = false) String name,
            @RequestHeader(required = false) String surname,
            @RequestHeader(required = false) String position
    );
}
