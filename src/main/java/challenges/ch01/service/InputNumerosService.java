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



    public List<Integer> getListaComNumerosInteirosNaoNegativosDigitados() {
        System.out.println("Digite a quantidade de numeros que serao inseridos: ");
        int quantidadeDeInputs = getNumeroDigitadoValido(scanner);
        System.out.println("Digite os numeros que serao colocados para ordenacao: ");
        List<Integer> listaComNumerosInteirosNaoNegativos = getListaComNumerosDigitados(quantidadeDeInputs, scanner);
        return Collections.unmodifiableList(listaComNumerosInteirosNaoNegativos);
    }



    private Integer getNumeroDigitadoValido(Scanner scanner) {
        try {
            Integer numeroDigitado = scanner.nextInt();
            if (!ehUmNumeroPositivoValido(numeroDigitado))
                throw new NoSuchElementException();
            return numeroDigitado;
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor digitado Invalido! Valor deve ser um numero inteiro positivo N (1 < N <= 10^5)");
            scanner.nextLine();
            return getNumeroDigitadoValido(scanner);
        } 
    }



    private List<Integer> getListaComNumerosDigitados(Integer quantidadeDeInputs, Scanner scanner) {
        List<Integer> listaComNumerosInteirosNaoNegativos = new ArrayList<>(quantidadeDeInputs);
        for (int loopAtual = 1 ; loopAtual <=quantidadeDeInputs; loopAtual++) {
            System.out.println("("+loopAtual+"/"+quantidadeDeInputs+") Digite um numero: ");
            Integer numeroDigitado = getNumeroDigitadoValido(scanner);
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
