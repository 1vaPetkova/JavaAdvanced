package T08Generics.lab.P03GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a","z");
        System.out.println(scale.getHeavier());

        Scale<Integer> scaleInt = new Scale<>(73,13);
        System.out.println(scaleInt.getHeavier());

    }
}
