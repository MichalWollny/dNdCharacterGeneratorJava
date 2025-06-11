package template;

import java.util.Arrays;
import java.util.Scanner;
// Import java.util.Scanner für Konsolen-Eingaben

class Fahrzeug // Eine Klasse
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

public class AusgabeDatentypen // Eine Klasse
{
    static int summe(int a, int b) // statische int-Methode mit zwei int-Parametern.
    {
        return a + b;
    }

    public static void main(String[] args)
    {
        System.out.println("ALLGEMEINES");

        //Fahrzeug.kennzeichen = "Mein Kennzeichen"; // Kann nicht auf die Variable zugreifen, da sie nicht statisch ist!
        Fahrzeug fahrzeug = new Fahrzeug(); // Erzeugt ein Objekt der Klasse Fahrzeug.
        fahrzeug.kennzeichen = "Mein Kennzeichen"; // Hier kann ich nun auf die nicht-statische (Instanz-) Variable zugreifen.

        Fahrzeug.anzahlTüren = 5; // Direkter Zugriff auf die statische Variable der Klasse 'Fahrzeug'.

        Fahrzeug.ausgabe(); // Aufruf der statischen Methode.

        // 'ergebnis' ist eine lokale Variable.
        // Lokale Variablen können nicht statisch sein.
        int ergebnis = summe(5, 15); // Aufruf der Methode und Übergabe von zwei Argumenten. (Da 'summe' in derselben Klasse als die 'main' ist, muss der Name der Klasse nicht angegeben werden)
        System.out.println(ergebnis);

        System.out.println("AUSGABE");

        int zahl1 = 10;
        int zahl2 = 20;
        // Ausgabe mit String-Konkatenation:
        System.out.println("Der Wert der Variable zahl1 lautet: " + zahl1 + " und zahl2: " + zahl2 + " <- Ausgabe durch String-Konkatenation");
        System.out.print("\n"); // Zeilenumbruch durch \n

        // Ausgabe mit String.format
        // Formatierungszeichen unter https://www.javatpoint.com/java-string-format
        String s = String.format("Der Wert der Variable zahl1 lautet: %s und zahl2: %s <- mit String.format()", zahl1, zahl2);
        System.out.println(s);
        // Variante mit printf()
        System.out.printf("Der Wert der Variable zahl1 lautet: %s und zahl2: %s <- mit printf() %n", zahl1, zahl2); // Zeilenumbruch durch %n

        // Ausgabe mit StringBuilder
        StringBuilder sb = new StringBuilder(); // Ein Objekt des StringBuilders erzeugen
        sb.append("Der Wert der Variable zahl1 lautet: ");
        sb.append(zahl1);
        sb.append(" und zahl2: ").append(zahl2);
        sb.append(" <- mit StringBuilder");
        System.out.println(sb.toString());

        System.out.println();
        System.out.println("DATENTYPEN");

        // Primitive Datentypen
        //                      // Wertebereich                             // Standardwert         // Größe [Bit]
        boolean bool = true;    // true, false                              // false                // 1
        byte b8 = 1;            // -128...+127                              // 0                    // 8
        short short16 = 2;      // -2^15...+2^15-1                          // 0                    // 16
        int int32 = 3;          // -2^31...+2^31-1                          // 0                    // 32
        long long64 = 4L;       // -2^63...+2^63-1                          // 0                    // 64
        float float32 = 3.5F;   // +-1.2*10^-38...+-3.4*10^38               // 0                    // 32
        double double64 = 50.5; // +-2.2*10^-308...+-1.8*10^308             // 0                    // 64
        char character = 'C';   // \u0000 ... \uFFFF (Unicode Zeichen)      // \u0000 (NULL)        // 16
        // https://www.utf8-zeichentabelle.de/unicode-utf8-table.pl?utf8=dec

        float f = 1.0F; // Der Standard-Typ für Kommazahlen ist Double. Um die Zahl in einen Float zu schreiben, müssen wir F angehen oder in float casten.
        f = (float)2.0; // Beispiel mit Cast.
        long l = 10_000_000_000L; // Bei Zahlen größer als knapp 2 Milliarden (int) muss ich L für long angeben!

        // Floating Points und Precision: https://0.30000000000000004.com/

        System.out.println("CASTEN");
        int integer = 1234567890;
        //short integerInShort = integer; // Fehler, da Integer zu groß für Short ist.
        short integerInShort = (short)integer; // Durch den expliziten Cast wird aus int ein short.
        System.out.println(integerInShort);

        System.out.println("AUSGABE");
        // Ausgabe der ganzzahligen Datentypen:
        System.out.println(b8 + " " + short16 + " " + int32 + " " + long64);

        // Mögliches Problem:
        System.out.println("Die Summe von int32 und short16 ist: " + int32 + short16);
        // Die Werte wurden fälschlich konkateniert.

        // GRUND: Konkatenation "gewinnt" gegen Addition. Befehle werden von links nach rechts aufgelöst.
        // LÖSUNG: Wir verwenden Klammern! Die Klammern haben eine höhere Priorität und werden daher vor dem +-Operator ausgewertet.
        System.out.println("Die Summe von int32 und short16 ist: " + (int32 + short16));
        // Rangfolge der Operatoren: https://www.javatpoint.com/highest-precedence-in-java

        System.out.println("BEISPIEL WRAPPER-KLASSEN");
        // Integer-Klasse (Wrapper-Klasse: existieren zu allen primitiven Typen)
        int int32min = Integer.MIN_VALUE; // Speichern des MIN_VALUE Wertes aus der Klasse Integer in einer int-Variable.
        int int32max = Integer.MAX_VALUE;
        System.out.println(int32min + " " + int32max);

        System.out.println(Integer.toBinaryString(42));

        //Integer I32 = Integer.valueOf(42);
        Integer I32 = 42; // Integer-Klasse: verpackt einen primitiven Datentyp in ein Objekt.
        System.out.println(I32);

        System.out.println("CHARACTER UND STRING");
        // Zeichen
        char c = 'q';
        System.out.println(c);

        // String-Klasse
        String s1 = "Dies ist ein String"; // Die String-Klasse repräsentiert Zeichenketten.
        // Da Strings Objekte der Klasse String sind, verfügen sie im Gegensatz zu den primitiven Datentypen über Methoden.
        String s1LowerCase = s1.toLowerCase(); // Alle Zeichenketten im String kleinschreiben:
        System.out.println(s1LowerCase);
        System.out.println("Anzahl der Zeichen: " + s1.length());
        System.out.println("Zeichen an Index 0: " + s1.charAt(0));
        String[] splitted = s1.split(" ");
        System.out.println(Arrays.toString(splitted));

        // Problem: Konkatenation von Character
        //String s2 = c + c + c;
        // Fehlermeldung: Der Typ eines Characters (intern als Integer gespeichert) kann NICHT implizit in einen String konvertiert werden.
        //System.out.println(c + c);

        // Lösung:
        String s2 = "" + c + c + c;
        System.out.println(s2);

        System.out.println();
        System.out.println("BOOLEAN");

        // Boolesche Werte: wahr oder falsch, bzw. true or false
        boolean eingabeOk = false;

        Scanner scanner = new Scanner(System.in); // Instanziierung des Scanners. Heißt: Wir haben ein Objekt der Klasse Scanner erzeugt.

        do
        {
            System.out.print("Geben Sie bitte die wahre Identität von Spider-Man (Earth-616) ein: ");
            String name = scanner.nextLine(); // Die Eingabe wird in der Variable 'name' gespeichert.

            // Strings vergleichen wir über die equals()-Methode.
            if (name.equals("Peter Parker")) // equals() liefert Boolean zurück. Also entweder "true" oder "false".
            {
                eingabeOk = true; // Die Eingabe war korrekt, also ist eingabeOk == true;
                System.out.println("Ihre Eingabe war korrekt.");
            }
            else
            {
                System.out.println("Ihre Eingabe war nicht korrekt.");
            }

        } while(!eingabeOk); // Das '!' lesen wir als "nicht" oder "not"
        // Führe die Schleife so lange aus, wie NICHT eingabeOk. Oder anders: Führe die Schleife so lange aus, wie eingabeOk == false.

        System.out.println(eingabeOk);
    }

}
