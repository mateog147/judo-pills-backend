package co.com.history.model.judoka.values;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Achievement {
    private Integer place;
    private Integer year;
    private String event;

}
