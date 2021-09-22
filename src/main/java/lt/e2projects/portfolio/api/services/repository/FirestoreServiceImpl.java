package lt.e2projects.portfolio.api.services.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
class FirestoreServiceImpl implements FirestoreService {

    private final Firestore firestore;

    @Override
    public DocumentSnapshot getFirstDocument(String collectionName) {
        DocumentSnapshot snapshot = null;
        var documentRef = getDocumentReferenceFromCollection(collectionName);
        if (documentRef != null) {
            try {
                var apiFuture = documentRef.get();
                snapshot = apiFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Can't fetch document from Firestore from {} collection", collectionName, e);
            }
        }
        return snapshot;
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

    @Override
    public void updateDocument(String collectionName, Map<String, Object> valuesMap) {
        getDocumentReferenceFromCollection(collectionName).update(valuesMap);
    }

    private DocumentReference getDocumentReferenceFromCollection(String collectionName) {
        return firestore.collection(collectionName).listDocuments().iterator().next();
    }

}
