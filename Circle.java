public class Circle extends Piece{
    
    public Circle(int team, int row, int col){
        super(team, row, col);
    }

    public String toString(){
        return getTeam() + "C";
    }
}