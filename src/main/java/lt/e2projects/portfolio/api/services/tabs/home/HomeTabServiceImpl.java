package lt.e2projects.portfolio.api.services.tabs.home;

import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.tabs.HomeTabData;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class HomeTabServiceImpl implements HomeTabService {

    private final FirestoreService repository;

    @Override
    public HomeTabData getDataObject() {
        return (HomeTabData) repository.get(CollectionName.TAB_HOME, HomeTabData.class);
    }

    @Override
    public String createDataObject(HomeTabData tabData) {
        return repository.create(CollectionName.TAB_HOME, tabData);
    }

    @Override
    public HomeTabData updateDataObject(HomeTabData tabData) {
        return (HomeTabData) repository.update(CollectionName.TAB_HOME, tabData);
    }

}
