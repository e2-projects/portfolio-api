package lt.e2projects.portfolio.api.controllers.social;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.SocialLinks;
import lt.e2projects.portfolio.api.services.social.SocialLinksService;
import org.springframework.stereotype.Controller;

@Api(tags = {"Social Links"})
@Controller
@RequiredArgsConstructor
public class SocialController implements SocialMapping {

    private final SocialLinksService socialLinksService;

    @Override
    public SocialLinks getSocialLinks() {
        return socialLinksService.getDataObject();
    }

    @Override
    public String createSocialLinks(String linkedin, String facebook, String stackOverflow, String gitHub) {
        return socialLinksService.createDataObject(
                SocialLinks.builder()
                        .linkedinUrl(linkedin)
                        .facebookUrl(facebook)
                        .overflowUrl(stackOverflow)
                        .githubUrl(gitHub)
                        .build()
        );
    }

    @Override
    public SocialLinks updateSocialLinks(String linkedin, String facebook, String stackOverflow, String gitHub) {
        return socialLinksService.updateDataObject(
                SocialLinks.builder()
                        .linkedinUrl(linkedin)
                        .facebookUrl(facebook)
                        .overflowUrl(stackOverflow)
                        .githubUrl(gitHub)
                        .build()
        );
    }

}
