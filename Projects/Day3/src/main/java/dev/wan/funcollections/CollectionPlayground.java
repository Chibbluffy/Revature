package dev.wan.funcollections;

import java.util.*;

public class CollectionPlayground {
    public static void main(String[] args) {
        Player someone = new Player("Def not me", 84);
        Player another = new Player("Also def not me", 75);
        Player me = new Player("me", 69);

        // List is an interface. ArrayList is an implementing class
        // <> = generic argument
        // Allows us to specify what goes in the list
        // This can ONLY hold Player objects. Use generics when applicable
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(someone);
        playerList.add(another);
        playerList.add(me);

        System.out.println(playerList);
        System.out.println(playerList.get(2));
        //Advantages over arrays
        // Dynamic size
        // very nice methods available

        Set<Player> playerSet = new HashSet<Player>();
        playerSet.add(someone);
        playerSet.add(another);
        playerSet.add(me);
        playerSet.add(me);
        playerSet.add(me);
        // Set does not allow duplicates
        // Set does not keep order intact
        System.out.println(playerSet);


        // Maps store key, value pairs
        Map<String, Player> playerMap = new HashMap<String, Player>();
        playerMap.put("Not me", someone);
        playerMap.put("def not", another);
        playerMap.put("me", me);

        System.out.println(playerMap.get("me"));
        System.out.println(playerMap);

        // special for loop for iterables
        // cannot iterate over maps
        for (Player p: playerList){
            System.out.println(p);
        }

        // Collections class is utility class filled with static methods
        // Type Collections. to see all the functions
    }
}
