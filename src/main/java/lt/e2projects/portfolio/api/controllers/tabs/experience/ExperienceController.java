package lt.e2projects.portfolio.api.controllers.tabs.experience;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.Workplace;
import lt.e2projects.portfolio.api.services.tabs.experience.ExperienceService;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Api(tags = {"Experience Tab Data"})
@Controller
@RequiredArgsConstructor
public class ExperienceController implements ExperienceMapping {

    private final ExperienceService service;

    @Override
    public List<Workplace> getWorkplaces() {
        return service.getDataObject();
    }

    @Override
    public String createWorkExperience(List<Workplace> workplaces) {
        return service.createDataObject(workplaces);
    }

    @Override
    public String addWorkplace(Workplace workplace) {
        return service.createDataObject(Collections.singletonList(workplace));
    }
}
