package Rubiks;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Rubiks {

    enum Moves {
        UP,
        DOWN,
        RIGHT,
        LEFT,
        BACK,
        FRONT
    }
    enum Colors {
        BLUE,
        RED,
        YELLOW,
        GREEN,
        WHITE,
        ORANGE
    }

    static boolean proceed=true;
    static ArrayList <String> solutionStack = new ArrayList<>();

    static void solve() {
        for(int i=solutionStack.size()-1; i>=0; i--){
            System.out.print(solutionStack.get(i)+"");
            solutionStack.remove(i);
        }
    }

    static Colors[][][] cube1= {
        {
            {Colors.BLUE,Colors.BLUE,Colors.BLUE},
            {Colors.BLUE,Colors.BLUE,Colors.BLUE},
            {Colors.BLUE,Colors.BLUE,Colors.BLUE}
        }
    };
    static Colors[][][] cube2= {
        {
            {Colors.RED,Colors.RED,Colors.RED},
            {Colors.RED,Colors.RED,Colors.RED},
            {Colors.RED,Colors.RED,Colors.RED}
        }
    };
    static Colors[][][] cube3= {
        {
            {Colors.YELLOW,Colors.YELLOW,Colors.YELLOW},
            {Colors.YELLOW,Colors.YELLOW,Colors.YELLOW},
            {Colors.YELLOW,Colors.YELLOW,Colors.YELLOW}
        }
    };
    static Colors[][][] cube4= {
        {
            {Colors.GREEN,Colors.GREEN,Colors.GREEN},
            {Colors.GREEN,Colors.GREEN,Colors.GREEN},
            {Colors.GREEN,Colors.GREEN,Colors.GREEN}
        }
    };
    static Colors[][][] cube5= {
        {
            {Colors.WHITE,Colors.WHITE,Colors.WHITE},
            {Colors.WHITE,Colors.WHITE,Colors.WHITE},
            {Colors.WHITE,Colors.WHITE,Colors.WHITE}
        }
    };
    static Colors[][][] cube6= {
        {
            {Colors.ORANGE,Colors.ORANGE,Colors.ORANGE},
            {Colors.ORANGE,Colors.ORANGE,Colors.ORANGE},
            {Colors.ORANGE,Colors.ORANGE,Colors.ORANGE}
        }
    };
    

    static String[][] face = {
        {"1","2","3"},
        {"4","5","6"},
        {"7","8","9"}
    };

    static String[][][] cube = {
        {
            {"1b","2b","3b"},
            {"4b","5b","6b"},
            {"7b","8b","9b"}
        },
        {
            {"1r","2r","3r"},
            {"4r","5r","6r"},
            {"7r","8r","9r"}
        },
        {
            {"1y","2y","3y"},
            {"4y","5y","6y"},
            {"7y","8y","9y"}
        },
        {
            {"1g","2g","3g"},
            {"4g","5g","6g"},
            {"7g","8g","9g"}
        },
        {
            {"1w","2w","3w"},
            {"4w","5w","6w"},
            {"7w","8w","9w"}
        },
        {
            {"1o","2o","3o"},
            {"4o","5o","6o"},
            {"7o","8o","9o"}
        }
    };

    static void show(String[][] Face){
        for(String[] i: Face){
            for(String j: i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void move(String[][][] Cube, String input){
        switch(input.toLowerCase()){
            case "u":
                solutionStack.add("u'");
            break;

            case "d":
                solutionStack.add("d'");
            break;

            case "r":
                solutionStack.add("r'");
            break;

            case "l":
                solutionStack.add("l'");
            break;

            case "f":
                solutionStack.add("f'");
            break;

            case "b":
                solutionStack.add("b'");
            break;

            case "q":
                proceed = false;
            break;

            default:
        }
    }

    static void rotateFace(String[][] Face, boolean clockwise){

        String[][] tempFace = new String[3][3];

        for(int i=0; i<3;i++)
            for(int j=0; j<3;j++)
                tempFace[i][j] = Face[i][j];

        if(clockwise){
            rotateFace(face, false);
            rotateFace(face, false);
            rotateFace(face, false);
        }else{
            for(int i=0; i<3;i++)
                for(int j=0; j<3;j++)
                    Face[i][j] = tempFace[j][i];
            
            String[] tempRow = new String[3];

            for(int k=0; k<3;k++)
                tempRow[k] = Face[0][k];
            
            Face[0] = Face[2];
            Face[2] = tempRow;
        }


    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(proceed){
            move(cube, input.next());
        }
        solve();
        rotateFace(face, true);
        show(cube[0]);
        show(cube[1]);
        show(cube[2]);
        show(cube[3]);
        show(cube[4]);
        show(cube[5]);
    }
}
