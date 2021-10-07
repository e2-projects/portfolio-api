package lt.e2projects.portfolio.api.models;

import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public Map<String, Object> getValuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(name)) {
            valuesMap.put("name", name);
        }
        if (!StringUtil.isNullOrEmpty(surname)) {
            valuesMap.put("surname", surname);
        }
        if (!StringUtil.isNullOrEmpty(position)) {
            valuesMap.put("position", position);
        }
        return valuesMap;
    }

}
