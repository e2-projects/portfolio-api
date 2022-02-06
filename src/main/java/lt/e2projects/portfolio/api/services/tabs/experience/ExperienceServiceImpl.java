package lt.e2projects.portfolio.api.services.tabs.experience;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.Workplace;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
class ExperienceServiceImpl implements ExperienceService {

    private final FirestoreService repository;

    @Override
    public List<Workplace> getDataObject() {
        List<Workplace> data = new ArrayList<>();
        try {
            var db = repository.getFirestore();
            var future = db.collection(CollectionName.TAB_EXPERIENCE).get();
            future.get().getDocuments().forEach(docSnapshot ->
                    data.add(docSnapshot.toObject(Workplace.class))
            );
        } catch (InterruptedException | ExecutionException e) {
            log.error("Can't get document list from Firestore {} collection", CollectionName.TAB_EXPERIENCE, e);
        }
        return data;
    }

    @Override
    public String createDataObject(List<Workplace> dataObject) {
        StringBuilder builder = new StringBuilder();
        dataObject.forEach(object -> builder.append("ID: ").append(repository.create(CollectionName.TAB_EXPERIENCE, object)).append("; "));
        return builder.toString();
    }

    @Override
    public List<Workplace> updateDataObject(List<Workplace> dataObject) {
        return Collections.emptyList();
    }
}
