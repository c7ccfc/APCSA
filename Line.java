public class Line extends Piece{
    
    public Line(int team, int row, int col){
        super(team, row, col);
    }

    public String toString(){
        return getTeam() + "L";
    }

    public void moveF(){
        this.move(-1 * this.getTeam(), 0);
    }
}