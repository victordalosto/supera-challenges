package challenges.ch02.service;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputMonetarioService {

    private final Scanner scanner;

    public InputMonetarioService() {
        scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
    }

    public InputMonetarioService(Scanner scanner) {
        this.scanner = scanner.useLocale(Locale.ENGLISH);
    }

    

    public BigDecimal getMonetarioDigitadoValido() {
        try {
            BigDecimal numeroDigitado = scanner.nextBigDecimal();
            if (!ehUmValorMonetarioValido(numeroDigitado))
                throw new NoSuchElementException();
            return numeroDigitado;
        } catch (NoSuchElementException e) {
            scanner.nextLine();
            return getMonetarioDigitadoValido();
        } 
    }


    
    private boolean ehUmValorMonetarioValido(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) >= 0 && 
            valor.compareTo(new BigDecimal(1000000.00)) <= 0)
            return true;
        return false;
    }
    
}
