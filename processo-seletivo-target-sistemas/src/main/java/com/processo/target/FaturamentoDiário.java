package com.processo.target;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FaturamentoDiário {
  public static void main(String[] args) {
    List<Double> faturamento = new ArrayList<Double>();
    double media = 0, menor = Double.MAX_VALUE, maior = Double.MIN_VALUE;

    try {
      JSONParser parser = new JSONParser();
      JSONArray array = (JSONArray) parser.parse(new FileReader("src/main/java/data/faturamentodiario.json"));

      for (Object obj : array) {
        JSONObject json = (JSONObject) obj;
        double valor = (double) json.get("valor");

        if (valor > 0) {
          faturamento.add(valor);

          if (valor < menor) {
            menor = valor;
          }

          if (valor > maior) {
            maior = valor;
          }
        }
      }

      double soma = 0;
      for (double valor : faturamento) {
        soma += valor;
      }

      media = soma / faturamento.size();
    } catch (Exception e) {
      e.printStackTrace();
    }

    int diasAcimaMedia = 0;
    for (double valor : faturamento) {
      if (valor > media) {
        diasAcimaMedia++;
      }
    }

    System.out.println("Menor valor de faturamento diário: R$ " + menor);
    System.out.println("Maior valor de faturamento diário: R$ " + maior);
    System.out.println("Número de dias acima da média: " + diasAcimaMedia);
  }
}
