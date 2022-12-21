package challenges.ch04;
import java.util.List;
import challenges.ch04.service.InputImpressoraService;
import challenges.ch04.service.TextoImpressoService;


/**
 * A sua impressora foi infectada por um virus e esta imprimindo de forma incorreta. 
 * Depois de olhar para varias paginas impressas por um tempo, você percebe que ele esta imprimindo cada linha de dentro para fora. 
 * Em outras palavras, a metade esquerda de cada linha esta sendo impressa a partir do meio da pagina ate a margem esquerda. 
 * Do mesmo modo, a metade direita de cada linha esta sendo impressa ah partir da margem direita e prosseguindo em direcao ao centro da pagina.
 */
public class Challenge04 {
    
    static InputImpressoraService inputImpressoraService = new InputImpressoraService();
    static TextoImpressoService ImpressoraService = new TextoImpressoService();

    
    public static void main(String[] args) {
        System.out.println("QUARTO DESAFIO! - Impressora com problema");
        List<String> listaComTextosDigitados = inputImpressoraService.getListaComTextosDigitados();
        List<String> listaComTextoDecifrado = ImpressoraService.getListaComTextoDecifrado(listaComTextosDigitados);
        ImpressoraService.printaListaTexto(listaComTextoDecifrado);
    }
}
