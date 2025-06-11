package template;

/*Try-Catch-Finally: Exceptions und Ausnahmebehandlung

    ERLÄUTERUNG:
    Immer dann, wenn in einem (Java)-Programm etwas Unzulässiges geschieht, stürzt das Programm ab.
    Das kann Folge eines Programmierfehlers sein
    (der dann natürlich behoben werden kann und der "hoffentlich" bereits im Testlauf auffiel) ...
    ... es kann aber auch "externe" Gründe geben
    (unzulässige User-Eingaben, Werte, die aus einer Datenbank/einem Textfile gelesen werden ...)

    Solche externen Fehler können wir zwar nicht ausschließen, aber wenigstens "abfangen"(catch)
    => Programm stürzt nicht ab, sondern wir bestimmen, "wie es weitergeht"
    (Eigene Fehlermeldung, erneute Input-Abfrage ...))


    https://www.baeldung.com/java-common-exceptions
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exceptions
{
    public static void main(String[] args)
    {
        // Eine erste Fehler-Provokation: Teilen durch 0
        //int x = 1 / 0; // -> Fehlermeldung zur Laufzeit: Exception in thread "main" -> java.lang.ArithmeticException
        //System.out.println("Eine wichtige Konsolenausgabe"); // Diese Ausgabe erscheint nicht, da das Programm vorher abgestürzt ist.

        int zahl = 1;
        int teiler = 0;
        //int ergebnis = zahl / teiler; // -> Fehlermeldung zur Laufzeit: ArithmeticException

        // Um möglicherweise auftretende Exceptions abzufangen und Abstürze des Programms zu vermeiden, verpacken wir den Code in eine Try-Catch-Klausel.
        try
        {
            System.out.println("Versuche Division durch 0...");
            int ergebnis = zahl / teiler; // Hier wird die Exception geworfen und der Programmfluss springt in den Catch-Block.
            System.out.println("Ergebnis: " + ergebnis); // Dieser Code wird nicht mehr ausgeführt, da die Exception bereits aufgetreten ist.
        }
        catch (ArithmeticException ex) // Wir fangen hier eine eventuell auftretende ArithmeticException und erstellen davon eine Variable mit dem Bezeichner "ex".
        {
            System.out.println("Fehler! " + ex.getMessage()); // Mit getMessage() können wir die Fehlermeldung der Exception abfragen.
            //return;
        }

        System.out.println("Hier sind wir nach dem try-catch und unser Programm ist nicht abgestürzt.");

        // HINWEIS: Im obigen Fall wird nur die Arithmetic Exception gefangen.
        // Würde eine andere Exception auftreten, würde das Programm trotzdem abstürzen.
        // Lösung: Weitere Catch-Blöcke.
        try
        {
            //System.out.println("Versuche Division durch 0...");
            //int ergebnis = zahl / teiler;
            //System.out.println("Ergebnis: " + ergebnis);

            // Anderes Beispiel:
            String s = null;
            System.out.println(s.toLowerCase()); // Hier tritt eine NullPointerException auf, die vom allgemeinen Catch-Block gefangen wird.
        }
        catch (ArithmeticException ex) // Nur Arithmetic Exceptions fangen
        {
            // Ausgabe des fehlers über System.err.println()
            System.err.println("Arithmetic Exception! " + ex.getMessage());
        }
        catch (IllegalArgumentException ex) // Nur IllegalArgumentExceptions fangen
        {
            System.err.println("Illegal Argument Exception!" + ex.getMessage());
        }
        catch (Exception ex) // Jede andere Exception fangen. Wichtig: Allgemeine Exceptions müssen nach den speziellen Exceptions aufgelistet werden.
        {
            System.err.println("Es ist eine allgemeine Exception aufgetreten! " + ex.getMessage());
        }

        // Diese ganze Technologie ist derartig komfortabel, dass man sich im Einzelfall versehentlich zu sehr auf sie verlassen könnte.
        // Außerdem ist das Abfangen von Ausnahmen etwas teuer und reduziert die Performance des Programms.
        // Ein Beispiel, das zeigen soll, dass wir dennoch unser Programm "auf Herz und Nieren" testen sollten:
        try
        {
            //double division = (double) zahl / (double) teiler; // Die Integer-Werte werden in Double gecastet.
            //System.out.println("Ergebnis der Division ist: " + division);
            // Bei Double-Divisionen durch 0 wird keine Exception geworfen, sondern das Ergebnis ist "Infinity".

            double wurzel = Math.sqrt(-1);
            System.out.println("Die Quadratwurzel von -1 ist: " + wurzel);
            // Ergebnis: NaN = not a number = keine Zahl.
            // ABER: Keine Exception!
        }
        catch (Exception ex)
        {
            // Mögliche Ausgabe der Fehlermeldung, sollte eine auftreten, über printStackTrace();
            ex.printStackTrace();
        }

        // Finally: Der Code im Finally wird immer ausgeführt, selbst wenn wir eine Return-Anweisung haben oder keine Exception aufgetreten ist.
        // Der Finally-Block wird häufig für Aufräumarbeiten verwendet, um zum Beispiel Ressourcen wieder freizugeben.
        try
        {
            teiler = 0;
            System.out.println("Versuche Division durch " + teiler + "...");
            int ergebnis = zahl / teiler;
            System.out.println("Ergebnis: " + ergebnis);

        }
        catch (Exception ex)
        {
            // Ausgabe des Fehlers über printStackTrace()
            ex.printStackTrace(); // Die Ausgabe über printStackTrace() erscheint leicht verzögert.
            //return; // Würden wir hier die aktuelle Methode mit return verlassen, würde trotzdem noch das Finally ausgeführt werden.
        }
        // Optionaler Finally-Block: Wird immer ausgeführt, auch wenn keine Exception auftritt.
        finally
        {
            System.out.println("Hier sind wir im Finally-Block!");
        }
        System.out.println("Hier sind wir hinter dem Finally-Block!");

        // Beispiel aus der Praxis:
        // Es wurde ein Stream auf eine Datei geöffnet, es kam dabei zu einem Fehler, die Methode soll enden, ABER der Stream soll auch noch geschlossen werden.
        // Das Schließen soll aber auch dann passieren, wenn es nicht zu einem Fehler kam.
        BufferedReader reader = null;
        try
        {
            reader = Files.newBufferedReader(Paths.get("Eine Datei, die nicht existiert.txt"));
            // Die angegebene Datei existiert nicht. Dies verursacht eine NoSuchFileException.
            // Die NoSuchFileException ist eine IOException und wird in unserem Catch-Block gefangen.

            // ... weiterer Code
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            // Finally wird in jedem Fall ausgeführt. Hier schließen wir wieder den BufferedReader.
            System.out.println("Im Finally wird der Reader geschlossen!");
            try
            {
                if (reader != null)
                    reader.close(); // Geöffnete Streams auf Dateien und Datenbanken müssen auch immer wieder geschlossen werden.
            }
            catch (IOException ex) // close() könnte auch eine IOException werfen. Die IOException ist eine "Checked Exception" und muss darum gefangen werden.
            {
                ex.printStackTrace();
            }
        }

        /* Zwei Besonderheiten zu Exceptions in Java:
		Sie werden unterteilt in "Checked Exceptions" und "Unchecked Exceptions".
		Checked Exceptions müssen immer entweder gefangen werden oder die Methode muss die Exception deklarieren.
		Alle Exceptions sind Checked Exceptions mit Ausnahme der Runtime Exceptions, welche unchecked sind.
		IOException ist Checked, IllegalArgument ist eine Runtime Exception und daher unchecked.
		*/

        // Throw...
        // Mit dem Befehl 'throw' haben wir die Möglichkeit, selbst Ausnahmen zu werfen.
        // Dies kann nützlich sein, wenn Klassen geschrieben werden, die auch von anderen Entwicklern verwendet werden sollen.
        // Dabei soll, zum Beispiel, der Programmierer auf falsche Übergabewerte hingewiesen werden.
        try
        {
            myCustomThrowMethod(-1);
        }
        catch (IllegalArgumentException ex)
        {
            ex.printStackTrace();
        }

    } // Hier endet die Main

    /**
     * Macht irgendwas, wirft aber eine IllegalArgumentException, wenn das Argument 0 oder negativ ist.
     *
     * @param a
     * @throws IllegalArgumentException Wird geworfen, wenn a < 1.
     */
    static void myCustomThrowMethod(int a) throws IllegalArgumentException
    {
        if (a < 1)
        {
            throw new IllegalArgumentException("Falscher Übergabewert! Nur positive Zahlen sind gültig!");
        }
    }
}
