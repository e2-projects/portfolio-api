package lt.e2projects.portfolio.api.services.repository;

import com.google.cloud.firestore.DocumentSnapshot;

public interface FirestoreService {

    DocumentSnapshot getFirstDocument(String collectionName);

    String addDocumentAndGetId(String collectionName, Object object);
}
