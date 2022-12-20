package challenges.ch02;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import challenges.ch02.model.Monetario;
import challenges.ch02.model.TipoMonetario;
import challenges.ch02.service.InputMonetarioService;
import challenges.ch02.service.MonetarioService;


/**
 * Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor monetario. 
 * A seguir, calcule o menor numero de notas e moedas possíveis no qual o valor pode ser decomposto. 
 * As notas consideradas sao de 100, 50, 20, 10, 5, 2. 
 * As moedas possíveis sao de 1, 0.50, 0.25, 0.10, 0.05 e 0.01.
 */
public class Challenge02Test {

    static MonetarioService monetarioService = new MonetarioService();


    @Test
    void deveriaRealizarTestCompletoDesdeObterInputDoUsuarioAteImprimirValorNaTela() {
        String mockInputsDigitados = "576.73";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputMonetarioService inputServiceWithMock = new InputMonetarioService(new Scanner(System.in));
        BigDecimal monetarioObtido = inputServiceWithMock.getMonetarioDigitadoValido();
        assertEquals(new BigDecimal("576.73"), monetarioObtido);
        List<Monetario> listaComMonetario = monetarioService.getListaComMonetariosDeUmValor(monetarioObtido);
        assertEquals(new BigDecimal("576.73"), listaComMonetario.stream().map(Monetario::getValorMonetario).reduce(BigDecimal.ZERO, BigDecimal::add));
        String textoOutput = monetarioService.printaListaMonetaria(listaComMonetario);
        assertTrue(textoOutput.contains("NOTAS:"));
        assertTrue(textoOutput.contains("5	nota(s) de R$ 100.00"));
        assertTrue(textoOutput.contains("1	nota(s) de R$ 50.00"));
        assertTrue(textoOutput.contains("1	nota(s) de R$ 20.00"));
        assertTrue(textoOutput.contains("0	nota(s) de R$ 10.00"));
        assertTrue(textoOutput.contains("1	nota(s) de R$ 5.00"));
        assertTrue(textoOutput.contains("0	nota(s) de R$ 2.00"));
        assertTrue(textoOutput.contains("MOEDAS:"));
        assertTrue(textoOutput.contains("1	moeda(s) de R$ 1.00"));
        assertTrue(textoOutput.contains("1	moeda(s) de R$ 0.50"));
        assertTrue(textoOutput.contains("0	moeda(s) de R$ 0.25"));
        assertTrue(textoOutput.contains("2	moeda(s) de R$ 0.10"));
        assertTrue(textoOutput.contains("0	moeda(s) de R$ 0.05"));
        assertTrue(textoOutput.contains("3	moeda(s) de R$ 0.01"));
    }



    @Test
    void deveriaRetornarListaContendoSomaCorretaDoMonetario() {
        BigDecimal mockBigDecimal = new BigDecimal("565896.13");
        List<Monetario> obtemListaComMonetarios = monetarioService.getListaComMonetariosDeUmValor(mockBigDecimal);
        assertEquals(mockBigDecimal, obtemListaComMonetarios.stream().map(Monetario::getValorMonetario).reduce(BigDecimal.ZERO, BigDecimal::add));
    }



    @Test
    void deveriaRetornarListaContendoUmaUnicaUnidadeDeCadaMonetario() {
        BigDecimal mockBigDecimal = new BigDecimal("188.91");
        List<Monetario> obtemListaComMonetarios = monetarioService.getListaComMonetariosDeUmValor(mockBigDecimal);
        for (Monetario monetario : Monetario.values()) {
            int quantidadeDeMonetario = obtemListaComMonetarios.stream().filter(f -> f.getValorMonetario() == monetario.getValorMonetario()).toList().size();
            assertEquals(1, quantidadeDeMonetario);
        }
    }

    

    @Test
    void deveriaRetornarUmValorMonetario() {
        String mockInputsDigitados = "1594.75";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputMonetarioService inputServiceWithMock = new InputMonetarioService(new Scanner(System.in));
        assertEquals(new BigDecimal(1594.75), inputServiceWithMock.getMonetarioDigitadoValido());
    }



    @Test
    void deveriaIgnorarInputMonetarioInvalido() {
        String mockInputsDigitados = "a" + "\n!" + "\n" + "\n-22.5" + "\n1000000.0001"
                                   + "\n1000000.000";
        System.setIn(new ByteArrayInputStream(mockInputsDigitados.getBytes()));
        InputMonetarioService inputServiceWithMock = new InputMonetarioService(new Scanner(System.in));
        assertEquals(new BigDecimal("1000000.000"), inputServiceWithMock.getMonetarioDigitadoValido());

    }



    @Test
    void deveriaImprimirQuantidadeMonetariaNaTela() {
        BigDecimal mockBigDecimal = new BigDecimal("201.11");
        List<Monetario> obtemListaComMonetarios = monetarioService.getListaComMonetariosDeUmValor(mockBigDecimal);
        String textOutput = monetarioService.printaListaMonetaria(obtemListaComMonetarios);
        System.out.println(textOutput);
        assertTrue(textOutput.contains("2	nota(s) de R$ 100.00"));
        assertTrue(textOutput.contains("0	nota(s) de R$ 50.00"));
        assertTrue(textOutput.contains("1	moeda(s) de R$ 1.00"));
        assertTrue(textOutput.contains("1	moeda(s) de R$ 0.10"));
        assertTrue(textOutput.contains("1	moeda(s) de R$ 0.01"));
    }



    @Test
    void deveriaRetornaQuantidadeUnitariaCertaDeMonetariosDoTipoMoeda() {
        assertEquals(36, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.UM, new BigDecimal("36")));
        assertEquals(51, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.ZERO_CINQUENTA, new BigDecimal("25.50")));
        assertEquals(91, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.ZERO_VINTEECINCO, new BigDecimal("22.75")));
        assertEquals(83, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.ZERO_DEZ, new BigDecimal("8.30")));
        assertEquals(79, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.ZERO_ZEROCINCO, new BigDecimal("3.95")));
        assertEquals(97, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.ZERO_ZEROUM, new BigDecimal("0.97")));
        assertEquals(6, Arrays.asList(Monetario.values()).stream().filter(p -> p.getTipoMonetario().equals(TipoMonetario.MOEDA)).toList().size());
    }

    

    @Test
    void deveriaRetornaQuantidadeUnitariaCertaDeMonetariosDoTipoNota() {
        assertEquals(12, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.CEM, new BigDecimal("1200.0")));
        assertEquals(35, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.CINQUENTA, new BigDecimal("1750.0")));
        assertEquals(13, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.VINTE, new BigDecimal("260.0")));
        assertEquals(110, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.DEZ, new BigDecimal("1100.0")));
        assertEquals(125, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.CINCO, new BigDecimal("625.0")));
        assertEquals(440, monetarioService.getQuantidadeUnitariaDeMonetarioDeUmValor(Monetario.DOIS, new BigDecimal("880")));
        assertEquals(6, Arrays.asList(Monetario.values()).stream().filter(p -> p.getTipoMonetario().equals(TipoMonetario.NOTA)).toList().size());
    }
    
}
