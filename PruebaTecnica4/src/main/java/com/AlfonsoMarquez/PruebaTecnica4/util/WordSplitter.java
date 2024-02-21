package com.AlfonsoMarquez.PruebaTecnica4.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSplitter {

    public static String buildString(List<String> words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    public static List<String> splitWords(String texto) {
        List<String> wordsList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z][a-z]*|[a-z]+|[A-Za-z]+-[A-Za-z]+");
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            wordsList.add(matcher.group());
        }
        return wordsList;
    }

    // Coge las 3 primeras letras de una palabra y las devuelve en un String, Si la palabra tiene
    // Menos de 3 letras devuelve el String directamente.
    // Funcion auxiliar usada para generar los codigos de los hoteles

    public static String getFirstThreeLetters(String place)
    {
        if (place == null || place.length() < 3) {
            return place;
        }
        return place.substring(0, 3);

    }

}
