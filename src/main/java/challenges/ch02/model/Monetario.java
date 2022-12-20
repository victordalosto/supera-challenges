package challenges.ch02.model;
import java.math.BigDecimal;


public enum Monetario {
    CEM(new BigDecimal("100.00"), TipoMonetario.NOTA),
    CINQUENTA(new BigDecimal("50.00"), TipoMonetario.NOTA),
    VINTE(new BigDecimal("20.00"), TipoMonetario.NOTA),
    DEZ(new BigDecimal("10.00"), TipoMonetario.NOTA),
    CINCO(new BigDecimal("5.00"), TipoMonetario.NOTA),
    DOIS(new BigDecimal("2.00"), TipoMonetario.NOTA),
    UM(new BigDecimal("1.00"), TipoMonetario.MOEDA),
    ZERO_CINQUENTA(new BigDecimal("0.50"), TipoMonetario.MOEDA),
    ZERO_VINTEECINCO(new BigDecimal("0.25"), TipoMonetario.MOEDA),
    ZERO_DEZ(new BigDecimal("0.10"), TipoMonetario.MOEDA),
    ZERO_ZEROCINCO(new BigDecimal("0.05"), TipoMonetario.MOEDA),
    ZERO_ZEROUM(new BigDecimal("0.01"), TipoMonetario.MOEDA);

    private final BigDecimal valorMonetario;
    private final TipoMonetario tipoMonetario;

    private Monetario(BigDecimal valor, TipoMonetario tipoMonetario) {
        this.valorMonetario = valor;
        this.tipoMonetario = tipoMonetario;
    }


    public BigDecimal getValorMonetario(){
        return this.valorMonetario;
    }

    public TipoMonetario getTipoMonetario() {
        return this.tipoMonetario;
    }

    
    
}
