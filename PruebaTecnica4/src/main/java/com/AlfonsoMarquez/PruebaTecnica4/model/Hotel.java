package com.AlfonsoMarquez.PruebaTecnica4.model;

import com.AlfonsoMarquez.PruebaTecnica4.util.BooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    private String hotelCode;
    private String name;
    private String place;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    /* CAMBIAR A OTRO SITIO

    public static String buildString(List<String> words) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word).append(" ");
        }

        return result.toString().trim();
    }

    public static List<String> splitWords(String texto) {
        List<String> wordsList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Z][a-z]*|[a-z]+");
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            wordsList.add(matcher.group());
        }

        return wordsList;
    }

    */
}
