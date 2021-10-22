package lt.e2projects.portfolio.api.controllers.tabs.skills;

import io.swagger.annotations.ApiOperation;
import lt.e2projects.portfolio.api.constants.Path;
import lt.e2projects.portfolio.api.models.SkillGroup;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public interface SkillsMapping {

    @ApiOperation(
            value = "Get created data for Skills Tab",
            notes = "Get data from Firebase. Object is used in Portfolio UI Skills tab",
            response = SkillGroup[].class
    )
    @GetMapping(Path.TAB_SKILLS)
    List<SkillGroup> getData();

    @ApiOperation(
            value = "Create data for Skills Tab",
            notes = "Create data object in Firebase and returns ID. Object is used in Portfolio UI Skills tab",
            response = String.class
    )
    @PostMapping(Path.TAB_SKILLS)
    String createData(@RequestBody List<SkillGroup> data);

}
