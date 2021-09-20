package lt.e2projects.portfolio.api.services.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
class FirestoreServiceImpl implements FirestoreService {

    private final Firestore firestore;

    @Override
    public DocumentSnapshot getFirstDocument(String collectionName) {
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

    @Override
    public String addDocumentAndGetId(String collectionName, Object object) {
        String documentId = "";
        ApiFuture<DocumentReference> addedDocRef = firestore.collection(collectionName).add(object);
        try {
            documentId = addedDocRef.get().getId();
        } catch (InterruptedException | ExecutionException e) {
            log.error("Can't save new document to Firestore in {} collection", collectionName, e);
        }
        return documentId;
    }
}
