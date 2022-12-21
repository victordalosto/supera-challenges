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

    public InputProblemaService(Scanner scanner) {
        this.scanner = scanner;
    }

    

    public ModeloProblema getModeloProblemaDigitado() {
        System.out.println("Digite o tamanho (n) do array desejado: ");
        int tamanhoArr = getInteiroDigitado();
        System.out.println("Digite o valor alvo (k) para encontrar os pares: ");
        int valorAlvo = getInteiroDigitado();
        System.out.println("Digite os numeros que serao acrescentados no Array para a busca: ");
        int [] array = getArrayInteirosDigitado(tamanhoArr);
        return ModeloProblema.builder().valorAlvo(valorAlvo).array(array).build();
    }



    private Integer getInteiroDigitado() {
        try {
            int inteiroDigitado = scanner.nextInt();
            if (inteiroDigitado <=0) // Condicional nova acrescentada nao especificada
                throw new NoSuchElementException();
            return inteiroDigitado;
        } catch (NoSuchElementException e) {
            System.out.println(" #Valor inteiro Invalido! Valor deve ser um numero inteiro.");
            scanner.nextLine();
            return getInteiroDigitado();
        } 
    }



    private int [] getArrayInteirosDigitado(Integer quantidadeDeInputs) {
        List<Integer> list = new ArrayList<>(quantidadeDeInputs);
        for (int loopAtual = 1 ; loopAtual <=quantidadeDeInputs; loopAtual++) {
            System.out.println("("+loopAtual+"/"+quantidadeDeInputs+") Digite um numero: ");
            Integer numeroDigitado = getInteiroDigitado();
            list.add(numeroDigitado);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    } 
    
}
