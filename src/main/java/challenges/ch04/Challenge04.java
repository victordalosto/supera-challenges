package challenges.ch04;
import java.util.List;
import challenges.ch04.service.InputImpressoraService;
import challenges.ch04.service.TextoImpressoService;


/**
 * A sua impressora foi infectada por um vírus e está imprimindo de forma incorreta. 
 * Depois de olhar para várias páginas impressas por um tempo, você percebe que ele está imprimindo cada linha de dentro para fora. 
 * Em outras palavras, a metade esquerda de cada linha está sendo impressa a partir do meio da página até a margem esquerda. 
 * Do mesmo modo, a metade direita de cada linha está sendo impressa à partir da margem direita e prosseguindo em direção ao centro da página.
 */
public class Challenge04 {
    
    static InputImpressoraService inputImpressoraService = new InputImpressoraService();
    static TextoImpressoService textoImpressoService = new TextoImpressoService();

    
    public static void main(String[] args) {
        System.out.println("QUARTO DESAFIO! - Impressora com problema");
        List<String> listaComTextosDigitados = inputImpressoraService.getListaComTextosDigitados();
        List<String> listaTextoDecifrado = textoImpressoService.getListaComTextoDecifrado(listaComTextosDigitados);
        textoImpressoService.printaListaTexto(listaTextoDecifrado);
    }
}
