package lt.e2projects.portfolio.api.controllers.tabs.home;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.models.Company;
import lt.e2projects.portfolio.api.models.tabs.HomeTabData;
import org.springframework.stereotype.Controller;

@Api(tags = {"Home Tab Data"})
@Controller
@RequiredArgsConstructor
public class HomeTabController implements HomeTabMapping {

    @Override
    public HomeTabData getData() {
        return null;
    }

    @Override
    public String createData(HomeTabData data) {
        return null;
    }

    @Override
    public HomeTabData updateProfile(String fullName, String position, String address, String description,
                                     String companyName, String companyUrl) {
        HomeTabData.builder()
                .fullName(fullName)
                .position(position)
                .address(address)
                .description(description)
                .company(Company.builder()
                        .name(companyName)
                        .url(companyUrl)
                        .build());
        return null;
    }
}
