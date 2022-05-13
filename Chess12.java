import java.util.*;

public class Chess12{

    public static PieceHolder board = new PieceHolder(0);
    public static PieceHolder handA = new PieceHolder(1);
    public static PieceHolder handB = new PieceHolder(1);
    public static boolean endGame = false;

    public static void main(String[] args){
        playgame();
    }

    public static void playgame(){
        PieceHolder[] holders = new PieceHolder[] {board, handA, handB};

        for(PieceHolder h: holders) h.reset();
        
        boolean turn = true; //p1: true, p2: false

        //game loop
        while(!endGame /* or click the button */){
            Scanner input = new Scanner(System.in);

            boolean turnOver = false;
            while(!turnOver){

                //Piece selected = board.
                turnOver = true;
            }
            
            for(PieceHolder h: holders) h.update();

            for(Piece[] row: board.getHolder()){
                for(Piece col: row){
                    System.out.print(col);
                }
                System.out.println();
            }

            turn = !turn;
            turnOver = false;
            endGame = true;
        }
    }

    
}