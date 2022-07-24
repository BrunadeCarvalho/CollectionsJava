package MetodoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ExemploList {
    public static void main(String[] args) {
        // DADA UMA LISTA COM 7 NOTAS DE UM ALUNO:
        /// [7, 8.5, 9.3, 5, 7, 0, 3.6], FAÇA:

        // 1:CRIE UMA LISTA E ADICIONE AS SETE NOTAS:

        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);
        System.out.println(notas.toString());

        // 2: MOSTRE A POSIÇÃO DA NOTA 5D:
        System.out.println("Exiba a posição da nota 5d: " + notas.indexOf(5d));

        // 3: ADICIONE NA LISTA A NOTA 8.0 NA POSIÇÃO 4:
        System.out.println(" Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4,8d);

        System.out.println(notas.toString());

        // 4: SUBSTITUA A NOTA 5.0 PELA NOTA 6.0
        System.out.println(" Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d),6d);
        System.out.println(notas);

        // 5: "Confira se a nota 5.0 está na lista
        System.out.println("Confira se a nota 5d está na lista: " + notas.contains(5d));

        // 6: Exiba todas as notas na ordem em que foram informadas:)
        System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
        for (Double nota: notas) System.out.println(nota);

        //7: Exiba a terceira nota adicionada:
        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));

        //8: Exiba a menor nota:
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        //8: Exiba a maio nota:
        System.out.println("Exiba a maio nota: " + Collections.max(notas));

        //9: Exiba a soma dos valores:
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma+= next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        //10: Exiba a média dos valores:
        System.out.println("Exiba a média dos valores: " + (soma/notas.size()));

        //11: Remova a nota 0:
        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        //12: Remova a nota da posição 8:
        System.out.println("Remova a nota da posição 0:");
        notas.remove(0);
        System.out.println(notas);

        // 13: Remova as notas menores que 7 e exiba a lista:
        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        // 14: Apague toda a lista
        System.out.println("Apague toda a lista ");
        notas.clear();
        System.out.println(notas);

    }
}
