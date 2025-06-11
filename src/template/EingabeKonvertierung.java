package template;

// Eingabe und Konvertierung von der Eingabe in den gewünschten Datentyp:

import java.util.InputMismatchException;
import java.util.Scanner; // Importieren der Scanner-Klasse.

public class EingabeKonvertierung
{
    static Scanner scanner = new Scanner(System.in); // Hier erstellen wir ein Objekt der Scanner-Klasse, übergeben dem Konstruktor den Wert "System.in" und weisen es der Variable "scanner" zu.
    // System.in ist ein InputStream, der typischerweise mit der Tastatureingabe von Konsolenprogrammen verbunden ist.

    public static void main(String[] args)
    {
        // Eingabe:
        System.out.println("EINGABE");
        // Zum Einlesen werden wir die importierte Klasse "Scanner" verwenden.

        System.out.print("Geben Sie bitte einen Text ein: "); // Konsolenausgabe als Aufforderung, etwas einzugeben.
        String text = scanner.nextLine(); // Hier wird mit der Methode "nextLine()" der Scanner-Klasse die Eingabe aufgenommen und im String "text" gespeichert.

        System.out.println("Ihre Eingabe lautet: " + text);

        // Eingabe und Parse in Ganzzahl-Typ
        System.out.println("EINGABE UND PARSE IN GANZZAHL-TYP");

        System.out.print("Geben Sie eine Zahl ein: "); // Aufforderung, eine Zahl einzugeben.
        String zahlAlsString = scanner.nextLine(); // Eingabe erstmal als String über nextLine()
        int zahl = Integer.parseInt(zahlAlsString); // Umwandlung mit parseInt() in einen Integer. Dazu verwenden wir die Klasse "Integer".
        System.out.println("Ihre Eingabe lautet: " + zahl); // Ausgabe der eingegebenen und konvertierten Zahl.

        // In einer Zeile:
        //zahl = Integer.parseInt(scanner.nextLine());

        // oder:
        //System.out.println(Integer.parseInt(scanner.nextLine()));

        // "Integer" ist eine Wrapperklasse. Diese existieren zu allen primitiven Datentypen und stellen diverse Methoden zum Arbeiten mit diesem Typen zur Verfügung, wie hier das Parsen.
        // Weitere sind Byte, Short, Long, Float, Double, Boolean.

        // Alternative Eingabe über nextInt()
        System.out.print("Geben Sie eine Zahl ein (nextInt): ");
        zahl = scanner.nextInt(); // Der eingegebene Text wird sofort als Integer verarbeitet.
        System.out.println(zahl);

        // ACHTUNG: Möchte ich nach der Eingabe von Zahlen über nextInt() wieder einen Text einlesen, muss zuerst der Eingabepuffer geleert werden!
        scanner.nextLine(); // Hier steckt noch ein \n im eingabepuffer, welches durch nextLine() geschluckt wird.
        System.out.print("Geben Sie einen Text ein: ");
        text = scanner.nextLine(); // Danach funktioniert die Eingabe von Text wieder normal.
        System.out.println(text);

        // Fehler bei der Eingabe fangen:
        System.out.println("FEHLER ABFANGEN MIT TRY-CATCH");

        try
        {
            System.out.print("Geben Sie eine Zahl ein (Fehler werden gefangen): ");
            int zahl2 = Integer.parseInt(scanner.nextLine());
            System.out.println("Ihre Eingabe lautet: " + zahl2);

            System.out.print("Geben sie eine Zahl ein (nextInt): ");
            zahl2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ihre Eingabe lautet: " + zahl2);
        }
        catch (NumberFormatException ex) // Wird von parseInt() geworfen, wenn der String nicht umgewandelt werden kann.
        {
            System.err.println("Fehler bei der Umwandlung in Integer! " + ex.getMessage());
        }
        catch (InputMismatchException ex) // Wird von nextInt() geworfen, wenn etwas anderes als ein Integer eingegeben wurde.
        {
            System.err.println("Fehler bei der Eingabe! " + ex.getMessage());
        }

        // Wiederholen der Eingabe:
        System.out.println("EINGABE SOLANGE WIEDERHOLEN, BIS DIE EINGABE KORREKT WAR");

        boolean eingabeOk = false; // Mit dieser Variable bestimmen wir den Abbruch der Schleife.
        while (!eingabeOk) // Solange die Eingabe NICHT OK ist... (dafür das ! vor eingabeOk)
        {
            try
            {
                int eingabe = eingabeInteger(); // Die Methode wirft bei falscher Eingabe eine Exception.
                System.out.println("Ihre Eingabe: " + eingabe);
                eingabeOk = true; // War die Eingabe korrekt, setzten wir eingabeOk auf true und verlassen damit die Schleife.
            }
            catch (NumberFormatException ex) // Diese Exception fangen wir hier ab und geben eine Fehlermeldung aus.
            {
                System.out.println(ex.getMessage());
            }
        }

        // Hier wird die Exception bereits in der Methode gefangen.
        int eingabe = eingabeIntegerMitTryCatch();
        System.out.println("Ihre Eingabe: " + eingabe);

        // Natürlich können Strings auch in andere primitive Datentypen konvertiert werden.
        double d = Double.parseDouble("1.5"); // ACHTUNG: "parse" möchte bei Fließkommazahlen einen Punkt anstatt Komma!
        float f = Float.parseFloat("1.1");
        long l = Long.parseLong("1234567890");


    } // Hier ist die Main zu Ende!

    /**
     * Fragt eine Eingabe vom Benutzer ab und konvertiert diese in einen Integer.
     * @return Der konvertierte Integer.
     * @throws NumberFormatException Falls die Eingabe nicht in einen Integer konvertiert werden kann.
     */
    static int eingabeInteger() throws NumberFormatException // Um deutlich zu machen, dass diese Methode eine Exception verursachen könnte, fügen wir ihr in der Deklaration die Exception hinzu. Bei den sogenannten "Checked Exceptions" ist dies Pflicht, bei "Unchecked Exceptions" ist es freiwillig.
    {
        System.out.print("Eingabe: "); // Konsolenausgabe als Aufforderung, eine Zahl einzugeben.
        String eingabe = scanner.nextLine(); // Scanner liest einen String von der Konsole.
        int zahl = Integer.parseInt(eingabe); // Wir konvertieren den String in einen Integer...
        return zahl; // und geben die Zahl zurück.
    }

    /**
     * Fragt eine Eingabe vom Benutzer ab und konvertiert diese in einen Integer.
     * Kann die Eingabe nicht konvertiert werden, muss die Eingabe wiederholt werden.
     * @return Der konvertierte Integer.
     */
    static int eingabeIntegerMitTryCatch()
    {
        while (true)
        {
            System.out.print("Eingabe: ");
            String eingabe = scanner.nextLine();

            try
            {
                int zahl = Integer.parseInt(eingabe); // Kann die Eingabe nicht in einen Integer konvertiert werden, wird eine NumberFormatException geworfen.

                return zahl; // Die konvertierte Eingabe wird zurückgegeben. Damit wird auch die Schleife beendet.
            }
            catch (NumberFormatException ex) // Die Exception fangen wir ab und geben eine Fehlermeldung aus.
            {
                System.out.println("Falsche Eingabe! " + ex.getMessage());
            }
        }
    }



}
