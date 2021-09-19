package lt.e2projects.portfolio.api.controllers;

import lt.e2projects.portfolio.api.models.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public interface DataMapping {

    String PROFILE = "/profile";

    @GetMapping(PROFILE)
    Profile getProfile();

}
