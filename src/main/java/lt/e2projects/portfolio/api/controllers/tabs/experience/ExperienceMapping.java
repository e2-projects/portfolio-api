package lt.e2projects.portfolio.api.controllers.tabs.experience;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.constants.Path;
import lt.e2projects.portfolio.api.models.Workplace;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.TAB_EXPERIENCE)
public interface ExperienceMapping {

    @ApiOperation("Get all work experience data")
    @GetMapping
    List<Workplace> getWorkplaces();

    @ApiOperation("Create About Tab data")
    @PostMapping
    String createWorkExperience(@RequestBody List<Workplace> workplaces);

    @ApiOperation("Add new workplace")
    @PutMapping
    String addWorkplace(@RequestBody Workplace workplace);
}
