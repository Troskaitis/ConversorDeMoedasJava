package com.example.conversormoedas;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Conversor {

    private static final String API_KEY = "e0d5eeff4e7d9a7202dd4029";

    public static void converter(String moedaDestino) {
        double taxaDeCambio = getTaxaDeCambio(moedaDestino);
        if (taxaDeCambio != 0.0) {
            System.out.printf("Conversão: Real (BRL) para %s\n", moedaDestino);
            System.out.print("Insira o valor em Real (BRL): ");
            double valor = new Scanner(System.in).nextDouble();
            double valorConvertido = valor * taxaDeCambio;
            System.out.printf("%.2f Real (BRL) equivale a %.2f %s\n", valor, valorConvertido, moedaDestino);
        } else {
            System.out.println("Taxa de câmbio não encontrada para a moeda de destino.");
        }
    }

    private static double getTaxaDeCambio(String moedaDestino) {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/BRL";
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convertendo para JSON
            JsonParser jp = new JsonParser();
            JsonObject jsonobj = jp.parse(new InputStreamReader(request.getInputStream())).getAsJsonObject();

            // Acessando o objeto
            JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
            JsonElement taxaElement = rates.get(moedaDestino);
            return taxaElement != null ? taxaElement.getAsDouble() : 0.0;

        } catch (IOException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
