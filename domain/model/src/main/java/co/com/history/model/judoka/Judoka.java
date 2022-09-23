package co.com.history.model.judoka;
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
public class Judoka extends Pill {

    private String rank;
    private String beginning;
    private Set<Achievement> achievements;

    @Builder
    public Judoka(String id, String name, String image, String history, List<String> references, String rank, String beginning, Set<Achievement> achievements) {
        super(id, name, image, history, references);
        this.rank = rank;
        this.beginning = beginning;
        this.achievements = achievements;
    }

    public String getGrade() {
        return rank;
    }

    public void setGrade(String rank) {
        this.rank = rank;
    }

    public String getBeginning() {
        return beginning;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }
}
