package lt.e2projects.portfolio.api.services.profile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.Profile;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class ProfileServiceImpl implements ProfileService {

    private final FirestoreService firestoreService;

    @Override
    public Profile getProfile() {
        Profile profile = null;
        var doc = firestoreService.getFirstDocument(CollectionName.PROFILE);
        if (doc != null && doc.exists()) {
            profile = doc.toObject(Profile.class);
        }
        return profile;
    }

    @Override
    public String createProfile(Profile profile) {
        return firestoreService.addDocumentAndGetId(CollectionName.PROFILE, profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        var valuesToUpdate = profile.getValuesMap();
        firestoreService.updateDocument(CollectionName.PROFILE, valuesToUpdate);
        return getProfile();
    }

}
