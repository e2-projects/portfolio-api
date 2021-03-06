package lt.e2projects.portfolio.api.controllers.tabs.about;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.constants.Path;
import lt.e2projects.portfolio.api.models.tabs.AboutTabData;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public interface AboutTabMapping {

    @ApiOperation("Get About Tab data")
    @GetMapping(Path.TAB_ABOUT)
    List<AboutTabData> getAboutData();

    @ApiOperation("Create About Tab data")
    @PostMapping(Path.TAB_ABOUT)
    String createAboutData(@RequestBody List<AboutTabData> data);

}
