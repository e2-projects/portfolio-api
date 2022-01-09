package lt.e2projects.portfolio.api.controllers.tabs.about;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.tabs.AboutTabData;
import lt.e2projects.portfolio.api.services.tabs.about.AboutTabService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Api(tags = {"About Tab Data"})
@Controller
@RequiredArgsConstructor
public class AboutTabController implements AboutTabMapping {

    private final AboutTabService service;

    @Override
    public List<AboutTabData> getAboutData() {
        return service.getDataObject();
    }

    @Override
    public String createAboutData(List<AboutTabData> data) {
        return service.createDataObject(data);
    }
}
