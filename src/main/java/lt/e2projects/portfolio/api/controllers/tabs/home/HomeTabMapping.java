package lt.e2projects.portfolio.api.controllers.tabs.home;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.constants.Path;
import lt.e2projects.portfolio.api.models.tabs.HomeTabData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
interface HomeTabMapping {

    @ApiOperation(
            value = "Get created data for Home Tab",
            notes = "Get data from Firebase. Object is used in Portfolio UI Home tab",
            response = HomeTabData.class
    )
    @GetMapping(Path.TAB_HOME)
    HomeTabData getData();

    @ApiOperation(
            value = "Create data for Home Tab",
            notes = "Create data object in Firebase and returns ID. Object is used in Portfolio UI Home tab",
            response = String.class
    )
    @PostMapping(Path.TAB_HOME)
    String createData(@RequestBody HomeTabData data);

    @ApiOperation(
            value = "Update data for Home Tab",
            notes = "Update data object in Firebase. Object is used in Portfolio UI Home tab",
            response = HomeTabData.class
    )
    @PatchMapping(Path.TAB_HOME)
    HomeTabData updateProfile(
            @RequestHeader(required = false) String fullName,
            @RequestHeader(required = false) String position,
            @RequestHeader(required = false) String address,
            @RequestHeader(required = false) String description,
            @RequestHeader(required = false) String companyName,
            @RequestHeader(required = false) String companyUrl
    );

}
