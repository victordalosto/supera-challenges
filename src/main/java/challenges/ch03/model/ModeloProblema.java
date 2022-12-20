package challenges.ch03.model;
import challenges.ch03.service.NumeroDeParesService;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ModeloProblema {

    private int valorAlvo;
    private int[] arr;

    

    public int getQuantidadePares(NumeroDeParesService numeroDeParesService) {
        return numeroDeParesService.getQuantidade(this);
    }
    
}
