package challenges.ch04.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputImpressoraService {

    private final Scanner scanner;

    public InputImpressoraService() {
        scanner = new Scanner(System.in);
    }

    // Construtor feito para test
    public InputImpressoraService(Scanner scanner) {
        this.scanner = scanner;
    }



    public List<String> getListaComTextosDigitados() {
        System.out.println("Digite a quantidade de numeros que serao inseridos: ");
        int quantidadeDeInputs = getNumeroDigitadoValido();
        System.out.println("Digite as palavras impressas na impressora: ");
        List<String> listaComTextosDigitados = getListaComTextosDigitados(quantidadeDeInputs);
        return listaComTextosDigitados;
    }



    private Integer getNumeroDigitadoValido() {
        try {
            Integer numeroDigitado = scanner.nextInt();
            if (numeroDigitado <= 0)
                throw new NoSuchElementException();
            return numeroDigitado;
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor digitado Invalido! Valor deve ser um numero inteiro positivo.");
            scanner.nextLine();
            return getNumeroDigitadoValido();
        } 
    }



    private String getTextoDigitado() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor digitado deve ser um String.");
            scanner.nextLine();
            return getTextoDigitado();
        } 
    }



    private List<String> getListaComTextosDigitados(Integer quantidadeDeInputs) {
        List<String> lista = new ArrayList<>(quantidadeDeInputs);
        for (int loopAtual = 1 ; loopAtual <=quantidadeDeInputs; loopAtual++) {
            System.out.println("("+loopAtual+"/"+quantidadeDeInputs+") Digite um texto: ");
            String textoDigitado = getTextoDigitado();
            lista.add(textoDigitado);
        }
        return lista;
    } 
    
}
