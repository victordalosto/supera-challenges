package challenges.ch03.model;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModeloProblema {

    private int valorAlvo;
    private int[] arr;
    
}
