public class Main {
    public static void main(String[] args) {
       Database db = new Database();
       Database.readFile();

        System.out.println(Database.getMedia().get(0).getName());
        System.out.println(Database.getMedia().get(0).getGenre());
        System.out.println(Database.getMedia().get(1).getName());
        System.out.println(Database.getMedia().get(1).getGenre());

        System.out.println(Database.getMedia());

    }

}
