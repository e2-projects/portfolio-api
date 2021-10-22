package lt.e2projects.portfolio.api.controllers.tabs.skills;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.SkillGroup;
import lt.e2projects.portfolio.api.services.skills.SkillsService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Api(tags = {"Skills Tab Data"})
@Controller
@RequiredArgsConstructor
public class SkillsController implements SkillsMapping {

    private final SkillsService service;

    @Override
    public List<SkillGroup> getData() {
        return service.getDataObject();
    }

    @Override
    public String createData(List<SkillGroup> data) {
        return service.createDataObject(data);
    }
}
