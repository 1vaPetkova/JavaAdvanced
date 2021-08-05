package T06DefiningClasses.exercise.P06PokemonTrainer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        List<Pokemon> pokemonList = new ArrayList<>();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("Tournament")) {
            //<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName);
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemonList().add(pokemon);
        }

        String element = "";
        Consumer<Trainer> increaseBadges = b -> b.setBadges(b.getBadges() + 1);
        Consumer<Trainer> decreaseHealth = h -> h.getPokemonList().
                forEach(p -> p.setHealth(p.getHealth() - 10));
        while (!(element = scan.nextLine()).equals("End")) {
            String finalElement = element;
            Predicate<Pokemon> pokemonHasElement = p -> p.getElement().equals(finalElement);
            Function<Trainer, List<Pokemon>> trainerHasPokemon = t ->
                    t.getPokemonList().stream().filter(pokemonHasElement).collect(Collectors.toList());
            for (Map.Entry<String, Trainer> tr : trainers.entrySet()) {
                if (!trainerHasPokemon.apply(tr.getValue()).isEmpty()) {
                    increaseBadges.accept(tr.getValue());
                } else {
                    decreaseHealth.accept(tr.getValue());
                    tr.getValue().setPokemonList(tr.getValue().getPokemonList()
                            .stream().filter(h -> h.getHealth() > 0)
                            .collect(Collectors.toList()));
                }
            }
        }
        trainers.entrySet().stream().sorted(Map.Entry.<String, Trainer>
                comparingByValue(Comparator.comparing(Trainer::getBadges)).reversed()).
                forEach(e -> System.out.println(e.getKey() + " "
                        + e.getValue().getBadges() + " "
                        + e.getValue().getPokemonList().size()));
    }
}
