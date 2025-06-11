package template;

import java.util.Arrays;

public class ArraysMehrdimensional
{
    public static void main(String[] args)
    {
        // Einstieg am Bekannten: Ein 1-dimensionales Array
        // Beispiel: Schulnoten in diesem Jahr (wir behaupten, es gab 4 Prüfungen)
        int[] schulnoten2018 = new int[] { 4, 3, 2, 1 };
        // Beispielausgabe
        System.out.println("Die 3. Note im Jahr 2018 war: " + schulnoten2018[2]);
        // 3. Schulnote -> Index 2, denn unsere Aufzählung beginnt bei 0

        // Übergang zur 2-Dimensionalität:
        // Wir wollen weiterhin die Noten pro Jahr zählen (1. Dimension)
        // ... nun aber auch die Jahre (2. Dimension)
        // (In diesem Beispiel interessieren wir uns für die letzten 3 Jahre und behaupten weiterhin: Pro Jahr 4 Prüfungen)
        int[][] schulKariere = new int[][]
            {
                { 3, 4, 5, 6 }, // 4 Noten im Jahr 1 (Index 0)
                { 2, 1, 5, 4 }, // 4 Noten im Jahr 2 (Index 1)
                { 4, 3, 2, 1 }  // 4 Noten im Jahr 3 (Index 2)
            };
        // Beispielausgabe:
        System.out.println("2. Note im Jahr 1 war: " + schulKariere[0][1]); // Antwort: 4

        // Hinweis: Die Zählung der Dimension wird oft auch umgedreht. Zum Beispiel bei int[3][4] könnte man auch sagen,
        // dass die 3 die 1. Dimension ist und die 4 die zweite Dimension. Da wir hier aber die eigentlichen Daten zur 4 speichern, nehmen wir das als unsere 1. Dimension.
        // Was wir jetzt tatsächlich als 1. Dimension bezeichnen, was als 2. Dimension, etc., liegt ganz allein an der Betrachtungsweise des Arrays.

        // Hinweis: Bei der Erstellung des obigen Arrays haben wir für die erste Dimension auf das 'new int[]' verzichtet. Wir könnten sogar auf das 'new int[][]' verzichten, wenn wir wollen.

        // Übergang zur 3-Dimensionalität:
        // Wir werden weiterhin die Noten pro Jahr zählen (1. Dimension)
        // Ebenfalls wollen wir die Jahre zählen (2. Dimension)
        // Wollen nun aber auch unterschiedliche Schüler*innen zählen (3. Dimension)
        // Beispiel: 2 Schüler, von beiden 3 Jahre, jeder schrieb jedes Jahr 4 Prüfungen.
        int[][][] schulStatistik = new int[][][]
        {
            {
                { 3, 4, 5, 6 }, // Schüler 1 (Index 0), Jahr 1 (Index 0), Noten 1 bis 4 (Index 0 bis 3)
                { 2, 1, 5, 4 }, // Schüler 1 (Index 0), Jahr 2 (Index 1), Noten 1 bis 4 (Index 0 bis 3)
                { 4, 3, 2, 1 }  // Schüler 1 (Index 0), Jahr 3 (Index 2), Noten 1 bis 4 (Index 0 bis 3)
            },
            {
                { 2, 1, 2, 5 }, // Schüler 2 (Index 1), Jahr 1 (Index 0), Noten 1 bis 4 (Index 0 bis 3)
                { 4, 1, 3, 4 }, // Schüler 2 (Index 1), Jahr 2 (Index 1), Noten 1 bis 4 (Index 0 bis 3)
                { 6, 3, 6, 5 }  // Schüler 2 (Index 1), Jahr 3 (Index 2), Noten 1 bis 4 (Index 0 bis 3)
            }
        };
        // Beispielausgabe:
        System.out.println("Schüler 1 / Jahr 3 / Prüfung 4: " + schulStatistik[0][2][3]); // Antwort: 1
        // Zu beachten ist, dass Arrays immer mit 0 beginnen, Schüler 1 ist also Stelle 0 im Array

        // Über toString() erhalte ich bei mehrdimensionalen Arrays den Hashcode.
        System.out.println(Arrays.toString(schulStatistik));
        // Ich muss die ersten beiden Dimensionen (damit meine ich hier in diesem Beispiel die 3. und 2. Dimension) angeben und erhalte dann die Werte.
        System.out.println(Arrays.toString(schulStatistik[0][0]));
        // Oder über deppToString() alle Werte im Array
        System.out.println(Arrays.deepToString(schulStatistik));

        // Length bei mehrdimensionalen Arrays
        System.out.println("Length bei Array Schulstatistik:");
        System.out.println(schulStatistik.length); // -> 2
        System.out.println(schulStatistik[0].length); // -> 3
        System.out.println(schulStatistik[0][0].length); // -> 4

        System.out.println();
        // Ausgabe eines 3-Dimensionalen Arrays mit for-Schleife
        System.out.println("Ausgabe Schulstatistik:");
        for (int schüler = 0; schüler < schulStatistik.length; schüler++)
        {
            System.out.println("Für Schüler*in " + (schüler + 1));
            for (int jahr = 0; jahr < schulStatistik[schüler].length; jahr++)
            {
                System.out.println("Für das Jahr " + (jahr + 1));
                for (int note = 0; note < schulStatistik[schüler][jahr].length; note++)
                {
                    System.out.print(schulStatistik[schüler][jahr][note] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }


        // Mehrdimensionale Arrays mit nachträglicher Initialisierung:
        // 2-dimensionales Beispiel:
        // 3 Klassen: Klasse 1 hat 20 Schüler, Klasse 2 hat 15 Schüler, Klasse 3 hat 25 Schüler
        // (für jeden Schüler soll der Name gespeichert werden)
        String[][] schülerArray = new String[3][];
        // Der zweite Eintrag fehlt, denn wir wissen zwar, wie viele Klassen wir haben (3), aber die Anzahl der Schüler pro Klasse ist unterschiedlich.
        // Das Erzeugen des Arrays ist noch nicht vollständig abgeschlossen, denn wir müssen noch die einzelnen Klassen erzeugen:

        // Klasse 1
        schülerArray[0] = new String[20];
        // Klasse 2
        schülerArray[1] = new String[15];
        // Klasse 3
        schülerArray[2] = new String[25];

        // Füllen des schülerArrays mithilfe verschachtelter Schleifen:
        // Die äußere Schleife zählt die Klassen, die innere Schleife zählt die Schüler.
        for (int klasse = 0; klasse < schülerArray.length; klasse++)
        {
            for (int schüler = 0; schüler < schülerArray[klasse].length; schüler++)
            {
                schülerArray[klasse][schüler] = "unbekannt " + klasse + schüler;
            }
        }

        // Schnelle Ausgabe:
        System.out.println(Arrays.deepToString(schülerArray));

        // 3-dimensionales Beispiel:
        // 2 Schulen, mit jeweils mehreren Klassen und in jeder Klasse mehrere Schüler
        // Schule 1
        //  Klasse 1: 10 Schüler
        //  Klasse 2: 20 Schüler
        //  Klasse 3: 12 Schüler
        // Schule 2
        //  Klasse 1: 11 Schüler
        //  Klasse 2: 21 Schüler
        //  Klasse 3: 13 Schüler
        //  Klasse 4: 23 Schüler
        // Auch in diesem Array sollen die Schülernamen abgespeichert werden.

        // Alle Arrays können nacheinander über die Index-Angabe instanziiert werden, oder in einem Schritt:
        String[][][] schulenArray = new String[][][] // Wenn wir alle Arrays direkt instanziieren, wird die Größenangabe weggelassen.
        {
            // zwei Schulen
            new String[][] // Schule 1 - 3 Klassen
                {
                    new String[10], // Schule 1 - Klasse 1 - 10 Schüler
                    new String[20], // Schule 1 - Klasse 2 - 20 Schüler
                    new String[12]  // Schule 1 - Klasse 3 - 12 Schüler
                },
            new String[][] // Schule 2 - 4 Klassen
                {
                    new String[11], // Schule 2 - Klasse 1 - 11 Schüler
                    new String[21], // Schule 2 - Klasse 2 - 21 Schüler
                    new String[13], // Schule 2 - Klasse 3 - 13 Schüler
                    new String[23]  // Schule 2 - Klasse 4 - 23 Schüler
                }
        };

        // Wir könnten hier auf 'new String[][][]' und 'new String[][]' verzichten, wie wir es oben beim int-Array gemacht haben.
        // Ein Instanziieren über eine Schleife ist natürlich auch möglich.

        // Beispiel für die schrittweise Instanziierung:
        String[][][] schulenArray2 = new String[2][][]; // Die Größenangabe hier steht für die Anzahl der Schulen.

        // Schule 1 hat 3 Klassen:
        schulenArray2[0] = new String[3][]; // Die Größenangabe hier steht für die Anzahl der Klassen der Schule 1.

        // Schule 1, Klasse 1, hat 10 Schüler:
        schulenArray2[0][0] = new String[10]; // Die Größenangabe hier steht für Anzahl der Schüler der Klasse 1 in Schule 1.

        // ... und so müssen alle Stellen im Array erzeugt werden, bevor sie mit Werten gefüllt werden können.
        // Dies lässt sich am besten per Schleife lösen.

        // Füllen von schulenArray (da "schulenArray2" unvollständig erzeugt ist, nehmen wir hier wieder das erste "schulenArray")
        for (int schule = 0; schule < schulenArray.length; schule++)
            for (int klasse = 0; klasse < schulenArray[schule].length; klasse++)
                for (int schüler = 0; schüler < schulenArray[schule][klasse].length; schüler++)
                    schulenArray[schule][klasse][schüler] = String.format("Schüler*in %s %s %s", schule +1, klasse +1, schüler +1);

        // Ausgabe aller Einträge mit foreach
        for (String[][] schule : schulenArray) // Für jedes zwei-dimensionale Array 'schule' in dem drei-dimensionalen 'schulenArray'
        {
            for (String[] klasse : schule) // Für jedes ein-dimensionale Array 'klasse' in dem zwei-dimensionalen Array 'schule'
            {
                for (String schüler : klasse) // Für jeden Schüler in dem ein-dimensionalen Array 'klasse'
                {
                    System.out.println(schüler);
                }
            }
        }

        // Beispiel für das Auslesen eines konkreten Schülernamens (z.B. Schule 1, Klasse 3, Schüler*in 8)
        System.out.println("In der Schule 1, Klasse 3, heißt die Person 8: " + schulenArray[0][2][7]);

    }
}
