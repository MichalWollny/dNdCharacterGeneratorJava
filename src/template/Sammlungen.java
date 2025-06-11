package template;

import java.util.*;

public class Sammlungen
{
    public static void main(String[] args)
    {
        System.out.println("LISTEN");
        // LISTEN : ArrayList, LinkedList, Vector, Stack
        // Listen (Interface List): geordnete Datenstrukturen, auf die man wie auf Arrays mit einem numerischen Index zugreifen kann.
        // Im Unterschied zu Arrays erlauben sie das Einfügen an einer beliebigen Stelle.
		/*
		 * Einige wichtige Methoden
		    size()
			add()
			remove()
			contains()
			Iterator iterator()
			get()
			set()
		 */

        // ARRAYLIST:
		/*
		 * ArrayList realisiert eine lineare Liste als dynamisches Array.
		   Wahlfreier Zugriff ist schneller als bei LinkedList, Einfügen und Löschen dagegen langsamer.
		   ArrayList ist besonders bei überwiegend lesendem Zugriff oder bei kleinen Listen vorzuziehen.
		   Funktion: Wenn ein Element hinzugefügt wird, wird es im Array platziert.
		   			 Wenn das Array nicht groß genug ist, wird ein neues, größeres Array erstellt, um das alte zu ersetzen.
		 */

        System.out.println("ARRAYLIST");
        ArrayList<String> autoListe = new ArrayList<String>(); // In den spitzen Klammern <> steht der Datentyp der Liste. Dies können alle komplexen Datentypen (Referenztypen) sein.
        autoListe.add("BMW");
        autoListe.add("Audi");
        autoListe.add("Ford");
        autoListe.add("Hyundai");

        // Abfragen der ganzen Liste der Autos:
        System.out.println(autoListe); // Anders als bei Arrays ist hier kein "Arrays.toString()" erforderlich.

        // Ausgabe eines Eintrags (Elementes) aus der Liste mit Angabe des Index. In diesem Beispiel Index 0 entspricht dem ersten Eintrag, also "BMW".
        System.out.println(autoListe.get(0));

        // Ausgabe der Anzahl der Einträge in der Liste:
        System.out.println("Größe der Liste: " + autoListe.size());

        // Ersetzen eines Eintrages mit der set()-Methode:
        autoListe.set(2, "Opel"); // Das Element am angegebenen Index wird durch das neue Element ersetzt.
        // set() gibt das alte Element an dem angegebenen Index zurück.
        System.out.println(autoListe);

        System.out.println("An Index 3 gelöscht: " + autoListe.remove(3)); // Löschen des Elementes am angegebenen Index.
        // remove() mit Index gibt das gelöschte Element zurück.

        System.out.println("Wurde BMW gelöscht? " + autoListe.remove("BMW")); // Löschen eines Elementes über Angabe des Objektes, welches gelöscht werden soll. Dabei wird das erste Vorkommen des Elementes gelöscht.
        // remove() mit Objekt gibt true zurück, wenn das Objekt in der Liste war und sonst false.

        System.out.println(autoListe);

        System.out.println("Eintrag an Index 0: " + autoListe.get(0)); // Nachdem MBW gelöscht wurde, sind alle weiteren Einträge aufgerückt. Damit steht an Index 0 nun "Audi".
        //System.out.println(autoListe.get(3)); // das Element an Index 3 haben wir gelöscht. Da dies der letzte Index war, ist dieser nun nicht mehr verfügbar und es wird eine IndexOutOfBoundsException geworfen.

        // indexOf() gibt den Index eines übergebenen Objektes zurück, oder -1, wenn es das Objekt nicht gibt.
        System.out.println("'Opel' befindet sich am Index: " + autoListe.indexOf("Opel"));

        // contains() prüft, ob ein übergebenes Objekt in der Liste ist.
        boolean vorhanden = autoListe.contains("Audi");
        System.out.println("Gibt es 'Audi' in der Liste? " + vorhanden);

        System.out.println();
        // Wichtig: Collections können nur Objekte aufnehmen.
        // Um eine Liste von Integer erstellen zu können, müssen Wrapperklassen verwendet werden. Zu jedem primitiven Datentyp gibt es eine Wrapperklasse.
        //ArrayList<int> intListe = new ArrayList<int>(); // Geht nicht!
        ArrayList<Integer> intListe = new ArrayList<>();
        intListe.add(15); // Die add()-Methode nimmt Objekte vom Typ Integer. Hierbei wird der primitive Typ automatisch von der Wrapperklasse umhüllt.
        // Lokale Variablen von primitiven Typen liegen auf dem Stack (ein Teil unseres Arbeitsspeichers). Objekte liegen auf dem Heap. Wird aus dem primitiven Typ ein Objekt gemacht (wie hier durch das wrapping), wird auch von "boxing" gesprochen.
        // https://lerneprogrammieren.com/stack-und-heap/
        intListe.add(Integer.valueOf(42)); // Hier ist der Befehl vollständig ausgeschrieben. Da das Boxing automatisch stattfindet, können wir das "Integer.valueOf()" auch weglassen.
        Integer I = 100; // automatisches Boxing.
        intListe.add(I);
        System.out.println(intListe);

        // intListe über for-Schleife befüllen:
        for (int i = 0; i < 5; i++)
            intListe.add(i); // automatisches Boxing.

        // ACHTUNG! Die remove()-Methode hat 2 Varianten. Eine mit int index, eine mit Object o. Gibe ich nur einen int-Wert an, wird dieser als Index genommen!
        intListe.remove(0); // Entfernt das Element an Index 0!
        intListe.remove((Integer)0); // Entfernt das erste Vorkommen des Wertes 0! Hier muss ein Cast in Integer erfolgen, oder Integer.valueOf() verwendet werden.
        //intListe.remove(intListe.indexOf(0)); // Alternative zum Entfernen der 0. Liefert aber eine Exception, wenn indexOf() -1 zurückgibt.
        System.out.println(intListe);
        System.out.println();

        // 	***********************************************************************************************************************
        System.out.println("COLLECTIONS-KLASSE");

        // Sortieren:
        Collections.sort(intListe);
        System.out.println(intListe);

        // Mischen:
        Collections.shuffle(intListe);
        System.out.println(intListe);

        /*
            Weitere wichtige Methoden:
            addAll();
            binarySearch();
            swap();
         */

        // Beispiel für addAll():
        Collections.addAll(intListe, 40, 42, 43, 44, 50, 53, 57);
        System.out.println();

        // 	***********************************************************************************************************************
        System.out.println("MENGEN");
        // MENGEN: HashSet, TreeSet
        // Mengen (abstrakte Klasse Set): Eine Implementierung mathematischer Mengen. Objekte können nur einmal in einer Menge vorkommen.
        // Man kann prüfen, ob bestimmte Objekte in einer Menge enthalten sind. Eine Reihenfolge oder Ordnung in der Menge ist nicht relevant.
		/*
		 * Einige wichtige Methoden:
		  	size()
			add()
			remove()
			contains()
			Iterator iterator()
		 */

        // HASHSET:
		/*
		  HashSet realisiert eine ungeordnete Menge von Elementen.
		  Ein HashSet ist eine Sammlung von Elementen, bei denen jedes Element einzigartig ist.
		 */

        System.out.println("HASHSET");
        HashSet<String> autoSet = new HashSet<>();
        autoSet.add("BMW");
        autoSet.add("Audi");
        autoSet.add("Ford");
        autoSet.add("BMW");
        System.out.println(autoSet.add("Hyundai")); // Die add()-Methode gibt true zurück, wenn das Element hinzugefügt werden konnte...
        System.out.println(autoSet.add("Hyundai")); // und false, wenn es nicht hinzugefügt werden konnte, weil es schon in der Liste ist.

        System.out.println(autoSet); // Jedes Element im Set ist einzigartig. Beim Hinzufügen eines Elementes wird geprüft, ob es bereits in der Liste ist und nur wenn nicht, wird es hinzugefügt. Außerdem sehen wir hier, dass die Reihenfolge eine andere ist als die, in der wir die Elemente hinzugefügt haben.

        System.out.println(autoSet.size());

        System.out.println(autoSet.contains("Mazda")); // Auch wie bei Listen können wir mit contains() nach Elementen in der Menge suchen.
        autoSet.remove("Ford"); // Mit remove() ein Element entfernen. Aber hier können wir nicht über den index entfernen, sondern nur über das Objekt selbst.
        System.out.println(autoSet);
        System.out.println();

        // ***********************************************************************************************************************
        System.out.println("VERZEICHNISSE");
        // VERZEICHNISSE: HashMap, TreeMap
        /*
           Map repräsentiert eine Menge von Objekt-Paaren, wobei jeweils ein Objekt den Schlüssel zum Zugriff auf das dazugehörige andere Objekt darstellt.
         */
        // Wichtige Methoden HashMap :
        /*
          	size()
            get()
            put()
            containsKey()
            containsValue()
            Set keySet()
            Collection values()
            Set entrySet()
         */

        // HASHMAP:
        /*
           Bei ArrayList haben Sie gelernt, dass Elemente als geordnete Sammlung gespeichert werden und Sie mit einer Indexnummer (int) darauf zugreifen können.
           Bei einer HashMap jedoch speichern Sie Elemente als "Schlüssel-Wert"-Paare (Key-Value-Paare), und Sie können sie durch einen Index eines anderen Typs (zB. String) abfragen.
         */
        System.out.println("HASHMAP");
        HashMap<String, Integer> zahlen = new HashMap<>(); // String ist Key, Integer ist Value.
        zahlen.put("Eins", 1);
        zahlen.put("Zwei", 2);
        zahlen.put("Drei", 3);
        zahlen.put("Zweiundvierzig", 42);
        Integer alterWert = zahlen.put("Drei", 300); // put() fügt ein Key-Value-Paar hinzu, wenn es den Key noch nicht gibt. Gibt es den Key schon, wird der Value durch den neuen ersetzt.
        System.out.println(alterWert);

        System.out.println(zahlen.size());
        System.out.println(zahlen);
        System.out.println(zahlen.get("Drei")); // Gibt den Value passend zum übergebenen Key zurück.
        System.out.println(zahlen.containsKey("Eins")); // Prüft, ob der übergebene Key existiert.
        System.out.println(zahlen.containsValue(42)); // Prüft, ob der übergebene Value existiert.

        HashMap<Integer, String> kunden = new HashMap<>(); // Integer ist Key, String ist Value.
        kunden.put(1, "Mein erster Kunde");
        kunden.put(50, "Kunde mit der ID 50");
        kunden.put(2, "Noch ein Kunde");
        System.out.println(kunden);

        Collection<String> values = kunden.values(); // Abfragen der Values über values().
        System.out.println(values);

        Set<Integer> keys = kunden.keySet(); // Abfragen der Keys über keySet().
        System.out.println(keys);



    }
}
