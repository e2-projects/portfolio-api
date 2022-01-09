package lt.e2projects.portfolio.api.services.tabs.about;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.tabs.AboutTabData;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
class AboutTabServiceImpl implements AboutTabService {

    private final FirestoreService repository;

    @Override
    public List<AboutTabData> getDataObject() {
        List<AboutTabData> data = new ArrayList<>();
        try {
            var db = repository.getFirestore();
            var future = db.collection(CollectionName.TAB_ABOUT).get();
            future.get().getDocuments().forEach(docSnapshot ->
                    data.add(docSnapshot.toObject(AboutTabData.class))
            );
        } catch (InterruptedException | ExecutionException e) {
            log.error("Can't get document list from Firestore {} collection", CollectionName.TAB_ABOUT, e);
        }
        return data;
    }

    @Override
    public String createDataObject(List<AboutTabData> dataObject) {
        StringBuilder builder = new StringBuilder("| ");
        dataObject.forEach(object -> builder.append(repository.create(CollectionName.TAB_ABOUT, object)).append(" | "));
        return builder.toString();
    }

    @Override
    public List<AboutTabData> updateDataObject(List<AboutTabData> dataObject) {
        return Collections.emptyList();
    }
}
