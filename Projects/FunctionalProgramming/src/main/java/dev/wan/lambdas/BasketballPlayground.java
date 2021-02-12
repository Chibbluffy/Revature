package dev.wan.lambdas;

import java.util.*;

public class BasketballPlayground {
    public static void main(String[] args) {
        Player lebron = new Player("Lebron James", 79, 20_000_000);
        Player giannas = new Player("Giannas An", 84, 15_000_000);
        Player steph = new Player("Steph Curry", 75, 17_000_000);

        List<Player> players= new ArrayList<Player>();


        players.add(lebron);
        players.add(giannas);
        players.add(steph);

        // Tasked to sort the players
        // 1. order by height
        // 2. order by salary
        // 3. order alphabetically
        System.out.println(players);
        // 1.
        Comparator<Player> orderBySalary = (Player player1, Player player2) ->{
            //Comparators work by comparing the two objects being passed in
            // if obj1 < obj2, return -1
            // if obj1 == obj2 return 0
            // if obj1 > obj2 return 1
            if (player1.salary < player2.salary){
                return -1;
            }
            if (player1.salary > player2.salary){
                return 1;
            }
            return 0;
        };

        System.out.println(orderBySalary.compare(steph, lebron));
        Collections.sort(players, orderBySalary);
        System.out.println(players);

        // 2
        Comparator<Player> orderByHeight = (Player p1, Player p2)->{
            if (p1.height < p2.height){
                return -1;
            }
            if (p1.height > p2.height){
                return 1;
            }
            return 0;
        };
        Collections.sort(players, orderByHeight);
        System.out.println(players);

        // 3
        Comparator<Player> orderAlpha = (Player p1, Player p2)->{
            return p1.name.compareTo(p2.name);
        };
        Collections.sort(players, orderAlpha);
        System.out.println(players);

    }
}
