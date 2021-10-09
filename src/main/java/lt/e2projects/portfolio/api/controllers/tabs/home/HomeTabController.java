package lt.e2projects.portfolio.api.controllers.tabs.home;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.Company;
import lt.e2projects.portfolio.api.models.tabs.HomeTabData;
import lt.e2projects.portfolio.api.services.tabs.home.HomeTabService;
import org.springframework.stereotype.Controller;

@Api(tags = {"Home Tab Data"})
@Controller
@RequiredArgsConstructor
public class HomeTabController implements HomeTabMapping {

    private final HomeTabService service;

    @Override
    public HomeTabData getData() {
        return service.getDataObject();
    }

    @Override
    public String createData(HomeTabData data) {
        return service.createDataObject(data);
    }

    @Override
    public HomeTabData updateProfile(String fullName, String position, String address, String description,
                                     String companyName, String companyUrl) {
        return service.updateDataObject(HomeTabData.builder()
                .fullName(fullName)
                .position(position)
                .address(address)
                .description(description)
                .company(Company.builder()
                        .name(companyName)
                        .url(companyUrl)
                        .build())
                .build());
    }
}
