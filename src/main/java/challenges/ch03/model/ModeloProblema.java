package challenges.ch03.model;
import challenges.ch03.service.NumeroDeParesService;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ModeloProblema     {

    private int valorAlvo;
    private int[] array;

    

    public int getQuantidadeDePares(NumeroDeParesService numeroDeParesService) {
        return numeroDeParesService.getQuantidadeDeParesNoArrayDoModelo(this);
    }
    
}
