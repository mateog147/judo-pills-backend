package co.com.history.model.organization;
import co.com.history.model.judoka.values.Achievement;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder(toBuilder = true)
public class Organization {
    private String id;
    private String name;
    private String image;
    private String history;
    private Set<String> judokasIds;
}
