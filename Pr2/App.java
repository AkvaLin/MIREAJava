import java.util.*;

public class App {
    public static void main(String[] args) {
        String[] bookNames = new String[] {
            "All you need is kill", "Made in Abyss", "Spy x Family", 
            "Jujutsu Kaisen", "Chainsaw Man", "Bungou Stray Dogs",
            "Attack on Titan", "Naruto: Shippuden", "Demon Slayer",
            "Yuri on Ice"
        };
  
        String[] names = new String[] {
            "Митя", "Роман", "Митрофан", "Никита", "Артём"
        };
  
        Library library = new Library();
  
        for(int i = 0; i < bookNames.length; i++) {
          //int index = new Random().nextInt(bookNames.length);
  
          String bookName = bookNames[i];
  
          library.addToCatalog(new Book(bookName));
        }
  
        for(String name : names) {
            Reader reader = new Reader(name);
  
            library.addReader(reader);
        }

        for(Reader reader : library.getReaders()) {
            Random random = new Random();
            int booksAmount = random.nextInt(0, library.getCatalog().size());
            
            for (int i = 0; i < booksAmount; i++) {
                List<Book> catalog = library.getCatalog();
                int index = random.nextInt(0, catalog.size());
                Book book = catalog.get(index);
                reader.takeBook(library.getBook(book.getName()));
            }
        }

        System.out.println(String.format("Books amount: %s", library.getCatalog().size()));
        System.out.println("Books: ");
        for (Book catalog : library.getCatalog()) {
            System.out.println("\t - " + catalog.getName());
        }

        int takeBooksAmount = 0;
        System.out.println(String.format("Readers amount: %s", library.getReaders().size()));
        System.out.println("Readers: ");
        for (Reader reader : library.getReaders()) {
            System.out.println("\t - " + reader.getName());
            takeBooksAmount += reader.getTakenBooks().size();
        }
        System.out.println(String.format("%s books was taken", takeBooksAmount));
    }
}