package template;

/*
    Einstieg in die Objekt-Orientierte-Programmierung (OOP):

    Objektorientierte Programmierung wird gerne als Philosophie bezeichnet.
    Die OOP beschreibt, wie wir Programme aufbauen, bzw. strukturieren.
    Die OOP ist also vor allem ein "Ordnungsprinzip"

    Die Literatur (bzw. gerne auch IHK-Prüfer) spricht von (bzw. fragt nach) den sogenannten "Säulen der OOP":
    - Die erste Säule ist die "Abkapselung" (oder auch "Kapselung", Englisch: Encapsulation).
      Damit ist eine Form der Modularisierung gemeint. Wir kapseln Klassen und Objekte voneinander ab, um sie möglichst unabhängig voneinander zu machen.
      Kapselung beschreibt auch das Verhindern von Zugriff auf Teile des Codes durch andere Teile. Attribute werden privat und den Zugriff darauf regeln Methoden.
    - Die Vererbung ist die zweite Säule (Englisch: Inheritance).
      Dadurch können Klassen generalisiert oder spezialisiert werden. Eine neue Klasse erbt von einer alten → Code kann übernommen und wiederverwendet werden.
    - Die dritte Säule ist die Polymorphie ("Vielgestaltigkeit", Englisch: Polymorphism)
      Methoden mit demselben Namen können (situationsbedingt) unterschiedliches leisten.
      Beispiel: Die Sort-Methode kann auf Integer, Strings und Character angewendet werden.
    - Häufig wird auch noch eine vierte Säule genannt, die Abstraktion (Englisch: Abstraction).
      Abstraktion (Englisch: Abstraction) bezeichnet das Verstecken der Implementierung, aber auch das Finden von Gemeinsamkeiten im Code, um daraus allgemeine Funktionen zu beschreiben. Dies erlaubt es Entwicklern mit Objekten basierend auf ihrem beabsichtigten Verhalten zu interagieren, ohne die genauen Details über die Umsetzung dieses Verhaltens zu kennen. Der Fokus liegt auf dem, was ein Objekt tut anstatt darauf, wie es etwas tut.

*/


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

// Klassen haben den "default"-Zugriff, wenn kein anderer Modifizierer angegeben ist.
// "default" bedeutet, dass von überall aus im selben Package auf die Klasse zugegriffen werden kann, aber nicht aus anderen Packages heraus.
// Dies wird interessant, wenn komplexe Programme in unterschiedlichen Paketen aufgeteilt sind.
// https://www.geeksforgeeks.org/access-modifiers-java/
// In Java darf jede Datei nur eine einzige öffentliche ("public") Klasse beinhalten.
class Person
{
    // Der Begriff "Member":
    // Als "Member" bezeichnen wir alle Attribute, Felder, Methoden, Funktionen einer Klasse.

    // Statische Member haben wir bereits zu Beginn kennengelernt, ohne stärker darauf einzugehen.
    // Sie können ohne Objektverweis aufgerufen werden. Hier als Beispiel: Eine statische Liste vom Typ Person.
    // Statische Member sind objektübergreifend, also für alle Objekte (Instanzen) einer Klasse gültig.
    // Bedeutet: Jedes Objekt dieser Klasse verwendet dieselbe Liste, während nicht-statische Member bei jedem Objekt unterschiedlich sind.
    public static ArrayList<Person> personen = new ArrayList<>(); // public: Auf diesen Member kann von überall aus zugegriffen werden.

    // Nicht-statische Member werden auch als Instanz-Member bezeichnet, da eine Instanz benötigt wird, um sie zu verwenden.
    // Abkapselung: Attribute sind nach Außen versteckt und nur über entsprechende Methoden zugänglich. (Geheimnisprinzip)
    // Dazu machen wir die Attribute "private".
    // Auf private Member kann nur in der Klasse zugegriffen werden, in der sie deklariert wurden.
    private int id;
    private String name;
    private LocalDate geburtsdatum; // LocalDate ist ein Datentyp, mit dem wir Datumsangaben speichern können.

    // Damit andere Klassen auf die Attribute dieser Klasse zugreifen können, stellen wir öffentliche Methoden bereit.
    // Diese Methoden werden allgemein als Getter und Setter bezeichnet und steuern den Zugriff auf die Attribute.
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id; // "this" bezieht sich auf das Objekt der Klasse. Damit machen wir deutlich, dass hier mit "this.id" das Attribut "id" der Klasse gemeint ist, und nicht der Methodenparameter.
    }

    // Bemerkungen zur Get-Methode:
    // 1) Sie sollte public sein, damit wir sie von Außen verwenden können.
    // 2) Sie müssen einen Rückgabewert liefern, dessen Typ in der Regel dem des privaten Attributes entspricht (hier also String)
    public String getName()
    {
        return name;
    }

    // Bemerkungen zur Set-Methode:
    // 1) Sie benötigen einen Übergabewert (Parameter), der mitteilt, was zugewiesen werden soll. Der Typ entspricht normalerweise dem des privaten Attributes.
    // 2) Sie benötigen keinen Rückgabewert, denn mit der Setzung haben sie ihren Job erledigt.
    // 3) Auch sie sollten public sein, wobei es Situationen gibt, in denen das nicht der Fall ist.
    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getGeburtsdatum()
    {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum)
    {
        this.geburtsdatum = geburtsdatum;
    }

    // Das Alter speichern wir nicht direkt als Attribut, sondern lassen es durch eine entsprechende Getter-Methode berechnen.
    public int getAlter()
    {
        //return (int)ChronoUnit.YEARS.between(geburtsdatum, LocalDate.now());

        // Alternative:
        return Period.between(geburtsdatum, LocalDate.now()).getYears();
    }

    // Zur Bezeichnung der Getter bei Boolean:
    public boolean isVolljährig() // "is" anstatt "get"
    {
        return getAlter() >= 18; // Wir können auch andere Methoden aufrufen, um das Ergebnis zu bestimmen.
    }

    public void ausgabe() // Diese Methode benötigt keine Übergabewerte, denn sie arbeitet mit Attributen, die dem Objekt schon bekannt sind.
    {
        System.out.printf("ID: %d, Name: %s, Geburtsdatum: %s, Alter: %d, Volljährig: %s %n", id, name, geburtsdatum, getAlter(), isVolljährig());
    }

}

public class Klassen
{
    public static void main(String[] args)
    {
        // Deklaration einer Variable:
        Person p1;

        // Instanziierung (Instanz = Objekt) -> Es wird ein Objekt erschaffen.
        p1 = new Person(); // Hier wird der sogenannte "Standardkonstruktor" aufgerufen - zu Konstruktoren später mehr.

        // Zuweisen von Werten an die Attribute des Objektes p1 über die Setter-Methoden:
        p1.setId(1);
        p1.setName("Astrid");
        p1.setGeburtsdatum(LocalDate.of(1990,4,12));

        // Abrufen der Attribute des Objektes über die Getter-Methoden:
        System.out.println(p1.getId());
        System.out.println(p1.getName());
        System.out.println(p1.getGeburtsdatum());
        System.out.println(p1.getAlter());
        System.out.println(p1.isVolljährig());

        //p1.id = 1; // Direkter Zugriff auf das Attribut ist nicht möglich, da das Attribut "private" ist.

        // Jedes Objekt hat eigene Kopien der Instanz-Attribute.
        Person p2 = new Person();
        p2.setId(2);
        p2.setName("Olaf");
        p2.setGeburtsdatum(LocalDate.of(1985,7,24));
        System.out.println(p2.getId());
        System.out.println(p2.getName());
        System.out.println(p2.getGeburtsdatum());
        System.out.println(p2.getAlter());
        System.out.println(p2.isVolljährig());

        // Beide Personen der statischen Liste hinzufügen:
        Person.personen.add(p1); // Auf statische Member (wie hier die Liste) wird über den Klassennamen, NICHT über das Objekt, zugegriffen!
        Person.personen.add(p2);
        // Bei 'Person' handelt es sich um eine Klasse, also einen Referenz-Typ. Bedeutet, dass in der Liste nun die Referenzen auf die Objekte gespeichert sind, nicht die Objekte selbst als Kopie.

        // ID des Objektes p1 ändern.
        p1.setId(42); // In der Ausgabe über die Liste werden wir sehen, dass auch dort die ID geändert ist. In der Liste befindet sich nur die Referenz auf das Objekt und damit zeigen p1 und das Element der Liste auf dasselbe Objekt. (Stichwort Pointer)
        System.out.println();
        System.out.println("Ausgabe aller Personen der statischen Liste:");
        for (Person p : Person.personen)
            p.ausgabe();

    }
}
