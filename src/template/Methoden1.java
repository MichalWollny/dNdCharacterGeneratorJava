package template;

/*
    In Java spielen Methoden eine zentrale Rolle. Sie bestimmen das Verhalten von Objekten und somit auch das Verhalten des gesamten Programms.
	Methoden arbeiten in Java in der Regel mit den Daten (Variablen) von Objekten. Das unterscheidet sie von Funktionen, die man in anderen Programmiersprachen vorfinden
	kann und welche vollkommen unabhängig von einem Objekt oder einer Klasse existieren.
 */

public class Methoden1
{
    // Optionale Modifier + void oder Datentyp der Rückgabe + Name der Methode + (Parameterliste) + { }
    static int addieren(int a, int b) // static = die Methode kann ohne Objektreferenz aufgerufen werden.
    {
        return a + b;
    }

    int multiplizieren(int a, int b) // nicht statisch = die Methode kann nur über eine Objektreferenz aufgerufen werden.
    {
        return a * b;
    }

    static void geschenkVerpackt(boolean gepackt)
    {
        if (gepackt)
            System.out.println("Das Geschenk ist verpackt.");
        else
        {
            System.out.println("Das Geschenk ist nicht verpackt.");
            return; // Jede Methode kann durch eine Return-Anweisung beendet werden, auch wenn die Methode nichts zurückgibt.
        }

        System.out.println("Die Verpackung sieht schön aus.");
    }


    // Methodenüberladung:
    // Die Methodenüberladung bedeutet, dass ich mehrere Methoden mit identischem Bezeichner habe, aber unterschiedlichen Parameterlisten.
    // Das heißt, die Typen und die Anzahl der Parameter sind unterschiedlich.
    static void ichMacheEtwas()
    {
        System.out.println("Ich gebe etwas aus.");
    }

    static void ichMacheEtwas(int zahl)
    {
        System.out.println("Ich gebe die Zahl " + zahl + " aus.");
    }

    static void ichMacheEtwas(int a, int b)
    {
        System.out.println("Ich addiere zwei Zahlen. Das Ergebnis ist " + (a + b));
    }

    static void ichMacheEtwas(String s)
    {
        System.out.println("Ich gebe " + s + " aus.");
    }


    public static void main(String[] args)
    {
        int ergebnis = addieren(12, 15); // In derselben Klasse kann ich andere statische Methoden einfach so aufrufen.
        System.out.println("Ergebnis der Addition: " + ergebnis);

        Methoden1 objektReferenz = new Methoden1(); // Wir erzeugen ein Objekt der Klasse. Den Vorgang nennen wir Instanziierung. Das Ergebnis ist eine Objektreferenz.
        ergebnis = objektReferenz.multiplizieren(4, 5); // In statischen Methoden kann ich nur mit Objektreferenzen auf nicht-statische Methoden zugreifen.
        System.out.println(ergebnis);

        geschenkVerpackt(false);

        // Mehrere Methoden tragen denselben Namen, empfangen aber verschiedene Argumente und sind in ihrem Verhalten unterschiedlich.
        ichMacheEtwas();
        ichMacheEtwas(42); // Je nach Übergabe wählt der Compiler die richtige Methodenüberladung aus.
        ichMacheEtwas(10, 32);
        ichMacheEtwas("Hallo Welt!");
    }
}
