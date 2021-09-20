package lt.e2projects.portfolio.api.controllers;

import lt.e2projects.portfolio.api.models.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
interface DataMapping {

    String PROFILE = "/profile";

    @GetMapping(PROFILE)
    Profile getProfile();

    @PostMapping(PROFILE)
    String createProfile(@RequestBody Profile profile);

}
