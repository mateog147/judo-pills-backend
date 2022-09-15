package co.com.history.model.judoka;
import co.com.history.model.judoka.values.Achievement;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder(toBuilder = true)
public class Judoka {
    private String id;
    private String name;
    private String grade;
    private String image;
    private String beginning;
    private String history;
    private Set<Achievement> achievements;

}
