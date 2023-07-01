import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    // все зарегистрированные игроки хранятся в виде списка
    HashMap<String, Player> map = new HashMap<>();

    // метод регистрации игрока
    public void register(Player player) {
        map.put(player.getName(), player);
    }

    // метод сореевнования между двумя игроками
    public int round(String playerName1, String playerName2) {

        Player player1 = null;
        Player player2 = null;

        if (!map.containsKey(playerName1)) {
            throw new NotRegisteredException(playerName1);
        }
        if (!map.containsKey(playerName2)) {
            throw new NotRegisteredException(playerName2);
        }

        player1 = map.get(playerName1);
        player2 = map.get(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        }
        return 0;
    }
}
