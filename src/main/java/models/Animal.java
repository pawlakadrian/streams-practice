package models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class Animal {
    public String species;
    public int numberOfLegs;
    public boolean venomous;
}
