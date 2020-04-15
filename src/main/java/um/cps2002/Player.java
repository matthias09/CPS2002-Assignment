package um.cps2002;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);

    Position position;
    Position start;

    Player(){
        this.position = new Position();
        this.start = new Position();
    }

    void move(Map map) {
        char direction = 0;
        boolean valid = false;

        while(!valid) {
            direction = sc.next().charAt(0);

            if((direction == 'U' && position.y == 0)
                    || (direction == 'D' && position.y == map.size - 1)
                    || (direction == 'L' && position.x == 0)
                    || ((direction == 'R' && position.x == map.size - 1))){
                System.out.println("Invalid move please try again");
            }else if (direction == 'U' || direction == 'D' || direction == 'L' || direction == 'R')
                valid = true;
        }
        switch (direction) {
            case 'U':
                position.y--;
                break;
            case 'D':
                position.y++;
                break;
            case 'L':
                position.x--;
                break;
            case 'R':
                position.x++;
                break;
            default:
                System.out.println("Error");
        }
    }
}
