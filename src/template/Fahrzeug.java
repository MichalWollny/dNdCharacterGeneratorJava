package template;

class Fahrzeug1 // Eine Klasse
{
    // Hier sind Methoden und Variablen erlaubt (innerhalb einer Klasse)
    // Variablen und Methoden werden zusammengefasst "Klassen-Member" genannt.

    // "Globale" Variablen, auch Felder genannt, (Attribute der Klasse), die innerhalb jeder Methode in dieser klasse bekannt sind.
    static short anzahlTüren = 4; // Statisch -> "für sich alleine lebensfähig", d.h. ohne Objekt-Verweis (Klassen-Variable)
    String kennzeichen = "ABC-123"; // Nicht statisch -> nur über Objekte aufrufbar (Instanz-Variable).

    // Unterschied statisch/nicht-statisch: Jedes Objekt einer Klasse erhält eine eigene Kopie der nicht-statischen Variablen und wenn die Variable für ein Objekt geändert wird, ist es auch nur für dieses eine Objekt geändert und alle anderen bleiben auf dem ursprünglichen Wert. Ändere ich eine statische Variable, ist diese für alle Objekte geändert.

    static void ausgabe() // Parameterlose void Methode. Keine Parameter und keine Rückgabe.
    {
        System.out.println("Alle meine Fahrzeuge haben " + anzahlTüren + " Türen.");
    }
}
