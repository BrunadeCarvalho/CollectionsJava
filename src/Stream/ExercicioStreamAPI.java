package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExercicioStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de Strings:");
            numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros número e coloque dentro de um set");
            numerosAleatorios.stream()
                    .limit(5)
                    .collect(Collectors.toSet())
                    .forEach(System.out::println);
            //NÃO VAI APARECER OS NÚMEROS REPETIDOS

        System.out.println("Transforme esta lista de String em uma lista de números inteiros");
                numerosAleatorios.stream()
                .map (Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
//                List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
//                        .map(Integer::parseInt)
//                        .filter(new Predicate<Integer>() {
//                            @Override
//                            public boolean test(Integer i) {
//                                if (i %2 == 0 && i>2) return true;
//                                return false;
//                            }
//                        }).collect(Collectors.toList());
//        System.out.println(ListParesMaioresQue2); (*****AQUI JÁ ESTAVA FUNCIONANDO********)
         List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
                 .map(Integer::parseInt)
                 .filter(i -> i%2 == 0 && i>2).collect(Collectors.toList());
        System.out.println(ListParesMaioresQue2);

        System.out.println("Mostre a média dos números");
//        numerosAleatorios.stream()
                //USA O MAP TO INT PQ QUERO MANIPULAR TODOS OS DADOS.
//                .mapToInt(new ToIntFunction<String>() {
//                    @Override
//                    public int applyAsInt(String s) {
//                        return Integer.parseInt(s);
//                    }
//                }); ASSIM JÁ ESTAVA OK....
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os números ímpares:");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numerosAleatoriosInteger.removeIf(integer -> integer % 2 != 0);
        System.out.println(numerosAleatoriosInteger);
    }
}

