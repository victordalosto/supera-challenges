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
 * Dado um array de inteiros e um valor alvo, determine o número de pares entre
 * os elementos do array em que a sua diferença seja igual ao valor alvo.
 * .
 */
public class Challenge03Test {

    static NumeroDeParesService numeroDeParesService = new NumeroDeParesService();


    @Test
    void deveriaRealizarTestCompletoDesdeObterInputDoUsuarioAteImprimirValorNaTela() {
        String data = "5" + "\n2" + "\n1" + "\n5" + "\n3" + "\n4" + "\n2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputProblemaService inputServiceWithMock = new InputProblemaService(new Scanner(System.in));
        ModeloProblema modeloProblema = inputServiceWithMock.getModeloDigitado();
        assertEquals(2, modeloProblema.getValorAlvo());
        assertEquals(5, modeloProblema.getArr().length);
        assertArrayEquals(new int [] {1, 5, 3, 4, 2}, modeloProblema.getArr());
        int quantidade = numeroDeParesService.getQuantidade(modeloProblema);
        assertEquals(3, quantidade);
    }



    @Test
    void deveriaRetornarASolucaoCorretaDoProblema() {
        ModeloProblema mockModeloProblema = ModeloProblema.builder().valorAlvo(1).arr(new int[] {1, 2, 3, 4}).build();
        assertEquals(3, numeroDeParesService.getQuantidade(mockModeloProblema));
    }
    


    @Test
    void deveriaRetornarUmModeloProblemaPorInputDigitado() {
        String data = "4" + "\n1" + "\n1" + "\n2" + "\n3" + "\n4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputProblemaService inputServiceWithMock = new InputProblemaService(new Scanner(System.in));
        ModeloProblema modeloProblema = inputServiceWithMock.getModeloDigitado();
        assertEquals(1, modeloProblema.getValorAlvo());
        assertEquals(4, modeloProblema.getArr().length);
        assertArrayEquals(new int [] {1, 2, 3, 4}, modeloProblema.getArr());
    }
    


    @Test
    void deveriaIgnorarAlgunsInputsDigitadosInvalidos() {
        String data = "a" + "\n!" + "\n" + "\n-22.5" + "\n1000000.0001"
                    + "\n4" + "\n1" + "\n1" + "\n2" + "\n3" + "\n4";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputProblemaService inputServiceWithMock = new InputProblemaService(new Scanner(System.in));
        ModeloProblema modeloProblema = inputServiceWithMock.getModeloDigitado();
        assertEquals(1, modeloProblema.getValorAlvo());
        assertEquals(4, modeloProblema.getArr().length);
        assertArrayEquals(new int [] {1, 2, 3, 4}, modeloProblema.getArr());
    }
}
