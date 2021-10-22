package lt.e2projects.portfolio.api.services.skills;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2projects.portfolio.api.constants.CollectionName;
import lt.e2projects.portfolio.api.models.SkillGroup;
import lt.e2projects.portfolio.api.services.repository.FirestoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
class SkillsServiceImpl implements SkillsService {

    private final FirestoreService repository;

    @Override
    public List<SkillGroup> getDataObject() {
        List<SkillGroup> skillGroups = new ArrayList<>();
        try {
            var db = repository.getFirestore();
            var future = db.collection(CollectionName.TAB_SKILLS).orderBy("position").get();
            future.get().getDocuments().forEach(docSnapshot ->
                skillGroups.add(docSnapshot.toObject(SkillGroup.class))
            );
        } catch (InterruptedException | ExecutionException e) {
            log.error("Can't get document list from Firestore {} collection", CollectionName.TAB_SKILLS, e);
        }
        return skillGroups;
    }

    @Override
    public String createDataObject(List<SkillGroup> skillGroups) {
        var position = new AtomicInteger(0);
        skillGroups.forEach(skillGroup -> {
            position.getAndIncrement();
            skillGroup.setPosition(position.get());
            repository.create(CollectionName.TAB_SKILLS, skillGroup);
        });
        return "";
    }

    @Override
    public List<SkillGroup> updateDataObject(List<SkillGroup> dataObject) {
        return Collections.emptyList();
    }

}
