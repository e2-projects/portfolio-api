package lt.e2projects.portfolio.api.services.repository;

import com.google.cloud.firestore.DocumentSnapshot;

import java.util.Map;

public interface FirestoreService {

    DocumentSnapshot getFirstDocument(String collectionName);

    String addDocumentAndGetId(String collectionName, Object object);

    void updateDocument(String collectionName, Map<String, Object> valuesMap);

}
