package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.Exclude;

import java.util.Map;

public interface FirebaseObject {

    @Exclude
    @JsonIgnore
    Map<String, Object> getValuesMap();

}
