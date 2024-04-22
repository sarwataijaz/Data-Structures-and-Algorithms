public class Main {
    public static void main(String[] args) {
        HashTables<String,Integer> countries = new HashTables();
        countries.put("Pakistan",124345);
        countries.put("India",34567);
        countries.put("China",8347);

        System.out.println(countries.get("Pakistan"));
        System.out.println(countries.get("China"));

    }
}
