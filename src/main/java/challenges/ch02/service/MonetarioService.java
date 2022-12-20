package challenges.ch02.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import challenges.ch02.model.Monetario;
import challenges.ch02.model.TipoMonetario;

public class MonetarioService {

    private List<Monetario> monetarios = Arrays.asList(Monetario.values());


    public List<Monetario> obtemListaComMonetarios(BigDecimal valor) {
        List<Monetario> listaMonetariaDoValor = new ArrayList<>();
        BigDecimal soma = BigDecimal.ZERO;
        for (Monetario monetario : monetarios) {
            Integer quantidade = quantidadeUnitariaMonetarioDeUmValor(monetario, valor.subtract(soma));
            for (int i=0; i<quantidade; i++) {
                soma = soma.add(monetario.getValorMonetario());
                listaMonetariaDoValor.add(monetario);
            }
        }
        return Collections.unmodifiableList(listaMonetariaDoValor);
    }



    public Integer quantidadeUnitariaMonetarioDeUmValor(Monetario monetario, BigDecimal valor) {
        BigDecimal soma = BigDecimal.ZERO;
        int quantidade = 0;
        while (soma.compareTo(valor) <= 0) {
            soma = soma.add(monetario.getValorMonetario());
            if (soma.compareTo(valor) > 0)
                return quantidade;
            quantidade++;
        }
        return quantidade;
    }



    public String printaListaMonetaria(List<Monetario> lista) {
        TipoMonetario tipoMonetario = null;
        StringBuffer sb = new StringBuffer();
        for (Monetario monetario : monetarios) {
            long count = lista.stream()
                              .filter(f -> f.getValorMonetario().equals(monetario.getValorMonetario()) 
                                        && f.getTipoMonetario().equals(monetario.getTipoMonetario()))
                              .count();
            if (!(tipoMonetario == monetario.getTipoMonetario())) {
                tipoMonetario = monetario.getTipoMonetario();
                sb.append(tipoMonetario.toString().toUpperCase() + "S:\n");
            }
            sb.append(count + "\t" + tipoMonetario.toString().toLowerCase() + "(s) de R$ " + monetario.getValorMonetario()+"\n");
        }
        System.out.println(sb);
        return sb.toString();

    }
    
}
