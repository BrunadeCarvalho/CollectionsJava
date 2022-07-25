package Map;

import java.util.*;

public class ExemploMapCarros {
    public static void main(String[] args) {

// DADO OS MODELOS DOS CARROS E SEUS CONSUMOS NA ESTRADA, FAÇA:

// modelo = gol - consumo = 14,4km/l
// modelo = uno - consumo = 15,6km/l
// modelo = mobi - consumo = 16,1,4km/l
// modelo = hb20 - consumo = 14,5km/l
// modelo = kwid - consumo = 15,6km/l

        // 1:
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.5);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 16.6);
        }};
        System.out.println(carrosPopulares);

        //2:
        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        // COMO ELE NÃO PERMITE DUPLICADOS,ELE VAI APENAS ALTERAR O ANTIGO GOL
        // NO CASO MODIFICOU O KM/L!:
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        //3:
        System.out.println("Confira se o modelo tucson está no dicionário: "
                + carrosPopulares.containsKey("tucson"));

        //4:
        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

        //5:
        System.out.println("Exiba o terceiro modelo adicionado: ");
        // NÃO PERMITE PEGAR DADOS A PARTIR DO INDICE, E TAMBÉM PORQUE ELE ADICIONA
        // OS VALORES DE FORMA ALEATÓRIA.

        //6:
        System.out.println("Exiba os modelos: ");
        // O Key Set retorna um Set:
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        //7
        System.out.println("Exiba os consumos dos carros ");
        Collection<Double> consumo = carrosPopulares.values();
        System.out.println(consumo);

        //8
        System.out.println("Exiba o modelo mais economico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        String modeloMaisEficiente = " "; // variavel de controle

        for (Map.Entry<String, Double> entry: entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) modeloMaisEficiente = entry.getKey();
        }

        System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);

        //9
        System.out.println("Exiba o modelo menos economico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();

        String modeloMenosEficiente = " ";

        for (Map.Entry<String, Double> entry: entries1) {
            if (entry.getValue().equals(consumoMenosEficiente)) modeloMenosEficiente = entry.getKey();
        }

        System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);

        // 10:
        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma =  0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        //11:
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/ carrosPopulares.size()));

        //12:
        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);

        //13:
        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.5);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 16.6);
        }};
        System.out.println(carrosPopulares1);

        //14:
        System.out.println("Exiba o dicionário ordenado pelo modelo:");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        //15:
        System.out.println("Apague o dicionário d carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);


        }

}
