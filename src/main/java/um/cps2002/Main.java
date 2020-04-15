package um.cps2002;

import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);

    private int get_num_players() {
        //Validating number of players input
        int n_players;

        while (true) {
            try {
                System.out.println("Please input the number of players (Min = 2, Max = 8):");
                n_players = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input");
                continue;
            }
            if (n_players < 2 || n_players > 8) {
                System.out.println("Input is not in acceptable range.");
            } else {
                break;
            }
        }
        return n_players;
    }

    private int get_map_size(int n_players) {
        int map_size;

        //Validating map size input
        while (true) {
            try {
                if (n_players < 4) {
                    System.out.println("Please input the size of the square map (Min = 5, Max = 50):");
                } else {
                    System.out.println("Please input the size of the square map (Min = 8, Max = 50):");
                }
                map_size = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input");
                continue;
            }

            if ((map_size < 5 && n_players <= 4) || (map_size < 8 && n_players > 4) || map_size > 50) {
                System.out.println("Input is not in acceptable range.");
            } else {
                break;
            }
        }
        return map_size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Variables
        Main m = new Main();
        int n_Players;
        int m_size;

        //Step 1
        n_Players = m.get_num_players();
        m_size = m.get_map_size(n_Players);

        //Setting of variables
        Map map = new Map(m_size);
        Player[] player = new Player[n_Players];

        for (int x = 0; x < n_Players; x++) {
            player[x] = new Player();
        }

        //Step 2
        map.generate_Map();

        //Step 3
        for (int x = 0; x < n_Players; x++) {
            player[x].setPosition(map);
        }

        boolean winner = false;
        int temp_x,temp_y;
        char direction;

        while (!winner) {
            //Step 4
            //To be implemented: Generation of html files


            //Step 5 and 6
            for (int x = 0; x < n_Players; x++) {
                temp_x = player[x].position.x;
                temp_y = player[x].position.y;
                while(player[x].position.x == temp_x && player[x].position.y == temp_y) {
                    System.out.println("Player " + (x + 1) + " please input your move (U = Up, D = down, L = Left, R = Right):");
                    direction = sc.next().charAt(0);
                    player[x].move(map,direction);
                }
            }

            //Step 7
            for (int x = 0; x < n_Players; x++) {
                System.out.print("Player " + (x + 1));
                if (map.getTileType(player[x].position).equals("Y")) {
                    System.out.println(" found the Treasure");
                    winner = true;
                } else if (map.getTileType(player[x].position).equals("B")) {
                    System.out.println(" stepped on water and went back to his starting position");
                    player[x].position.x = player[x].start.x;
                    player[x].position.y = player[x].start.y;
                } else {
                    System.out.println(" stepped on grass");
                }
            }
        }

        //Declaration of winners
        System.out.println("Winner(s): ");
        for (int x = 0; x < n_Players; x++) {
            if (map.getTileType(player[x].position).equals("Y"))
                System.out.print((x + 1) + " ");
        }
    }
}