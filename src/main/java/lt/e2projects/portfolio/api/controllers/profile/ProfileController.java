package lt.e2projects.portfolio.api.controllers.profile;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.Company;
import lt.e2projects.portfolio.api.models.Profile;
import lt.e2projects.portfolio.api.services.profile.ProfileService;
import org.springframework.stereotype.Controller;

@Api(tags = {"Profile"})
@Controller
@RequiredArgsConstructor
public class ProfileController implements ProfileMapping {

    private final ProfileService service;

    @Override
    public Profile getProfile() {
        return service.getDataObject();
    }

    @Override
    public String createProfile(Profile profile) {
        return service.createDataObject(profile);
    }

    @Override
    public Profile updateProfile(String name,
                                 String surname,
                                 String position,
                                 String address,
                                 String companyName,
                                 String companyUrl) {
        return service.updateDataObject(
                Profile.builder()
                        .name(name)
                        .surname(surname)
                        .position(position)
                        .address(address)
                        .company(Company.builder()
                                .name(companyName)
                                .url(companyUrl)
                                .build()
                        )
                        .build()
        );
    }
}
