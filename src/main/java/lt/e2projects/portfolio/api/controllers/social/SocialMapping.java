package lt.e2projects.portfolio.api.controllers.social;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.models.SocialLinks;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
interface SocialMapping {

    String SOCIAL = "/social";

    @ApiOperation(
            value = "Get social links",
            notes = "Get social links from Firebase. Object is used in Portfolio UI navigation bar",
            response = SocialLinks.class
    )
    @GetMapping(SOCIAL)
    SocialLinks getSocialLinks();

    @ApiOperation(
            value = "Create social links object",
            notes = "Create social links object in Firebase. Object is used in Portfolio UI navigation bar",
            response = String.class
    )
    @PostMapping(SOCIAL)
    String createSocialLinks(@RequestHeader String linkedin,
                             @RequestHeader String facebook,
                             @RequestHeader String stackOverflow,
                             @RequestHeader String gitHub);

    @ApiOperation(
            value = "Update social links object",
            notes = "Update social links object in Firebase. Object is used in Portfolio UI navigation bar",
            response = SocialLinks.class
    )
    @PatchMapping(SOCIAL)
    SocialLinks updateSocialLinks(@RequestHeader(required = false) String linkedin,
                                  @RequestHeader(required = false) String facebook,
                                  @RequestHeader(required = false) String stackOverflow,
                                  @RequestHeader(required = false) String gitHub);
}
