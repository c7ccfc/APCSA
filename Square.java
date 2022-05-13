public class Square extends Piece{
    
    public Square(int team, int row, int col){
        super(team, row, col);
    }

    public String toString(){
        return getTeam() + "S";
    }
}