package lt.e2projects.portfolio.api.services.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.e2projects.portfolio.api.models.FirebaseObject;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
class FirestoreServiceImpl implements FirestoreService {

    private final Firestore firestore;

    @Override
    public Firestore getFirestore() {
        return firestore;
    }

    @Override
    public Object get(String collection, Class<?> clazz) {
        Object object = null;
        var doc = getFirstDocument(collection);
        if (doc != null && doc.exists()) {
            object = doc.toObject(clazz);
        }
        return object;
    }

    @Override
    public String create(String collectionName, Object object) {
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
    public Object update(String collectionName, FirebaseObject object) {
        var valuesMap = object.valuesMap();
        getDocumentReferenceFromCollection(collectionName).update(valuesMap);
        return get(collectionName, object.getClass());
    }

    private DocumentSnapshot getFirstDocument(String collectionName) {
        var documentRef = getDocumentReferenceFromCollection(collectionName);
        return getDocumentSnapshot(collectionName, documentRef);
    }

    private DocumentReference getDocumentReferenceFromCollection(String collectionName) {
        return firestore.collection(collectionName).listDocuments().iterator().next();
    }

    private DocumentSnapshot getDocumentSnapshot(String collectionName, DocumentReference documentReference) {
        DocumentSnapshot snapshot = null;
        if (documentReference != null) {
            try {
                var apiFuture = documentReference.get();
                snapshot = apiFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Can't fetch document from Firestore from {} collection", collectionName, e);
            }
        }
        return snapshot;
    }
}
