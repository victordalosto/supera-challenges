package challenges.ch04;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import challenges.ch04.service.InputImpressoraService;
import challenges.ch04.service.TextoImpressoService;


/**
 * A sua impressora foi infectada por um vírus e está imprimindo de forma incorreta. 
 * Depois de olhar para várias páginas impressas por um tempo, você percebe que ele está imprimindo cada linha de dentro para fora. 
 * Em outras palavras, a metade esquerda de cada linha está sendo impressa a partir do meio da página até a margem esquerda. 
 * Do mesmo modo, a metade direita de cada linha está sendo impressa à partir da margem direita e prosseguindo em direção ao centro da página.
 */
public class Challenge04Test {

    static TextoImpressoService textoImpressoService = new TextoImpressoService();


    @Test
    void deveriaRealizarTestCompletoDesdeCriarListaComInputsDoUsuarioAteRetornaListaDecifrada() {
        String inputsDigitados = "5" + "\nI ENIL SIHTHSIREBBIG S" + "\nLEVELKAYAK" + "\nH YPPAHSYADILO" + "\nABCDEFGHIJKLMNOPQRSTUVWXYZ" + "\nVOD OWT SNEH HCNERF EGDIRTRAP A DNA SE";
        System.setIn(new ByteArrayInputStream(inputsDigitados.getBytes())); 
        InputImpressoraService inputServiceWithMock = new InputImpressoraService(new Scanner(System.in));
        List<String> listacomTextoDigitado = inputServiceWithMock.getListaComTextosDigitados();
        List<String> listaComTextoDecifrado = textoImpressoService.getListaComTextoDecifrado(listacomTextoDigitado);
        assertEquals(5, listaComTextoDecifrado.size());
        assertEquals("THIS LINE IS GIBBERISH", listaComTextoDecifrado.get(0));
        assertEquals("LEVELKAYAK", listaComTextoDecifrado.get(1));
        assertEquals("HAPPY HOLIDAYS", listaComTextoDecifrado.get(2));
        assertEquals("MLKJIHGFEDCBAZYXWVUTSRQPON", listaComTextoDecifrado.get(3));
        assertEquals("FRENCH HENS TWO DOVES AND A PARTRIDGE ", listaComTextoDecifrado.get(4));
    }



    @Test
    void deveriaRetornarUmaListaComTextosDigitados() {
        String mockInputsDigitados = "1" + "\nI ENIL SIHTHSIREBBIG S";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes())); 
        InputImpressoraService inputServiceWithMock = new InputImpressoraService(new Scanner(System.in));
        List<String> listaComTextosDigitados = inputServiceWithMock.getListaComTextosDigitados();
        assertEquals(1, listaComTextosDigitados.size());
        assertEquals("I ENIL SIHTHSIREBBIG S", listaComTextosDigitados.get(0));
    }


    
    @Test
    void deveriaIgnorarAlgunsInputsDigitadosInvalidos() {
        String mockInputsDigitados = "a" + "\n!" + "\n" + "\n-22.5" + "\n1000000.0001" + "\n3"
                                   + "\na" + "\naykayk" + "\nYAKYAK" + "\n!" + "\n23" + "\nnabana" +"\nnabANA" + "\nNABANa" + "\nNABANA" + "\nLEHWOL";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputImpressoraService inputServiceWithMock = new InputImpressoraService(new Scanner(System.in));
        List<String> listaComTextosDigitados = inputServiceWithMock.getListaComTextosDigitados();
        assertEquals(3, listaComTextosDigitados.size());
        assertEquals("YAKYAK", listaComTextosDigitados.get(0));
        assertEquals("NABANA", listaComTextosDigitados.get(1));
        assertEquals("LEHWOL", listaComTextosDigitados.get(2));
    }



    @Test
    void deveriaRetornarListaInvertida() {
        List<String> mockInputsDigitados = List.of("TENNET", "KETNEK", "XETSOT");
        List<String> listaComTextoDecifrado = textoImpressoService.getListaComTextoDecifrado(mockInputsDigitados);
        assertEquals("NETTEN", listaComTextoDecifrado.get(0));
        assertEquals("TEKKEN", listaComTextoDecifrado.get(1));
        assertEquals("TEXTOS", listaComTextoDecifrado.get(2));

    }



    @Test
    void deveriaRetornarUmPrintComTextoCorrigido() {
        List<String> mockInputsDigitados = List.of("YAKYAK", "NABANA", "LEHWOL");
        List<String> listaComTextoDecifrado = textoImpressoService.getListaComTextoDecifrado(mockInputsDigitados);
        String printaListaTexto = textoImpressoService.printaListaTexto(listaComTextoDecifrado);
        assertTrue(printaListaTexto.contains("KAYKAY"));
        assertTrue(printaListaTexto.contains("BANANA"));
        assertTrue(printaListaTexto.contains("HELLOW"));
    }
}
