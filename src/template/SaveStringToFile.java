package template;

import java.io.FileWriter;
import java.io.IOException;

public class SaveStringToFile {

    public static void main(String[] args) {
        // Der String, den Sie speichern möchten
        String content = "Dies ist ein Beispieltext, der in eine Datei gespeichert wird.";

        // Der Dateiname, unter dem der String gespeichert werden soll
        String fileName = "output.txt";

        // Speichern des Strings in die Datei
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Der Inhalt wurde erfolgreich in " + fileName + " gespeichert.");
        } catch (IOException e) {
            System.out.println("Ein Fehler ist aufgetreten.");
            e.printStackTrace();
        }
    }
}