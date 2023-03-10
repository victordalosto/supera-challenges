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

    public InputImpressoraService(Scanner scanner) {
        this.scanner = scanner;
    }



    public List<String> getListaComTextosDigitados() {
        System.out.println("Digite a quantidade de numeros que serao inseridos: ");
        int quantidadeDeInputs = getNumeroDigitadoValido();
        System.out.println("Digite as frases a serem impressas na impressora: ");
        List<String> listaComTextosDigitados = getListaComTextosDigitados(quantidadeDeInputs);
        return listaComTextosDigitados;
    }



    private Integer getNumeroDigitadoValido() {
        try {
            Integer quantidade = scanner.nextInt();
            if (quantidade < 1)
                throw new NoSuchElementException();
            return quantidade;
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor digitado Invalido! Valor deve ser um numero inteiro positivo.");
            scanner.nextLine();
            return getNumeroDigitadoValido();
        } 
    }



    private String getTextoDigitado() {
        try {
            String textoDigitado = scanner.nextLine();
            if (!ehUmTextoValido(textoDigitado))
                throw new NoSuchElementException();
            return textoDigitado;
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor digitado deve ser texto com no minimo 2 e no maximo 100 caracteres de letras maiusculas\n");
            return getTextoDigitado();
        } 
    }



    private List<String> getListaComTextosDigitados(Integer quantidadeDeInputs) {
        List<String> lista = new ArrayList<>(quantidadeDeInputs);
        scanner.nextLine(); // acrescentado pois o ultimo scanner era do tipo Int
        for (int loopAtual = 1 ; loopAtual <=quantidadeDeInputs; loopAtual++) {
            System.out.println("("+loopAtual+"/"+quantidadeDeInputs+") Digite um texto: ");
            String textoDigitado = getTextoDigitado();
            lista.add(textoDigitado);
        }
        return lista;
    }



    private boolean ehUmTextoValido(String texto) {
        Integer quantidade = texto.length();
        if (!texto.toUpperCase().equals(texto))
            return false;
        if (quantidade<2 || quantidade>=100)
            return false;
        for (int i=0; i<texto.length(); i++) {
            if (!Character.isAlphabetic(texto.charAt(i)) && texto.charAt(i) != ' ')
                return false;
        }
        return true;
    }
    
}
