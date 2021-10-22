package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.Exclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.e2projects.portfolio.api.commons.AppUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillGroup implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;

    @NotNull
    private String name;

    @JsonIgnore
    private Integer position;

    private List<Skill> skills;

    @Exclude
    @JsonIgnore
    @Override
    public Map<String, Object> valuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (AppUtils.isNotNullOrEmpty(name)) {
            valuesMap.put("name", name);
        }
        if (AppUtils.isNotNullOrEmpty(position)) {
            valuesMap.put("position", position);
        }
        if (AppUtils.isNotNullOrEmpty(skills)) {
            valuesMap.put("skills", skills);
        }
        return valuesMap;
    }
}
