import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class Data {

    @JsonProperty("color")
    private String color;

    @JsonProperty("capacity GB")
    private Integer capacityGB;

    @JsonProperty("price")
    private Double price;
}
