package com.objis.ensup.lanceur;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.File;

import com.objis.ensup.domaine.Employe;

public class DemoJsonJackson {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        //Object vers fichier JSON
        File resultFile = new File("employe.json");
        Employe employe = mapper.readValue(resultFile, Employe.class);
        employe.poserConges();
    }
}
