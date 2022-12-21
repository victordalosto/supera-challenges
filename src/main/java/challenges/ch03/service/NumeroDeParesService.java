package challenges.ch03.service;
import challenges.ch03.model.ModeloProblema;


public class NumeroDeParesService {


    public int getQuantidadeDeParesNoArrayDoModelo(ModeloProblema modeloProblema) {
        int[] arr = modeloProblema.getArray();
        int quantidade = 0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (satisfazCondicao(arr[i], arr[j], modeloProblema.getValorAlvo())) {
                    quantidade++;
                    System.out.println("Pares ["+arr[i]+","+arr[j]+"] satisfazem o alvo = " + modeloProblema.getValorAlvo());
                }
            }
        }
        return quantidade;
    }



    private boolean satisfazCondicao(int a, int b, int valorAlvo) {
        if (a - b == valorAlvo || b - a == valorAlvo)
            return true;
        return false;
    }
    
}
