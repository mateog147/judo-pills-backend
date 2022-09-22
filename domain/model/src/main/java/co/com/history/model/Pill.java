package co.com.history.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pill {
    protected String id;
    protected String name;
    protected String image;
    protected String history;
    protected List<String> references;
}
