package Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.Array;
import java.util.*;

// DADA UMA LISTA COM 7 NOTAS DE UM ALUNO [7, 8.5, 9.3, 5, 7, 0, 3.6]
public class ExemploNotas {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas.toString());

      //  System.out.println("Exiba a posição da nota 5.0: ");
        // NÃO PODEMOS PROCURAR PELO ÍNDICE NO SET.

       // System.out.println("Adicione na lista a nota 8.0 na posição 4 ");
        // NÃO CONSEGUIMOS TRABALHAR COM ÍNDICE.

        // System.out.println("Substitua a nota 5.0 pela nota 6.0  ");
        // NÃO TEMOS COMO FAZER.

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        //System.out.println("Exiba a terceira nota add");
        //NÃO PODEMOS FAZER

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma +=next;
        }
        System.out.println(soma);


        System.out.println("Exiba a média das notas: " + (soma/ notas.size()));

        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        //System.out.println("Remova a nota na posição 0 ");
        // Não podemos usar índice.

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1= notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if ( next < 7 ) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram inseridas. ");
        // tem que usar o linked.
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add (3.6);
        System.out.println(notas2);
        // APONTA UM ERRO NO 7D POIS NÃO PERMITE REPETIDOS.

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3= new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todos os conjuntos: ");
        notas.clear();
        System.out.println(notas);




    }
}
