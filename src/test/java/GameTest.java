import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test

    public void bothRegisteredAndTheSecondWon() {

        Player player1 = new Player(1, "Lora Palmer", 200);
        Player player2 = new Player(2, "Bob", 300);

        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);

        int exception = 2;
        int actual = manager.round(player1.getName(), player2.getName());

        Assertions.assertEquals(exception, actual);
    }

    @Test

    public void bothRegisteredAndTheFirstWon() {

        Player player1 = new Player(1, "Agent Cooper", 500);
        Player player2 = new Player(2, "Bob", 300);

        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);

        int exception = 1;
        int actual = manager.round(player1.getName(), player2.getName());

        Assertions.assertEquals(exception, actual);
    }

    @Test

    public void bothRegisteredAndNobodyWon() {

        Player player1 = new Player(1, "Giant", 300);
        Player player2 = new Player(2, "Bob", 300);

        Game manager = new Game();
        manager.register(player1);
        manager.register(player2);

        int exception = 0;
        int actual = manager.round(player1.getName(), player2.getName());

        Assertions.assertEquals(exception, actual);
    }

    @Test

    public void theFirstIsNotRegistered() {

        Player player1 = new Player(1, "Lora Palmer", 200);
        Player player2 = new Player(2, "Bob", 300);

        Game manager = new Game();
        manager.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> manager.round(player1.getName(), player2.getName()
                ));
    }

    @Test

    public void theSecondIsNotRegistered() {

        Player player1 = new Player(1, "Lora Palmer", 200);
        Player player2 = new Player(2, "Bob", 300);

        Game manager = new Game();
        manager.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> manager.round(player1.getName(), player2.getName()
                ));
    }
}

