import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {
    private static final String type = "water";
    private final List<String> attacks = Arrays.asList("surf", "hydropump", "Hydrocanon", "raindance");


//----- constructor ----------------------------------------------------------------------------------------------

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(type, name, level, hp, food, sound);
    }

//----- methodes ----------------------------------------------------------------------------------------------
    public void templateAttackMethod(Pokemon name, Pokemon enemy, String nameAttack, int hpMinInAttack) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + ", with " + nameAttack + ".");
        switch (enemy.getType()) {
            case "electric":
                factor = 3;
                break;
            case "fire":
                factor = 4;
                break;
            case "grass":
                factor = 2;
                break;
            case "water":
                factor = 1;
                break;
            default:
                factor = 1;
        }
        minHp = hpMinInAttack * factor;
        enemy.setHp(enemy.getHp() - (minHp));
        System.out.println(enemy.getName() + " loses " + minHp + " hp and has now " + enemy.getHp() + "hp.");
    }

    void surf(Pokemon name, Pokemon enemy) { // water
        int hpMinInAttack = 1;
        String nameAttack = "surf";
        templateAttackMethod(name, enemy, nameAttack, hpMinInAttack);
    }

    void hydroPump(Pokemon name, Pokemon enemy) {  // water
        int hpMinInAttack = 2;
        String nameAttack = "hydropump";
        templateAttackMethod(name, enemy, nameAttack, hpMinInAttack);
    }

    void hydroCanon(Pokemon name, Pokemon enemy) { // water
        int hpMinInAttack = 2;
        String nameAttack = "hydrocanon";
        templateAttackMethod(name, enemy, nameAttack, hpMinInAttack);
    }

    // raindance heeft extra functies
    void rainDance(Pokemon name, Pokemon enemy) {  // water
        int hpMinInAttack = 3;
        String nameAttack = "raindance";
        System.out.println(name.getName() + " valt " + enemy.getName() + " aan, met " + nameAttack + ".");
        switch (enemy.getType()) {
            // extra functie: rainDance` heeft geen effect op electric Pokemons maar geeft een `system.out.println` met de boodschap: "has no effect on (vijand)";
            case "electric":
                System.out.println(nameAttack + " has no effect on " + enemy.getName());
                factor = 0;
                break;
            case "fire":
                factor = 4;
                break;
            case "grass":
                //extra functie: rainDance` levert een hp boost aan vijanden grass-types;
                factor = 0;
                enemy.setHp(enemy.getHp() + 20);
                System.out.println(nameAttack + " gives a hp boost of 20 to grasstypes.");
                break;
            case "water":
                factor = 1;
                break;
            default:
                factor = 1;
        }
        minHp = hpMinInAttack * factor;
        enemy.setHp(enemy.getHp() - (minHp));
        System.out.println(enemy.getName() + " loses " + minHp + " hp and has now " + enemy.getHp() + "hp.");
    }


//----- gettersNsetters ---------------------------------------------------------------------------------------
    public List<String> getAttacks() {
        return attacks;
    }
}
