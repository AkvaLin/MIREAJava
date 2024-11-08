import java.util.*;

public class GameBoardApp {
    public static void main(String[] args) {
        GameShop shop = new GameShop();
        ArrayList<Customer> customers = new ArrayList<>();

        String[] gameTitles = new String[] {
            "First",
            "Second",
            "Not second",
            "NAN",
            "Fifth",
            "Rly?",
            "Why?",
            "It's a lot",
            "Three should be enough",
            "Wow, that's last"
        };

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            customers.add(new Customer(gameTitles[random.nextInt(0, 9)], random.nextFloat(0, 1000)));
        }

        for (Customer customer : customers) {
            try {
                BoardGame game = shop.buyGame(customer.getGameName(), customer.getMoney());
                System.out.println(String.format("Игра %s была куплена по цене %f", game.getName(), game.getPrice()));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        System.out.println(String.format("Было продано %s игр(-а/-ы)", gameTitles.length - shop.getCatalog().size()));
        System.out.println(String.format("Заработок составил %s", shop.getEarnings()));
    }
}
