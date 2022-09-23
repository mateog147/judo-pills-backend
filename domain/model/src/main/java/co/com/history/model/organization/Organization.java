package co.com.history.model.organization;
import co.com.history.model.Pill;
import co.com.history.model.judoka.values.Achievement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
public class Organization extends Pill {
    private Set<String> judokasIds;

    @Builder
    public Organization(String id, String name, String image, String history, List<String> references,Integer year, Set<String> judokasIds) {
        super(id, name, image, history, year, references);
        this.judokasIds = judokasIds;
    }

    public Set<String> getJudokasIds() {
        return judokasIds;
    }

    public void setJudokasIds(Set<String> judokasIds) {
        this.judokasIds = judokasIds;
    }
}
