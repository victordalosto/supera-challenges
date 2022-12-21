package challenges.ch01;
import java.util.List;
import challenges.ch01.service.InputNumeroService;
import challenges.ch01.service.OrdenaListaService;


/**  
* PRIMEIRO DESAFIO
* Considerando a entrada de valores inteiros nao negativos, ordene estes valores segundo o seguinte criterio:
*   • Primeiro os Pares
*   • Depois os impares
* Sendo que deverao ser apresentados os pares em ordem crescente e depois os impares em ordem decrescente.
*/
public class Challenge01 {

    // Simulando injecao de dependencia!
    static InputNumeroService inputNumeroService = new InputNumeroService();
    static OrdenaListaService ordenaListaService = new OrdenaListaService();


    public static void main(String[] args) {
        System.out.println("PRIMEIRO DESAFIO! - Ordenacao de valores");
        List<Integer> listaComNumerosDigitados = inputNumeroService.getListaComNumerosInteirosNaoNegativosDigitados();
        List<Integer> listaComNumerosDigitadosOrdenado = ordenaListaService.getListaOrdenadaEmConjuntoDeParesEDeCrescimento(listaComNumerosDigitados);

        System.out.println("\nValores de entrada: ");
        System.out.println(listaComNumerosDigitados + ". Tamanho = " + listaComNumerosDigitados.size());
        System.out.println("\nValores de saida ordenada: ");
        System.out.println(listaComNumerosDigitadosOrdenado);
    }

}
