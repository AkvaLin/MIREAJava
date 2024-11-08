import java.util.*;

public class GameShop {
    public class GameShopException extends Exception {
        public GameShopException() { super(); }
        public GameShopException(String message) { super(message); }
    }

    private final Map<String, BoardGame> gamesCatalog;
    private float earnings;

    public GameShop() {
        this.gamesCatalog = new HashMap<>();
        this.earnings = 0;

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

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            BoardGame game = new BoardGame(gameTitles[i], 
                                           random.nextInt(1,2), 
                                           random.nextInt(2,12), 
                                           random.nextInt(5, 240), 
                                           random.nextInt(0, 18), 
                                           random.nextFloat(5, 400));
            gamesCatalog.putIfAbsent(game.getName(), game);
        }
    }

    public float getEarnings() { return earnings; }
    public List<BoardGame> getCatalog() { return gamesCatalog.values().stream().toList(); }

    public BoardGame buyGame(String title, float budget) throws GameShopException {
        BoardGame game = gamesCatalog.get(title);

        if (game == null) {
            throw new GameShopException(String.format("Игра %s отсутсвует в наличии", title));
        }

        if (game.getPrice() <= budget) {
            gamesCatalog.remove(title);
            earnings += game.getPrice();
            return game;
        } else {
            throw new GameShopException("У покупателя недостаточно средств на счету");
        }
    }
}
