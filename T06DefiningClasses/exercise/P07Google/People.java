package T06DefiningClasses.exercise.P07Google;

import java.util.ArrayList;
import java.util.List;

public class People {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parentsList;
    private List<Child> childrenList;
    private List<Pokemon> pokemonsList;


    public People(String name,Company company, Car car) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParentsList() {
        return parentsList;
    }

    public List<Child> getChildrenList() {
        return childrenList;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(getName()).append("\n");
        output.append("Company:\n");
        if (getCompany() != null) {
            output.append(getCompany()).append("\n");
        }
        output.append("Car:\n");
        if (getCar()!= null) {
            output.append(getCar().toString()).append("\n");
        }
        output.append("Pokemon:\n");
        if (getPokemonsList()!=null) {
            for (Pokemon pokemon : getPokemonsList()) {
                output.append(pokemon.toString()).append("\n");

            }
        }
        output.append("Parents:\n");
        if (getParentsList()!=null) {
            for (Parent parent : getParentsList()) {
                output.append(parent.toString()).append("\n");
            }
        }
        output.append("Children:\n");
        if (getChildrenList()!=null) {
            for (Child child : getChildrenList()) {
                output.append(child.toString()).append("\n");
            }
        }
        return output.toString();
    }
}
