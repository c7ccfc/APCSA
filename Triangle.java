public class Triangle extends Piece{
    
    public Triangle(int team, int row, int col){
        super(team, row, col);
    }

    public String toString(){
        return getTeam() + "T";
    }
}