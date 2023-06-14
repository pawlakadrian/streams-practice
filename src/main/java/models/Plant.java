import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Plant {
    private String species;
    private Double standardHigh;
    private String fruitName;
}
