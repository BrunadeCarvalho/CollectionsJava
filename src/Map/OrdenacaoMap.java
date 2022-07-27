package Map;

// Dados as seguintes informações sobre meus livros favoritos
// e seus autores, crie um dicionário e ordene:
// exibindo (Nome Autor - Nome Livro):

// Autor = Hawking, Stephen - Livro = nome: Um Breve Historia do Tempo. paginas: 256
// Autor = Duhigg, Charles - Livro = nome: O Poder do Habito. paginas: 408
// Autor = Harari, Yuval Noah - Livro = nome: Lições para o Século 21. paginas: 432


import java.util.*;

public class OrdenacaoMap {
    public static void main(String[] args) {

    // 1:
        System.out.println("-----Ordem Aleatória------");

        Map<String, Livros> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livros ("Um Breve Historia do Tempo", 256));
            put("Duhigg, Charles", new Livros ("O Poder do Habito", 408));
            put("Harari, Yuval Noah", new Livros ("Lições para o Século 21", 432));
        }};

        for(Map.Entry<String, Livros> livros : meusLivros.entrySet())
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());

    // 2:
        System.out.println("-------Ordem Inserção------");
        Map<String, Livros> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livros ("Um Breve Historia do Tempo", 256));
            put("Duhigg, Charles", new Livros ("O Poder do Habito", 408));
            put("Harari, Yuval Noah", new Livros ("Lições para o Século 21", 432));
        }};

        for(Map.Entry<String, Livros> livros : meusLivros1.entrySet())
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());


    // 3:
        System.out.println("----------Ordem alfabética autores------------");
        Map<String, Livros> meusLivros2 = new TreeMap<>(meusLivros1){{
            put("Hawking, Stephen", new Livros ("Um Breve Historia do Tempo", 256));
            put("Duhigg, Charles", new Livros ("O Poder do Habito", 408));
            put("Harari, Yuval Noah", new Livros ("Lições para o Século 21", 432));
        }};

        for(Map.Entry<String, Livros> livros : meusLivros2.entrySet())
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());

    // 4:
        System.out.println("--------Ordem alfabética nomes dos livros----------");

        Set<Map.Entry<String, Livros>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());

        for(Map.Entry<String, Livros> livros : meusLivros3)
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());

        System.out.println("-----------Ordem número de páginas-------");

    }
}

class Livros {
    private String nome;
    private Integer paginas;

    public Livros(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livros livros = (Livros) o;
        return nome.equals(livros.nome) && paginas.equals(livros.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livros{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements  Comparator<Map.Entry<String, Livros>>{

    @Override
    public int compare(Map.Entry<String, Livros> l1, Map.Entry<String, Livros> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}
