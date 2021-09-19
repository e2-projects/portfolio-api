package lt.e2projects.portfolio.api.controllers;

import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.Profile;
import lt.e2projects.portfolio.api.services.profile.ProfileService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class DataController implements DataMapping {

    private final ProfileService service;

    @Override
    public Profile getProfile() {
        return service.getProfile();
    }
}
