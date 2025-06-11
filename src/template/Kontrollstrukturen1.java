package template;

// Thema Kontrollstrukturen:
// Umfasst die Verzweigungen (If-Else, Switch-Case) und die Schleifen (For, Foreach, While, Do-While)

public class Kontrollstrukturen1
{
    public static void main(String[] args)
    {
        // Verzweigung (if)
        // eine einfache Verzweigung wird durch das "if-then-else"-Konstrukt gelöst, wobei lediglich if und else ind Java Schlüsselwörter sind.
        System.out.println("VERZWEIGUNG (IF)");

        // Beispiel 1:
        boolean beenden = false;
        if (beenden) // Wenn die Bedingung True ist, wird dieser Teil der Verzweigung ausgeführt (beenden == true)
        {
            System.out.println("Das Programm wird nun beendet!");
            System.exit(0);
        }
        else // optionales Else
        {
            System.out.println("Das Programm wird weiter ausgeführt.");
        }

        // Beispiel 2:
        int zahl = 10;
        if (zahl > 10)
        {
            System.out.println("Die Zahl ist größer 10");
        }
        else if (zahl < 10) // Nach einem ersten If können beliebig viele Else-If folgen.
        {
            System.out.println("Die Zahl ist kleiner 10");
        }
        else // Optionales Else - steht immer als Letztes.
        {
            System.out.println("Die Zahl ist genau 10");
        }

        // Ternärer Operator (?:)
        // wenn nur zwischen zwei Ausgabewerten / Rückgabewerten unterschieden werden soll, gibt es für die If-Then-Else-Anweisung eine Kurzform:
        // der "Ternary-Operator".
        System.out.println("TERNARY OPERATOR");

        String zustand = "gefroren";

        // Anstelle der Anweisung:
        if (zustand.equals("gefroren"))
            System.out.println("Eis ist da."); // Habe ich nur eine einzige Anweisung, können die geschweiften Klammern weggelassen werden.
        else
            System.out.println("Wasser ist da.");

        // kann auch geschrieben werden:
        System.out.println((zustand.equals("gefroren")) ? "Eis ist da." : "Wasser ist da.");
        // Syntax: Bedingung ? dann : sonst
        // Dabei muss der Gesamtausdruck immer eine Rückgabe sein.

        // Weiteres Beispiel:
        int zahl2 = 42;
        String ergebnis = (zahl2 % 10 == 0) ? "Restlos durch 10 teilbar." : (zahl2 % 2 == 0) ? "Nicht restlos durch 10 teilbar, aber durch 2." : "Weder restlos durch 10 noch durch 2 teilbar.";
        // Ist zahl2 ohne Rest durch 10 teilbar, dann wird "Restlos durch 10 teilbara." zurückgegeben.
        // Sonst wird geprüft, ob zahl2 durch 2 ohne Rest teilbar ist. Wenn ja, wird "Nicht restlos durch 10 teilbar, aber durch 2." zurückgegeben.
        // Sonst wird "Weder restlos durch 10 noch durch 2 teilbar." zurückgegeben.
        System.out.println(ergebnis);

        // Mehrfachverzweigung (Switch-Case)
        System.out.println("MEHRFACHVERZWEIGUNG (SWITCH-CASE)");
        // Das If-Konstrukt führt bei Vergleichen auf exakte Übereinstimmung mit vielen Möglichkeiten meist zu unschönem und schwer lesbarem Code.
        // Hier kann Switch-Case helfen.
        int meineZahl = 1;

        switch (meineZahl)
        {
            case 0:
                System.out.println("Meine Zahl ist 0.");
                break;
            case 1:
                System.out.println("Meine zahl ist 1.");
                //break; // Wird das break weggelassen, findet ein sogenanntes "fall through" statt. Es werden alle weiteren Anweisungen bis zum nächsten break ausgeführt.
            case 2:
                System.out.println("Meine Zahl ist 1 oder 2.");
                break;
            default:
                System.out.println("Meine Zahl entspricht nicht der Vorgabe.");
        }

        // Neuere Java Versionen können auch eine abgewandelte Form des Switch-Case -> Switch-Expressions
        //https://docs.oracle.com/en/java/javase/21/language/switch-expressions.html

        /*
         * Eine switch Anweisung wird stets mit dem Schlüsselwort case und meist mit default und break verwendet. Der Wert hinter dem case muss eine Konstante sein
         *  und dient dem Vergleich mit dem übergebenen Wert (hier meineZahl). Wenn diese gleich sind, werden alle Anweisungen bis zum nächsten break oder dem Ende
         *  des Blocks ausgeführt. Wurden keine Übereinstimmung gefunden so werden die Anweisung nach default ausgeführt. Seit Java 7 ist es ebenfalls möglich, den
         *  Datentyp String in Switch-Anweisungen zu verwenden. Zuvor war es seit Java 5.0 lediglich möglich, anstelle von String den Datentyp enums zu benutzen.
         */

        // For-Schleife
        System.out.println("FOR-SCHLEIFE");
        // Die For-Schleife oder Zählschleife zählt von einem vorgegebenen Startwert zu einem ebenfalls vorgegebenen Endwert und führt für jeden Schritt von Start- bid Endwert alle Anweisungen im Schleifenkörper aus. Es muss zusätzlich festgelegt werden, in welchen Intervallen bzw. Schritten von Start bis Ende gezählt wird.

        // Einfache For-Schleife
        for (int i = 0; i < 5; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        // In For-Schleifen können auch weitere Variablen, Bedingungen und Zählschritte hinzugefügt werden.
        for (int i = 0, j = 1; i < 5 || j < 10; i++, j += 2)
            System.out.print(i + " " + j + " "); // Habe ich nur eine einzige Anweisung, können die geschweiften Klammern weggelassen werden.

        System.out.println();

        // Ein Array zur Aufnahme von Zahlen
        int[] intArray = new int[10];
        // Befüllen des Arrays mit 10 Zahlen:
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = i*2;

        System.out.println("Erstes Element im Array: " + intArray[0]);

        // Foreach-Schleife
        System.out.println("FOREACH-SCHLEIFE");
        // Foreach-Schleifen eignen sich besonders gut, um Arrays auszugeben oder anderweitig weiterzuverarbeiten.
        // Bei jeder Schleifeniteration wird der Inhalt einer Position im Array in die Variable kopiert und danach im Schleifenkörper verarbeitet.
        // Die Schleife läuft immer vom ersten Element des Arrays bis zum letzten.
        for (int zahlImArray : intArray)
            System.out.print(zahlImArray + " ");
        System.out.println();

        // Schleife mit Vorabprüfung (While)
        System.out.println("SCHLEIFE MIT VORABPRÜFUNG (WHILE)");
        // Die While-Schleife führt den Anweisungsblock aus, solange die Prüfung True ergibt.
        // Die Prüfung der Bedingung erfolgt dabei vor dem Betreten der Schleife und vor jedem Schleifendurchlauf.
        int i = 0;
        while (i < 10)
        {
            System.out.println("While-Schleife läuft...");
            i++;
        }

        // Schleife mit Nachprüfung (Do-While)
        System.out.println("SCHLEIFE MIT NACHPRÜFUNG (DO-WHILE)");
        // Die Do-While-Schleife führt alle beinhaltenden Anweisungen so lange aus, wie die Prüfung True ergibt.
        // Die Prüfung der Bedingung erfolgt dabei nach dem Schleifendurchlauf.
        // Dadurch wird die Schleife immer mindestens einmal durchlaufen.

        i = 0;
        do
        {
            System.out.println("Do-While-Schleife läuft...");
            i++;
        } while (i < 10);

        // Schleifen verlassen und überspringen (Break und Continue)
        System.out.println("SCHLEIFEN VERLASSEN UND ÜBERSPRINGEN (BREAK UND CONTINUE)");

        for (int j = 0; j < intArray.length; j++)
        {
            if (intArray[j] == 10)
            {
                System.out.println("Gefunden an Index " + j + "!");
                break; // Haben wir das gesuchte Element gefunden, verlassen wir die Schleife mit break.
            }
        }
        System.out.println();

        int n = 0;
        while (n < 10)
        {
            n++;

            if (n == 5)
            {
                System.out.print("Überspringen! ");
                continue; // Mit Continue geht die Schleifenausführung direkt zur Bedingungsprüfung und restliche Anweisungen werden übersprungen.
            }

            System.out.print(n + " ");
        }

        // For vs While
        // For-Schleifen werden meistens dann verwendet, wenn die Anzahl an Durchläufen vorher bekannt ist. Zum Beispiel die Länge des Arrays ist die Anzahl an Durchläufen.
        // While-Schleifen werden meistens dann verwendet, wenn die Anzahl nicht bekannt ist. Zum Beispiel soll der Benutzer etwas eingeben und wir wiederholen die Eingabe, wenn sie inkorrekt war.

    }
}
