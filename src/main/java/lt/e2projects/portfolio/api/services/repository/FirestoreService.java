package lt.e2projects.portfolio.api.services.repository;

import lt.e2projects.portfolio.api.models.FirebaseObject;

public interface FirestoreService {

    /**
     * Get document object from Firestore<br>
     * <b>Example:</b> <code>firestoreService.get(CollectionName.MY_COLLECTION, MyCollection.class)</code>
     * @param collectionName Firestore collection name.
     *                       Use string or CollectionName constant
     * @param clazz Class in which json document object should be mapped
     * @return Firestore Document
     * @see Object
     * @see lt.e2projects.portfolio.api.constants.CollectionName
     * */
    Object get(String collectionName, Class<?> clazz);

    /**
     * Create new document in Firestore
     * @param collectionName Firestore collection name.
     *                       Use string or CollectionName constant
     * @param object document object which should be created
     * @return Firestore Document ID
     * @see lt.e2projects.portfolio.api.constants.CollectionName
     * @see Object
     * */
    String create(String collectionName, Object object);

    /**
     * Update existing document in Firestore
     * @param collectionName Firestore collection name.
     *                       Use string or CollectionName constant
     * @param object document object which should be created
     * @return Updated Firestore Document
     * @see Object
     * @see lt.e2projects.portfolio.api.constants.CollectionName
     * @see FirebaseObject
     * */
    Object update(String collectionName, FirebaseObject object);

}
