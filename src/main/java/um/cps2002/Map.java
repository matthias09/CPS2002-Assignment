package um.cps2002;

public class Map {
    //Variables
    int size;
    private String [][] map;

    Map(int size){
        this.size = size;
        map = new String[size][size];
    }
}
