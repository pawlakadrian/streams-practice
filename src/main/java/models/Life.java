package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class Life {
    private String country;
    private List<Animal> animals;
    private List<Plant> plants;
}
