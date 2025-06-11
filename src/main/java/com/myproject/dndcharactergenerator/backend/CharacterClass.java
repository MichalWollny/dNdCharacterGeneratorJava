package main.java.com.myproject.dndcharactergenerator.backend;

public class CharacterClass {
    enum AvailableClasses {
        BARBARIAN("A class known for its raw strength and resilience."),
        BARD("A versatile class that combines magic with music and art."),
        CLERIC("A divine spellcasting class often acting as a healer."),
        DRUID("A nature-connected class capable of transforming into animals."),
        FIGHTER("A class specialized in combat, offering versatile fighting options."),
        MONK("A class that relies on agility and inner energy (Ki)."),
        PALADIN("A class that combines holy magic with melee combat."),
        RANGER("A class specialized in ranged combat and wilderness survival."),
        ROGUE("A class that focuses on stealth and dexterity."),
        SORCERER("An innate spellcasting class drawing magic from their bloodline."),
        WARLOCK("A class that gains magical abilities through a pact with a powerful entity."),
        WIZARD("A scholarly class that learns magic through study and knowledge."),
        ARTIFICER("A class that combines magic and craftsmanship to create magical items.");

        private final String description;

        AvailableClasses(String description){
            this.description = description;
        }

        public String getClassDescription(String description){
            return description;
        };
    }
}
