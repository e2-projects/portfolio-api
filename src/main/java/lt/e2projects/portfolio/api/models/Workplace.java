package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.Exclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workplace implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;
    private String companyName;
    private String startDate;
    private String endDate;
    private List<WorkPosition> positions;

    @Exclude
    @JsonIgnore
    @Override
    public Map<String, Object> valuesMap() {
        return Collections.emptyMap();
    }
}
