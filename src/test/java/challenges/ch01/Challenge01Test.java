package challenges.ch01;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import challenges.ch01.service.InputService;
import challenges.ch01.service.OrdenaListaService;

/**  
 * PRIMEIRO DESAFIO
 * Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo o seguinte critério:
 *   • Primeiro os Pares
 *   • Depois os Ímpares
 * Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares em ordem decrescente.
 */
public class Challenge01Test {

    static InputService inputService = new InputService();
    static OrdenaListaService ordenaListaService = new OrdenaListaService();

    
    @Test
    public void deveCriarListaComInputsDoUsuarioERetornaListaOrdenadaCorreta() {
        String data = "10" + "\n4" + "\n32" + "\n34" + "\n543" + "\n3456" + "\n654" + "\n567" + "\n87" + "\n6789" + "\n98";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputService inputServiceWithMock = new InputService(new Scanner(System.in));
        List<Integer> listaInputs = inputServiceWithMock.obtemListaComNumerosInteirosNaoNegativosDigitados();
        assertEquals(10, listaInputs.size());
        assertEquals(List.of(4, 32, 34, 543, 3456, 654, 567, 87, 6789, 98), listaInputs);
        List<Integer> listaOrdenada = ordenaListaService.ordenaEmConjuntoDeParesEDeCrescimento(listaInputs);
        Assertions.assertEquals(10, listaOrdenada.size());
        Assertions.assertEquals(List.of(4, 32, 34, 98, 654, 3456, 6789, 567, 543, 87), listaOrdenada);
    }


    @Test
    public void deveriaRetornarAListaOrdenadaCorreta() {
        List<Integer> mockListInputs = List.of(4, 32, 34, 543, 3456, 654, 567, 87, 6789, 98);
        List<Integer> listaOrdenada = ordenaListaService.ordenaEmConjuntoDeParesEDeCrescimento(mockListInputs);
        Assertions.assertEquals(10, listaOrdenada.size());
        Assertions.assertEquals(List.of(4, 32, 34, 98, 654, 3456, 6789, 567, 543, 87), listaOrdenada);
    }




    @Test
    public void deveRetornarListaComInputsDigitados() {
        String data = "10" + "\n4" + "\n32" + "\n34" + "\n543" + "\n3456" + "\n654" + "\n567" + "\n87" + "\n6789" + "\n98";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputService inputServiceWithMock = new InputService(new Scanner(System.in));
        List<Integer> listaInputs = inputServiceWithMock.obtemListaComNumerosInteirosNaoNegativosDigitados();
        assertEquals(10, listaInputs.size());
        assertEquals(List.of(4, 32, 34, 543, 3456, 654, 567, 87, 6789, 98), listaInputs);
    }




    @Test
    public void deveIgnorarInputsInvalidos() {
        String data = "a" + "\n-3"  + "\n!" + "\n2" + "\n-22" + "\n23" + "\nzzy" + "\n24";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputService inputServiceWithMock = new InputService(new Scanner(System.in));
        List<Integer> listaInputs = inputServiceWithMock.obtemListaComNumerosInteirosNaoNegativosDigitados();
        assertEquals(2, listaInputs.size());
        assertEquals(List.of(23, 24), listaInputs);
    }


}
