package Set;

// DADAS AS SEGUINTER INFORMAÇÕES SOBRE MINHAS SÉRIES FAVORITAS,
/// CRIE UM CONJUNTO E ORDENE ESTE CONJUNTO EXIBINDO:
// (NOME - GENERO - TEMPO DE EPISÓDIO.

// SERIE 1: Nome: got, genero: fantasia, tempoEpisodio: 60
// SERIE 2: Nome: dark, genero: drama, tempoEpisodio: 60
// SERIE 3: Nome: that 70s show, genero: comédia, tempoEpisodio: 25

import java.util.*;

public class OrdenacaoSet {
    public static void main(String[] args) {

        System.out.println(" Ordem aleatória");
        Set <Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60 ));
            add(new Serie("dark", "drama", 60 ));
            add(new Serie("that '70s show", "comedia", 25 ));
        }};

        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println(" Ordem inserção");
        Set <Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60 ));
            add(new Serie("dark", "drama", 60 ));
            add(new Serie("that '70s show", "comedia", 25 ));
        }};

        for (Serie serie: minhasSeries1) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println(" Ordem natural (TempoEpisódio");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        System.out.println(minhasSeries2);

        System.out.println(" Ordem Nome/Genero/TempoEpisódio");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatoNomeGeneroTempoEpisodio());
        // adicionar os valores no TreeSet:
        minhasSeries3.addAll(minhasSeries);
        // agora ela foi add e será coloca na ordem solicitada no TreeSet.

        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());


        System.out.println(" Ordem aleatória");
    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return  tempoEpisodio;
        return this.getGenero().compareTo(serie.getGenero());
    }
}

class ComparatoNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        // se o nome for diferente, vai comparar pelo nome, mas se o nome for igual vai comparar pelo genero,
        //se nome e genero forem igual, compara pelo tempo.
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;


        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}