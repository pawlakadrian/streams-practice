import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Animals
        Animal wildBoar = new Animal("Wild Board", 4, false);
        Animal bison = new Animal("Bison", 4, false);
        Animal blackWidow = new Animal("Black Widow", 8, true);
        Animal viper = new Animal("Viper", 0, true);
        Animal scorpion = new Animal("Scorpion", 8, true);
        Animal fish = new Animal("Fish", 0, false);
        Animal delphin = new Animal("Delphin", 0, false);

        List<Animal> euAnimals = List.of(wildBoar, bison, viper);
        List<Animal> afAnimals = List.of(wildBoar, blackWidow, viper, scorpion);
        List<Animal> asAnimals = List.of(wildBoar, blackWidow, viper, scorpion);
        List<Animal> waterAnimals = List.of(fish, delphin);

        //Plants
        Plant appleTree = new Plant("appleTree", 4.5, "apple");
        Plant pearTree = new Plant("pearTree", 3.5, "pear");
        Plant bambooTree = new Plant("bambooTree", 5.5, "bambooFruit");
        Plant algae = new Plant("algae", 0.5, "algae");

        List<Plant> euPlants = List.of(appleTree, pearTree);
        List<Plant> afPlants = List.of(appleTree, pearTree);
        List<Plant> asPlants = List.of(appleTree, pearTree, bambooTree);
        List<Plant> waterPlants = List.of(algae, bambooTree, pearTree);

        Life life = new Life("Poland", euAnimals, euPlants);
        Life life1 = new Life("Germany", euAnimals, euPlants);
        Life life2 = new Life("RPA", afAnimals, afPlants);
        Life life3 = new Life("Tokio", asAnimals, asPlants);
        Life life4 = new Life("Sea", waterAnimals, waterPlants);

//      3. Znaleźć pierwszy element na liście, który spełnia warunek: „zawiera kraj o nazwie zaczynającej
//        się na literę ‘s’”, zmapować ten element do
//        Listy roślin i Posortować rośliny malejąco po wartości standardHigh
        List<Life> lifeList = Arrays.asList(life, life1, life2, life3, life4);

        Comparator<Plant> byStandardHigh = Comparator.comparing(
                Plant::getStandardHigh
        );

        List<List<Plant>> getListOfPlants = lifeList.stream()
                .filter(a -> a.getCountry().startsWith("S"))
                .map(Life::getPlants)
                .collect(Collectors.toList());

        List<Plant> getSortedListOfPlants = getListOfPlants.stream()
                .flatMap(List::stream)
                .sorted(byStandardHigh.reversed())
                .collect(Collectors.toList());

        System.out.println("List of sorted plants by high: " + getSortedListOfPlants);

//      5. Wyciągnąć do listy wszystkie kraje i posortować je rosnąco po nazwie
        List<String> listOfCountries = lifeList.stream()
                .map(Life::getCountry)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted list of countries: " + listOfCountries);

//      7. Wyciągnąć z listy wszystkie kraje, w których występuje choć jeden gatunek jadowitego zwierzęcia (rezultatem powinna być tylko lista krajów)
        List<String> listOfCountriesWithVenomousAnimals = lifeList.stream()
                .filter(a -> a.getAnimals().stream().anyMatch(Animal::isVenomous))
                .map(Life::getCountry)
                .collect(Collectors.toList());

        System.out.println("List of countries with venomous animals: " + listOfCountriesWithVenomousAnimals);
    }
}