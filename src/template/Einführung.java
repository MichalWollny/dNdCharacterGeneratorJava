//Die erste Zeile Programmcode muss die Deklaration des Paketes sein.
package template; // Alle Klassen in Java sind einem Paket zugeordnet. 
//Damit lassen sich Klassen gruppieren, in Kategorien einteilen.
// Pakete stellen die Ordnerstruktur dar, in der die Klassen liegen.

// Unser erstes Java-Programm - Hallo Welt!

// Jedes noch so kleine Java-Programm besteht aus einer Klasse die eine 
// Main-Methode beinhaltet.
public class Einführung // ← erste Klasse des Programmes. Sie beinhaltet die Main-Methode. 
//Die Klasse selbst kann beliebig heißen.
{
    public static void main(String[] args) // Die Main-Methode. 
	//Sie muss "public static void main(String[] args)" heißen
    {
        System.out.println("Hallo Welt!");
        // Konsolenausgabe mit println() - Methode, hier wird der String "Hallo Welt!" ausgegeben
        // "System" ist eine Klasse, so wie hier die Klasse "Einführung".
        // Die Klasse "System" beinhaltet eine Variable "out", 
		//welche ein Objekt der Klasse "PrintStream" ist.
        // Ein Objekt ist ein konkreter Gegenstand, eine Instanz einer Klasse.
        // Das Objekt "out" verfügt über die Methode (Funktion) "println".

        // Beispiel für Klassen und Objekte:
        // "Auto" ist eine Klasse. Jedes Auto hat Eigenschaften. 
		// Farbe, Kennzeichen, Pferdestärke, Hubraum, Tankfüllstand. Jedes Auto kann fahren.
        // Ihr Auto, welches vor dem Haus geparkt ist, ist eine Instanz der Klasse "Auto". 
		// Für die Eigenschaften sind konkrete Werte zugewiesen.
        // Das Fahrverhalten Ihres Autos könnte sich von dem des Nachbarn unterscheiden, 
		//abhängig von den Eigenschaften.

        // Anderes Beispiel:
        // "Burger" ist eine Klasse. Jeder Burger besteht aus Zutaten, 
		// hat eine Größe, ein Gewicht. Sie bereiten sich nun einen Burger zu. 
		// Dabei entsteht die konkrete Instanz der Klasse, ein Objekt. 
		//Die Zutaten, die Größe und das Gewicht Ihres Burgers sind jetzt bekannt.
        // Diese Informationen können sich aber zu anderen Burgern, also anderen Instanzen, 
		// unterscheiden. Manche Burger haben Zwiebeln, andere Gurken. 
		// Manche sind groß, andere sind klein.

        // Beispiel Datenbanken:
        // Die Tabelle "Person" ist die Klasse. Jeder Eintrag in der Tabelle ist ein Objekt.

        // Auf diesem Konzept basiert die objektorientierte Programmierung.
    }
}
// Die Main-Methode ist der Einstiegspunkt einer Anwendung.
// Wenn die Anwendung gestartet wird, ist die Main-Methode die erste Methode die aufgerufen wird.
// Jedes Programm besitzt nur einen Einstiegspunkt hier beginnt und endet die Programmsteuerung.

// Im Gegensatz zu C wird Java nicht direkt in Maschinencode umgewandelt, 
// sondern in einen Zwischencode (Bytecode).
// Die Java Virtual Machine (JVM) interpretiert den Code zur Laufzeit in Maschinencode 
// und führt den Code dann aus.
// Darum können Java Programme auf allen Geräten laufen, auf denen eine JVM installiert werden kann.
// Zur Anzeige des Bytecodes:
// https://www.jetbrains.com/help/idea/decompiler.html

// Unterschied JIT und Interpreter:
// https://stackoverflow.com/questions/3718024/jit-vs-interpreters