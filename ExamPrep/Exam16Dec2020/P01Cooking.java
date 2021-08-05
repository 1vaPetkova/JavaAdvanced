package ExamPrep.Exam16Dec2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);
        Map<Integer, String> foodValues = new TreeMap<>();
        foodValues.put(25, "Bread");
        foodValues.put(50, "Cake");
        foodValues.put(75, "Pastry");
        foodValues.put(100, "Fruit Pie");

        Map<String, Integer> foods = new TreeMap<>();
        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Pastry", 0);
        foods.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();
            if (foodValues.entrySet().stream().anyMatch(e -> e.getKey() == sum)) {
                String foodCooked = foodValues.get(sum);
                foods.put(foodCooked, foods.get(foodCooked) + 1);
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int ingredientNewValue = ingredients.pop() + 3;
                ingredients.push(ingredientNewValue);
            }
        }
            if (foods.entrySet().stream().allMatch(f -> f.getValue() >= 1)) {
                System.out.println("Wohoo! You succeeded in cooking all the food!");
            } else {
                System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
            }
            if (liquids.isEmpty()) {
                System.out.println("Liquids left: none");
            } else {
                System.out.println("Liquids left: " +
                        liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            if (ingredients.isEmpty()) {
                System.out.println("Ingredients left: none");
            } else {
                System.out.println("Ingredients left: " +
                        ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
        foods.forEach((k, v) -> System.out.println(k + ": " + v));
        }
    }

