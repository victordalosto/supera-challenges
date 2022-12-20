package challenges.ch03;
import challenges.ch03.model.ModeloProblema;
import challenges.ch03.service.InputProblemaService;
import challenges.ch03.service.NumeroDeParesService;


/**
 * Dado um array de inteiros e um valor alvo, determine o numero de pares entre
 * os elementos do array em que a sua diferença seja igual ao valor alvo.
 */
public class Challenge03 {
    
    static InputProblemaService inputProblemaService = new InputProblemaService();
    static NumeroDeParesService numeroDeParesService = new NumeroDeParesService();

    
    public static void main(String[] args) {
        System.out.println("TERCEIRO DESAFIO! - Numero de pares com a diferenca com valor igual ao alvo");
        ModeloProblema modeloProblema = inputProblemaService.getModeloDigitado();
        // int solucao = numeroDeParesService.getQuantidade(modeloProblema);
        int solucao = modeloProblema.getQuantidadePares(numeroDeParesService);
        System.out.println(solucao);
    }
}
