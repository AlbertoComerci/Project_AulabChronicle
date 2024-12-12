package it.aulab.progetto_finale_java.utils;

//  Abbiamo bisogno di estrapolare l’estensione del file da quello originale inserito nel form e mandarlo nel modo corretto allo storage
// metodo che riceve in input la stringa del nome del file e ne estrapola l’estensione
public class StringManipulation {

    public static String getFileExtension(String nameFile) {

        int dotIndex = nameFile.indexOf('.');
        String extension = nameFile.substring(dotIndex + 1);
        return extension;
    }

}
