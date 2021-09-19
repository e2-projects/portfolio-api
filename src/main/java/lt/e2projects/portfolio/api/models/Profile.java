package lt.e2projects.portfolio.api.models;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private String name;
    private String surname;
    private String position;
    private String address;

}
