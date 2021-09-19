package lt.e2projects.portfolio.api.services.profile;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.Profile;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
class ProfileServiceImpl implements ProfileService {

    private final Firestore firestore;

    @Override
    public Profile getProfile() {
        Profile profile = null;
        var doc = getFirstDocument(CollectionName.PROFILE);
        if (doc != null && doc.exists()) {
            profile = doc.toObject(Profile.class);
        }
        return profile;
    }

    private DocumentSnapshot getFirstDocument(String collectionName) {
        CollectionReference profileList = firestore.collection(collectionName);
        var list = profileList.listDocuments();
        var iterator = list.iterator();
        if (iterator.hasNext()) {
            try {
                var apiFuture = iterator.next().get();
                return apiFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Can't fetch document from Firestore from {} collection", collectionName, e);
            }
        }
        return null;
    }
}
