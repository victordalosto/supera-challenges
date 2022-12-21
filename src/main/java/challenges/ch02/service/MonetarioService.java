package challenges.ch02.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import challenges.ch02.model.Monetario;
import challenges.ch02.model.TipoMonetario;


public class MonetarioService {

    private List<Monetario> listPossiveisMonetarios = Arrays.asList(Monetario.values());


    public List<Monetario> getListaComMonetariosDeUmValor(BigDecimal valor) {
        List<Monetario> listMonetariaDoValor = new ArrayList<>();
        BigDecimal soma = BigDecimal.ZERO;
        for (Monetario monetario : listPossiveisMonetarios) {
            BigDecimal resto = valor.subtract(soma);
            Integer quantidade = getMaximaQuantidadeUnitariaDeMonetarioDeUmValor(monetario, resto);
            for (int i=0; i<quantidade; i++) {
                soma = soma.add(monetario.getValorMonetario());
                listMonetariaDoValor.add(monetario);
            }
        }
        return Collections.unmodifiableList(listMonetariaDoValor);
    }



    public Integer getMaximaQuantidadeUnitariaDeMonetarioDeUmValor(Monetario monetario, BigDecimal valor) {
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
        TipoMonetario tipoMonetarioAtualDoLoop = null;
        StringBuffer sb = new StringBuffer();
        for (Monetario monetario : listPossiveisMonetarios) {
            long count = lista.stream()
                              .filter(m -> m.getTipoMonetario().equals(monetario.getTipoMonetario())
                                        && m.getValorMonetario().equals(monetario.getValorMonetario()))
                              .count();
            if (tipoMonetarioAtualDoLoop != monetario.getTipoMonetario()) {
                tipoMonetarioAtualDoLoop = monetario.getTipoMonetario();
                sb.append(tipoMonetarioAtualDoLoop.toString().toUpperCase() + "S:\n");
            }
            sb.append(count + "\t" + tipoMonetarioAtualDoLoop.toString().toLowerCase() + "(s) de R$ " + monetario.getValorMonetario()+"\n");
        }
        System.out.println(sb);
        return sb.toString(); // retorno String adicionado para Test
    }
    
}
