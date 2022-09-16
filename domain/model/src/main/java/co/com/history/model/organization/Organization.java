package co.com.history.model.organization;
import co.com.history.model.judoka.values.Achievement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    private String id;
    private String name;
    private String image;
    private String history;
    private Set<String> judokasIds;
}
