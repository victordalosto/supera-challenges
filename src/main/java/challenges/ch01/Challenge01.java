package challenges.ch01;
import java.util.List;
import challenges.ch01.service.InputService;
import challenges.ch01.service.OrdenaListaService;

/**  
* PRIMEIRO DESAFIO
* Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo o seguinte critério:
*   • Primeiro os Pares
*   • Depois os Ímpares
* Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares em ordem decrescente.
*/
public class Challenge01 {

    // Simulando injecao de dependencia!
    static InputService inputDigitarService = new InputService();
    static OrdenaListaService ordenaListaService = new OrdenaListaService();


    public static void main(String[] args) {
        System.out.println("PRIMEIRO DESAFIO! - Ordenação de valores");
        List<Integer> listaComNumerosInteirosNaoNegativos = inputDigitarService.obtemListaComNumerosInteirosNaoNegativosDigitados();
        List<Integer> listaOrdenadaComNumerosInteirosNaoNegativos = ordenaListaService.ordenaEmConjuntoDeParesEDeCrescimento(listaComNumerosInteirosNaoNegativos);

        System.out.println("\nLista com valores de entrada:");
        System.out.println(listaComNumerosInteirosNaoNegativos + ". Tamanho = " + listaComNumerosInteirosNaoNegativos.size());
        System.out.println("\nLista com valores de saída ordenada:");
        System.out.println(listaOrdenadaComNumerosInteirosNaoNegativos);
    }
}
