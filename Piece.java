public class Piece{
    //player1: team +1, player2: team -1
    private int team;
    private boolean inGame;
    private int posR;
    private int posC;

    public Piece(int t, int r, int c){
        team = t;
        inGame = true;
        posR = r;
        posC = c;
    }
    
    public int getTeam(){
        return team;
    }

    public void changeTeam(){
      if(team == 1) team++;
      else if(team == 2) team--;
    }

    public int getRow(){
        return posR;
    }

    public int getCol(){
        return posC;
    }

    public void move(int dr, int dc){
        posR += dr;
        posC += dc;
    }

    public void setPos(int r, int c){
        posR = r;
        posC = c;
    }
    
    //public void moveF(){}

    public void revive(int r, int c){
        this.setPos(r, c);
    }
}