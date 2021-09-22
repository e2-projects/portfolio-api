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
public class Profile {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String address;
    @NotNull
    private String position;
    @NotNull
    private Company company;

    public Map<String, Object> getValuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(name)) {
            valuesMap.put("name", name);
        }
        if (!StringUtil.isNullOrEmpty(surname)) {
            valuesMap.put("surname", surname);
        }
        if (!StringUtil.isNullOrEmpty(address)) {
            valuesMap.put("address", address);
        }
        if (!StringUtil.isNullOrEmpty(position)) {
            valuesMap.put("position", position);
        }
        if (company != null && (!StringUtil.isNullOrEmpty(company.getName()) || !StringUtil.isNullOrEmpty(company.getUrl()))) {
            var companyValues = company.getValuesMap();
            if (!companyValues.isEmpty()) {
                valuesMap.put("company", companyValues);
            }
        }
        return valuesMap;
    }

}
