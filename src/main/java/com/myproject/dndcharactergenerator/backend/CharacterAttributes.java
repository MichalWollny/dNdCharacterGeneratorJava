package main.java.com.myproject.dndcharactergenerator.backend;

public class CharacterAttributes {

        int STR;
        int DEX;
        int CON;
        int INT;
        int WIS;
        int CHA;

    CharacterAttributes(int STR, int DEX, int CON, int INT, int WIS, int CHA){
            this.STR = STR;
            this.DEX = DEX;
            this.CON = CON;
            this.INT = INT;
            this.WIS = WIS;
            this.CHA = CHA;
        }

        void displayCharacterAttributes(){
            System.out.println("STR = " + STR);
            System.out.println("DEX = " + DEX);
            System.out.println("CON = " + CON);
            System.out.println("INT = " + INT);
            System.out.println("WIS = " + WIS);
            System.out.println("CHAR = " + CHA);
        }

}
