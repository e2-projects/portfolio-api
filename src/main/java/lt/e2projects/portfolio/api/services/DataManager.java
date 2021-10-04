package lt.e2projects.portfolio.api.services;

public interface DataManager<T> {

    /**
     * Get parameterized data object from repository
     * @return parameterized object (any)
     * */
    T getDataObject();

    /**
     * Create parameterized data object in repository
     * @param dataObject parameterized object (any)
     * @return Object ID from repository
     * */
    String createDataObject(T dataObject);

    /**
     * Update object in repository and return updated
     * @param dataObject parameterized object with update values (any)
     * @return parameterized object (any)
     * */
    T updateDataObject(T dataObject);

}
