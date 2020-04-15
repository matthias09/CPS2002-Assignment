package um.cps2002;

import java.util.Random;

public class Player {
    private Random rand = new Random();

    public Position position;
    private Position start;

    public Player(){
        this.position = new Position();
        this.start = new Position();
    }


    public Position move(Map map, char direction) {
        if ((direction == 'U' && position.y == 0)
                || (direction == 'D' && position.y == map.size - 1)
                || (direction == 'L' && position.x == 0)
                || ((direction == 'R' && position.x == map.size - 1))) {
            System.out.println("Invalid move");
            return position;
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
        return position;
    }

    public void setPosition(Map map){
        boolean valid = false;
        int temp_x, temp_y;

        while(!valid){
            temp_x = rand.nextInt(map.size);
            temp_y = rand.nextInt(map.size);

            if((map.map[temp_y][temp_x].equals("G"))){
                valid = true;
                start.x = temp_x;
                start.y = temp_y;
                position.x = temp_x;
                position.y = temp_y;
            }
        }
    }
}
