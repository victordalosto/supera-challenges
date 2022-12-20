package challenges.ch01;
import java.util.List;
import challenges.ch01.service.InputNumerosService;
import challenges.ch01.service.OrdenaListaService;


/**  
* PRIMEIRO DESAFIO
* Considerando a entrada de valores inteiros nao negativos, ordene estes valores segundo o seguinte critério:
*   • Primeiro os Pares
*   • Depois os Ímpares
* Sendo que deverao ser apresentados os pares em ordem crescente e depois os ímpares em ordem decrescente.
*/
public class Challenge01 {

    // Simulando injecao de dependencia!
    static InputNumerosService inputNumerosService = new InputNumerosService();
    static OrdenaListaService ordenaListaService = new OrdenaListaService();


    public static void main(String[] args) {
        System.out.println("PRIMEIRO DESAFIO! - Ordenacao de valores");
        List<Integer> listaComNumerosInteirosNaoNegativos = inputNumerosService.getListaComNumerosInteirosNaoNegativosDigitados();
        List<Integer> listaOrdenadaComNumerosInteirosNaoNegativos = ordenaListaService.getListOrdenadaEmConjuntoDeParesEDeCrescimento(listaComNumerosInteirosNaoNegativos);

        System.out.println("\nLista com valores de entrada:");
        System.out.println(listaComNumerosInteirosNaoNegativos + ". Tamanho = " + listaComNumerosInteirosNaoNegativos.size());
        System.out.println("\nLista com valores de saída ordenada:");
        System.out.println(listaOrdenadaComNumerosInteirosNaoNegativos);
    }
}
