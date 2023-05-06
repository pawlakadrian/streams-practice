import main.java.models.Animal;
import main.java.models.Life;
import main.java.models.Plant;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Animals
        Animal wildBoar = new Animal("Wild Board", 4, false);
        Animal bison = new Animal("Bison", 4, false);
        Animal blackWidow = new Animal("Black Widow", 8, true);
        Animal viper= new Animal("Viper", 0, true);

        List<Animal> animalList = new ArrayList<>(){{
            add(wildBoar);
            add(bison);
            add(blackWidow);
            add(viper);
        }};

        //Plants
        Plant appleTree = new Plant("appleTree", 20, "apple");
        Plant pearTree = new Plant("pearTree", 20, "pear");

        List<Plant> plantList = new ArrayList<>(){{
            add(appleTree);
            add(pearTree);

        }};

        Life life1 = new Life("Poland", animalList, plantList);

        System.out.println(life1);
    }
}