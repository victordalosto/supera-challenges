package challenges.ch04.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextoImpressoService {


    public List<String> getListaComTextoDecifrado(List<String> listString) {
        List<String> listaTextoDecifrado = new ArrayList<>(listString.size());
        for (String texto : listString) {
            String textoConcertado = concertaPrimeiraMetadeDoTexto(texto) + concertaSegundaMetadeDoTexto(texto);  
            listaTextoDecifrado.add(textoConcertado);
        }
        return listaTextoDecifrado;
    }



    private String concertaPrimeiraMetadeDoTexto(String text) {
        int metadeDoTamanhoDoTexto = text.length()/2;
        StringBuffer sb = new StringBuffer(metadeDoTamanhoDoTexto);
        for (int i=metadeDoTamanhoDoTexto-1; i>=0; i--)
            sb.append(text.charAt(i));
        return sb.toString();
    }
    


    private String concertaSegundaMetadeDoTexto(String text) {
        int tamanhoDoTexto = text.length();
        int metadeDoTamanhoDoTexto = tamanhoDoTexto/2;
        StringBuffer sb = new StringBuffer(metadeDoTamanhoDoTexto);
        for (int i=tamanhoDoTexto-1; i>=metadeDoTamanhoDoTexto; i--)
            sb.append(text.charAt(i));
        return sb.toString();
        
    }



    public String printaListaTexto(List<String> listString) {
        listString.forEach(s -> System.out.println(s));
        return listString.stream().collect(Collectors.joining(", ")); // retorno acrescentado para Test
    }
}
