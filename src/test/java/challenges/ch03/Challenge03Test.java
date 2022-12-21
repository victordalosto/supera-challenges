package challenges.ch03;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import challenges.ch03.model.ModeloProblema;
import challenges.ch03.service.InputProblemaService;
import challenges.ch03.service.NumeroDeParesService;


/**
 * Dado um array de inteiros e um valor alvo, determine o numero de pares entre
 * os elementos do array em que a sua diferenca seja igual ao valor alvo.
 */
public class Challenge03Test {

    static NumeroDeParesService numeroDeParesService = new NumeroDeParesService();


    @Test
    void deveriaRealizarTestCompletoDesdeObterInputDoUsuarioAteImprimirValorNaTela() {
        String mockInputsDigitados = "5" + "\n2" + "\n1" + "\n5" + "\n3" + "\n4" + "\n2";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputProblemaService inputServiceWithMock = new InputProblemaService(new Scanner(System.in));
        ModeloProblema modeloProblema = inputServiceWithMock.getModeloProblemaDigitado();
        assertEquals(2, modeloProblema.getValorAlvo());
        assertEquals(5, modeloProblema.getArray().length);
        assertArrayEquals(new int [] {1, 5, 3, 4, 2}, modeloProblema.getArray());
        int quantidade = numeroDeParesService.getQuantidadeDeParesNoArrayDoModelo(modeloProblema);
        assertEquals(3, quantidade);
    }



    @Test
    void deveriaRetornarASolucaoCorretaDoProblema() {
        ModeloProblema mockModeloProblema = ModeloProblema.builder().valorAlvo(1).array(new int[] {1, 2, 3, 4}).build();
        assertEquals(3, numeroDeParesService.getQuantidadeDeParesNoArrayDoModelo(mockModeloProblema));
    }
    


    @Test
    void deveriaRetornarUmModeloProblemaDoInputDigitado() {
        String mockInputsDigitados = "4" + "\n1" + "\n1" + "\n2" + "\n3" + "\n4";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputProblemaService inputServiceWithMock = new InputProblemaService(new Scanner(System.in));
        ModeloProblema modeloProblema = inputServiceWithMock.getModeloProblemaDigitado();
        assertEquals(1, modeloProblema.getValorAlvo());
        assertEquals(4, modeloProblema.getArray().length);
        assertArrayEquals(new int [] {1, 2, 3, 4}, modeloProblema.getArray());
    }
    


    @Test
    void deveriaIgnorarAlgunsInputsDigitadosInvalidos() {
        String mockInputsDigitados = "a" + "\n!" + "\n" + "\n-22.5" + "\n1000000.0001"
                                   + "\n4" + "\n1" + "\n1" + "\n2" + "\n3" + "\n4";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputProblemaService inputServiceWithMock = new InputProblemaService(new Scanner(System.in));
        ModeloProblema modeloProblema = inputServiceWithMock.getModeloProblemaDigitado();
        assertEquals(1, modeloProblema.getValorAlvo());
        assertEquals(4, modeloProblema.getArray().length);
        assertArrayEquals(new int [] {1, 2, 3, 4}, modeloProblema.getArray());
    }
}
