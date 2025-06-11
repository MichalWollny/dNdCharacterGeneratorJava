package template;

import java.util.Arrays;

public class Array
{
    public static void main(String[] args)
    {
        System.out.println("ARRAYS ALLGEMEIN");

        // Deklaration und Definition von Arrays (und mit 'new': Erzeugen eines Objektes vom angegebenen Typ)
        int[] intArray = new int[10];

        // Befüllen a) "zu Fuß"
        intArray[0] = 22;
        intArray[1] = 33;
        intArray[2] = 1;
        // ...
        intArray[9] = 123;
        //intArray[10] = 0; // Programmabsturz! ArrayIndexOutOfBoundsException -> Anzahl = 10: da wir mit 0 beginnen, geht es maximal bis 9!

        // Befüllen b) per Schleife
        // Alle Felder mit 1 füllen
        for (int i = 0; i < intArray.length; i++)
            intArray[i] = 1;

        // Zum Füllen eines Arrays mit einem bestimmten Wert kann auch Arrays.fill() aufgerufen werden.
        Arrays.fill(intArray,0,5, 42);

        // Sofortige Initialisierung:
        int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };
        int[] intArray3 = { 11, 2, 333, 4, 5555 }; // Das new int[] kann bei dieser Schreibweise weggelassen werden.

        System.out.println("Kontrollausgabe des Arrays 'intArray3'");
        for (int x : intArray3) // foreach-Schleife
            System.out.print(x + " ");

        System.out.println();

        // Die foreach-Schleife verwenden wir nur, um Arrays auszugeben oder anderweitig zu verarbeiten.
        // Um den Inhalt der Arrays zu ändern, nehmen wir die normale for-Schleife.

        // Das Array ohne Schleife ausgeben:
        System.out.println(intArray3); // Gebe ich nur die Variable aus, erhalte ich als Ausgabe eine Hash-Entsprechung des Array-Objektes.
        System.out.printf("%x%n", intArray3.hashCode());

        System.out.println(Arrays.toString(intArray3)); // Ausgabe des Array-Inhalts über Arrays.toString()

        // Das ganze geht natürlich auch für andere Datentypen:
        double[] dArray = new double[] {1.1, 22.22, 3.333};
        System.out.print("Kontrollausgabe des Double-Arrays: ");
        System.out.println(Arrays.toString(dArray)); // Ausgabe des Double-Arrays über Arrays.toString()

        String[] sArray = new String[] {"Java", "ist super!"};
        System.out.print("Kontrollausgabe des String-Arrays: ");
        System.out.println(Arrays.toString(sArray));

        String satz = "Dies ist ein Satz";
        String[] gesplittet = satz.split(" "); // mit split() können wir einen String in mehrere Teile zerlegen. dazu übergeben wir ein Zeichen, an dem der String getrennt werden soll. Das Ergebnis davon ist ein Array.
        for (String s : gesplittet)
            System.out.print(s);

        System.out.println();

        // Bemerkung zu einzelnen Zeichen eines Strings:
        String beispielString = "abcde...";
        // 2. Buchstaben (also Index 1) des Strings:
        System.out.println("Zweiter Buchstabe: " + beispielString.charAt(1));

        // 5. Buchstaben des 2. Strings eines Arrays
        System.out.println("5. Buchstabe des 2. Strings im Array: " + sArray[1].charAt(4));

        // über Substring:
        System.out.printf("Über Substring: %s%n", sArray[1].substring(4, 10));

        // Hinweis: String-Variablen wie hier lassen sich NICHT über den Index ändern, wie das bei Char-Arrays möglich wäre.
        //beispielString[0] = 'z'; // Strings sind immutable und können nicht geändert werden.
        // replace() ändert nicht den originalen String sondern gibt einen neuen String zurück.

        System.out.println();
        // Alternative:
        char[] charArray = beispielString.toCharArray(); // Aus dem String ein Character-Array erzeugen.
        charArray[0] = 'z'; // Das Character-Array verändern
        beispielString = String.valueOf(charArray); // Aus dem geänderten Character-Array wieder einen String erzeugen.
        System.out.println("Über Character-Array veränderter String: " + beispielString); // Ausgabe

        System.out.println();

        System.out.println("ARRAYS SORTIEREN");
        // Wir können Arrays auch sortieren:
        double[] dArray2 = { 4.4, 2.2, 3.3, 1.1 };
        System.out.println("Originale Reihenfolge: " + Arrays.toString(dArray2));
        Arrays.sort(dArray2);
        System.out.println("Sortierte Reihenfolge: " + Arrays.toString(dArray2));

        // Sortieren von String-Arrays
        String[] sArray2 = {"schlecht", "mittel", "super"};
        Arrays.sort(sArray2);
        System.out.println("Sortiertes String-Array: " + Arrays.toString(sArray2));
        // Hinweis: Großbuchstaben werden vor Kleinbuchstaben sortiert (ASCII/Unicode)

        /* Arrays.sort() sortiert mit unterschiedlichen Algorithmen. Eine Veranschaulichung finden sie Hier:
         * Merge Sort: https://www.youtube.com/watch?v=es2T6KY45cA
         * Insertion Sort: https://www.youtube.com/watch?v=TZRWRjq2CAg
         * Heap Sort: https://www.youtube.com/watch?v=H5kAcmGOn4Q
         * Quick Sort: https://www.youtube.com/watch?v=aXXWXz5rF64
         */

        System.out.println();
        System.out.println("ARRAYS VERGLEICHEN");

        int[] intArray4 = {1,2,3,4,5,6,7,8,9};
        int[] intArray5 = {1,2,3,4,5,6,7,8,9};

        System.out.println("Sind die Arrays ==? " + (intArray4 == intArray5 ? "Ja" : "Nein")); // Hier vergleichen wir die Speicheradressen bzw. den Hashcode.
        System.out.println(intArray4.hashCode());
        System.out.println(intArray5.hashCode());
        System.out.println("Sind die Arrays equal? " + (intArray4.equals(intArray5) ? "Ja" : "Nein")); // Auch hier wird der Hashcode verglichen und nicht der Inhalt des Arrays.
        System.out.println("Sind die Arrays.equals()? " + ((Arrays.equals(intArray4, intArray5) ? "Ja" : "Nein"))); // Hier wird tatsächlich der Inhalt der Arrays verglichen!

        System.out.println();

        System.out.println("ARRAYS DURCHSUCHEN");
        // Zum Durchsuchen von Arrays gibt es zwei Ansätze:
        // - Die lineare Suche läuft von Index 0 bis zur Länge des Arrays und vergleicht jeden Wert mit dem gesuchten Wert.
        //      Dies funktioniert gut bei unsortierten Arrays.
        // - Die binäre Suche vergleicht den gesuchten Wert mit dem Wert der Mitte und teilt das Array in zwei Teile.
        //      Dieser Vorgang wird wiederholt, bis das Element gefunden wurde. Dies funktioniert nur bei sortierten Arrays.

        // Lineare Suche
        for (int i = 0; i < dArray2.length; i++)
        {
            if (dArray2[i] == 2.2)
            {
                System.out.println("Position des Wertes: " + i);
                break;
            }
        }

        // Binäre Suche
        int position = Arrays.binarySearch(dArray2, 2.2);
        // Der Rückgabewert ist die Position des gesuchten Wertes, wenn dieser gefunden wurde.
        // Wurde der Wert aber nicht gefunden, wird die vermutete Position negativ minus 1 zurückgegeben.
        System.out.println("Position des Wertes: " + position);

        ausgabe(intArray5);
        fillArray(intArray5, 42); // Hier wird innerhalb der Methode jede Position des Arrays durch 42 überschrieben.
        ausgabe(intArray5); // Danach ist das Array auch hier in der Main mit den neuen Werten gefüllt.


        // Arrays kopieren:
        int[] intArray6 = Arrays.copyOf(intArray2, intArray2.length);
        System.out.println(Arrays.toString(intArray6));

    } // Hier ist die Main zu Ende

    // 'int...' steht für 'varargs' und ist eine andere Schreibweise für Arrays in Methodenparametern.
    // Es kann dabei aber nur ein Parameter 'varargs' sein und dieser muss auch als letztes aufgelistet werden.
    // Recherchieren Sie bitte 'varargs' in der FPA.
    static void ausgabe(int... array)
    {
        for (int feld : array)
            System.out.print(feld + " ");
        System.out.println();
    }

    // Arrays sind Referenztypen
    static void fillArray(int[] array, int zahl)
    {
        for (int i = 0; i < array.length; i++)
            array[i] = zahl;
    }


}
