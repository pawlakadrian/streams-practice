import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Animal {
    public String species;
    public int numberOfLegs;
    public boolean venomous;
}
