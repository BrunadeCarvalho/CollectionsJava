package Stream;

import java.util.*;
import java.util.function.Function;

public class RefatoracaoExercicioProposto3 {
    public static void main(String[] args) {
        //1:
        System.out.println("--\tOrdem Aleatória\t--");
        Map<Integer, Contato> meusContatos = new HashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));

        }};
        for (Map.Entry<Integer, Contato> entry: meusContatos.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        //2:
        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> meusContatos2 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));

        }};
        for (Map.Entry<Integer, Contato> entry: meusContatos2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> meusContatos3 = new TreeMap<>(meusContatos2){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));

        }};
        for (Map.Entry<Integer, Contato> entry: meusContatos3.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
        System.out.println("--\tOrdem número telefone\t--");

        //FAZEMOS O COMPARATOR DENTRO DO TREESET!

        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
            }
        });
        set.addAll(meusContatos.entrySet());
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem número telefone COM COMPARING\t--");
        Set<Map.Entry<Integer, Contato>> set4 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));
        set.addAll(meusContatos.entrySet());
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem número telefone COM LAMBDA\t--");
        Set<Map.Entry<Integer, Contato>> set5 = new TreeSet<>(Comparator.comparing(
         cont -> cont.getValue().getNumero()));


        set.addAll(meusContatos.entrySet());
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero());
        }


                System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparatorOrdemContato());
        set1.addAll(meusContatos.entrySet());
        for (Map.Entry<Integer, Contato> entry: set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

    }

}



class Contato{
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}

// class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>>{
//
//
//    @Override
//    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
//        return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
//    }
//}

class ComparatorOrdemContato implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
}

