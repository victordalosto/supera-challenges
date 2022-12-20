package challenges.ch02;
import java.math.BigDecimal;
import java.util.List;
import challenges.ch02.service.MonetarioService;
import challenges.ch02.model.Monetario;
import challenges.ch02.service.InputMonetarioService;


/**
 * Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor monetario. 
 * A seguir, calcule o menor numero de notas e moedas possíveis no qual o valor pode ser decomposto. 
 * As notas consideradas sao de 100, 50, 20, 10, 5, 2. 
 * As moedas possíveis sao de 1, 0.50, 0.25, 0.10, 0.05 e 0.01.
 */
public class Challenge02 {

    static InputMonetarioService inputMonetarioService = new InputMonetarioService();
    static MonetarioService monetarioService = new MonetarioService();

    
    public static void main(String[] args) {
        System.out.println("SEGUNDO DESAFIO! - Converte o valor em notas e moedas");
        BigDecimal valorMonetario = inputMonetarioService.getMonetarioDigitadoValido();
        List<Monetario> listaMonetariaDoValor = monetarioService.getListaComMonetarios(valorMonetario);
        monetarioService.printaListaMonetaria(listaMonetariaDoValor);
    }
}
