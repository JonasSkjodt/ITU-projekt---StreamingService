public class Main {
    public static void main(String[] args) {
       Database db = new Database();
       db.readFile();

        System.out.println(db.getMedia().get(0).getName());
        System.out.println(db.getMedia().get(0).getGenre());
        System.out.println(db.getMedia().get(1).getName());
        System.out.println(db.getMedia().get(1).getGenre());
        System.out.println(db.getMedia());

    }

}
