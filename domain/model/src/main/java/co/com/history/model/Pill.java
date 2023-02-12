package co.com.history.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pill {
    protected String id;
    protected String name;
    protected String image;
    protected String country;
    protected String history;
    protected Date startYear;
    protected Date endYear;
    protected List<String> references;

    public Pill(String id,String name, String image, String country, String history, Date startYear, List<String> references) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.country = country;
        this.history = history;
        this.startYear = startYear;
        this.references = references;
    }
}
