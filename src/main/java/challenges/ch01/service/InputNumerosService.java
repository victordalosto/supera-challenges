package challenges.ch01.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputNumerosService {

    private final Scanner scanner;

    public InputNumerosService() {
        scanner = new Scanner(System.in);
    }

    // Construtor feito para test
    public InputNumerosService(Scanner scanner) {
        this.scanner = scanner;
    }


    public List<Integer> obtemListaComNumerosInteirosNaoNegativosDigitados() {
        System.out.println("Digite a quantidade de números que serão inseridos: ");
        int quantidadeDeInputs = obtemNumeroDigitadoValido(scanner);
        System.out.println("Digite os numeros que serão colocados para ordenação: ");
        List<Integer> listaComNumerosInteirosNaoNegativos = obtemListaComNumerosDigitados(quantidadeDeInputs, scanner);
        return Collections.unmodifiableList(listaComNumerosInteirosNaoNegativos);
    }



    private Integer obtemNumeroDigitadoValido(Scanner scanner) {
        try {
            Integer numeroDigitado = scanner.nextInt();
            if (!ehUmNumeroPositivoValido(numeroDigitado))
                throw new NoSuchElementException();
            return numeroDigitado;
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor digitado Inválido! Valor deve ser um número inteiro positivo N (1 < N <= 10^5)");
            scanner.nextLine();
            return obtemNumeroDigitadoValido(scanner);
        } 
    }



    private List<Integer> obtemListaComNumerosDigitados(Integer quantidadeDeInputs, Scanner scanner) {
        List<Integer> listaComNumerosInteirosNaoNegativos = new ArrayList<>(quantidadeDeInputs);
        for (int loopAtual = 1 ; loopAtual <=quantidadeDeInputs; loopAtual++) {
            System.out.println("("+loopAtual+"/"+quantidadeDeInputs+") Digite um número: ");
            Integer numeroDigitado = obtemNumeroDigitadoValido(scanner);
            listaComNumerosInteirosNaoNegativos.add(numeroDigitado);
        }
        return listaComNumerosInteirosNaoNegativos;
    } 
    


    private boolean ehUmNumeroPositivoValido(Integer numero) {
        if (numero >=1  && numero <= 100000)
            return true;
        return false;
    }
    
}
