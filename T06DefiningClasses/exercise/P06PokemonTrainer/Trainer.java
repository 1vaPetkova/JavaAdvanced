package T06DefiningClasses.exercise.P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String trainerName;
    private int badges = 1;
    private List<Pokemon> pokemonList;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }


    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
