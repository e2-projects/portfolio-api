package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.Exclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.e2projects.portfolio.api.commons.AppUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements FirebaseObject {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String position;

    @Exclude
    @JsonIgnore
    @Override
    public Map<String, Object> valuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (AppUtils.isNotNullOrEmpty(name)) {
            valuesMap.put("name", name);
        }
        if (AppUtils.isNotNullOrEmpty(surname)) {
            valuesMap.put("surname", surname);
        }
        if (AppUtils.isNotNullOrEmpty(position)) {
            valuesMap.put("position", position);
        }
        return valuesMap;
    }

}
