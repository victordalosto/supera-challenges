package challenges.ch03.service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import challenges.ch03.model.ModeloProblema;


public class InputProblemaService {

    private final Scanner scanner;

    public InputProblemaService() {
        scanner = new Scanner(System.in);
    }

    // Construtor feito para test
    public InputProblemaService(Scanner scanner) {
        this.scanner = scanner;
    }

    

    public ModeloProblema getModeloDigitado() {
        System.out.println("Digite o tamanho do array desejado: ");
        int tamanhoArr = getInteiroDigitado(scanner);
        System.out.println("Digite o valor alvo para encontrar pares: ");
        int valorAlvo = getInteiroDigitado(scanner);
        System.out.println("Digite os numeros que serao colocados no Array para a busca: ");
        int [] array = getArrayInteirosDigitado(tamanhoArr, scanner);
        return ModeloProblema.builder().valorAlvo(valorAlvo).arr(array).build();
    }



    private Integer getInteiroDigitado(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor inteiro Invalido! Valor deve ser um numero inteiro");
            scanner.nextLine();
            return getInteiroDigitado(scanner);
        } 
    }



    private int [] getArrayInteirosDigitado(Integer quantidadeDeInputs, Scanner scanner) {
        List<Integer> list = new ArrayList<>(quantidadeDeInputs);
        for (int loopAtual = 1 ; loopAtual <=quantidadeDeInputs; loopAtual++) {
            System.out.println("("+loopAtual+"/"+quantidadeDeInputs+") Digite um numero: ");
            Integer numeroDigitado = getInteiroDigitado(scanner);
            list.add(numeroDigitado);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    } 
    
}
