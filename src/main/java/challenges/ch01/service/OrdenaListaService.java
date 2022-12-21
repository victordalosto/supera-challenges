package challenges.ch01.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrdenaListaService {

    
    public List<Integer> getListaOrdenadaEmConjuntoDeParesEDeCrescimento(List<Integer> listaComNumeros) {
        List<Integer> numerosPares = new ArrayList<>();
        List<Integer> numerosImpares = new ArrayList<>();
        for (Integer numero : listaComNumeros) {
            if (ehUmNumeroPar(numero))
                numerosPares.add(numero);
            else
                numerosImpares.add(numero);
        }
        List<Integer> listaOrdenada = ordenaListaComParesEmOrdemCrescenteEDepoisImparesEmOrdemDecrescente(numerosPares, numerosImpares);
        return Collections.unmodifiableList(listaOrdenada);
    }



    private boolean ehUmNumeroPar(int numero) {
        if (numero%2 == 0)
            return true;
        return false;
    }



    private List<Integer> ordenaListaComParesEmOrdemCrescenteEDepoisImparesEmOrdemDecrescente(List<Integer> numerosPares, List<Integer> numerosImpares) {
        Collections.sort(numerosPares);
        Collections.sort(numerosImpares, Collections.reverseOrder());
        List<Integer> listaOrdenada = new ArrayList<>(numerosPares.size() + numerosImpares.size());
        listaOrdenada.addAll(numerosPares);
        listaOrdenada.addAll(numerosImpares);
        return listaOrdenada;
    }

}
