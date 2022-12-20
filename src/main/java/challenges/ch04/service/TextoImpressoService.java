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



    public String printaListaTexto(List<String> listString) {
        listString.forEach(s -> System.out.println(s));
        return listString.stream().collect(Collectors.joining(", "));
    }



    private String concertaPrimeiraMetadeDoTexto(String text) {
        int size = text.length()/2;
        StringBuffer sb = new StringBuffer(size);
        for (int i=size-1; i>=0; i--)
            sb.append(text.charAt(i));
        return sb.toString();
    }
    


    private String concertaSegundaMetadeDoTexto(String text) {
        int size = text.length()/2;
        StringBuffer sb = new StringBuffer(size);
        for (int i=size*2-1; i>=size; i--)
            sb.append(text.charAt(i));
        return sb.toString();
        
    }
}
