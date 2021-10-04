package lt.e2projects.portfolio.api.services.profile;

import lombok.RequiredArgsConstructor;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.Profile;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ProfileServiceImpl implements ProfileService {

    private final FirestoreService repository;

    @Override
    public Profile getDataObject() {
        return (Profile) repository.get(CollectionName.PROFILE, Profile.class);
    }

    @Override
    public String createDataObject(Profile profile) {
        return repository.create(CollectionName.PROFILE, profile);
    }

    @Override
    public Profile updateDataObject(Profile profile) {
        return (Profile) repository.update(CollectionName.PROFILE, profile);
    }
}
