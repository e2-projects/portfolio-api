package lt.e2projects.portfolio.api.controllers.profile;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.constants.Path;
import lt.e2projects.portfolio.api.models.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
interface ProfileMapping {

    @ApiOperation(
            value = "Get profile",
            notes = "Get profile from Firebase. Object is used in Portfolio UI navigation bar",
            response = Profile.class
    )
    @GetMapping(Path.PROFILE)
    Profile getProfile();

    @ApiOperation(
            value = "Create profile",
            notes = "Create profile object in Firebase. Object is used in Portfolio UI navigation bar",
            response = String.class
    )
    @PostMapping(Path.PROFILE)
    String createProfile(@RequestBody Profile profile);

    @ApiOperation(
            value = "Update profile",
            notes = "Update profile object in Firebase. Object is used in Portfolio UI navigation bar",
            response = Profile.class
    )
    @PatchMapping(Path.PROFILE)
    Profile updateProfile(
            @RequestHeader(required = false) String name,
            @RequestHeader(required = false) String surname,
            @RequestHeader(required = false) String position
    );
}
