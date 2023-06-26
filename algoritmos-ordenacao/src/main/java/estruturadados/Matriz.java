package estruturadados;

import java.util.Arrays;
import java.util.List;

public class Matriz {

    public static void main(String[] args) {


        char [][] campoDeBatalha = new char [5][3];

        campoDeBatalha[0][0] = 'n';
        campoDeBatalha[1][0] = 's';
        campoDeBatalha[2][0] = 's';
        campoDeBatalha[3][0] = 's';
        campoDeBatalha[4][0] = 'n';

        for (int i = 0; i < campoDeBatalha.length; i++) {
            for (int j = 0; j < campoDeBatalha[i].length; j++) {
                System.out.println(campoDeBatalha[i][j]);
            }
        }
    }
}
