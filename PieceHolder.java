import java.util.Arrays;

public class PieceHolder{
    private Piece[][] holder;
    private int type; //0 -> board, 1 -> hand

    public PieceHolder(int t){
        type = t;
        if(t == 0){
            holder = new Piece[4][3];
        }else if(t == 1){
            holder = new Piece[1][6];
        }
    }

    public Piece[][] getHolder(){
        return holder;
    }

    public void reset(){
        if(type == 0){
            //empty the board
            for(Piece[] row: holder){
                Arrays.fill(row, null);
            }

            //upper pieces - p2
            holder[0][0] = new Triangle(2, 0, 0);
            holder[0][1] = new Circle(2, 0, 1);
            holder[0][2] = new Square(2, 0, 2);
            holder[1][1] = new Line(2, 1, 1);
            
            //lower pieces - p1
            holder[2][1] = new Line(1, 2, 1);
            holder[3][0] = new Square(1, 3, 0);
            holder[3][1] = new Circle(1, 3, 1);
            holder[3][2] = new Triangle(1, 3, 2);

        }else if(type == 1){
            //empty the hand
            Arrays.fill(holder, null);
        }
    }

    public void update(){
        if(type == 0){
            //update board
            for(int i = 0; i < holder.length; i++){
                for(int j = 0; j < holder[i].length; j++){
                    if(holder[i][j] != null){
                       int r = holder[i][j].getRow();
                       int c = holder[i][j].getCol();
                        if(i != r || j != c){
                            Piece target = holder[r][c];
                            if(target != null){
                                if(target.getTeam() == 1){
                                    Chess12.handB.capture(target);
                                }else{
                                    Chess12.handA.capture(target);
                                }
                            }
    
                            if(target.getClass().getName().equals("Circle")) Chess12.endGame = true;
    
                            this.relocate(i, j, r, c);
                        }
                    }
                }
            }
        }else if(type == 1){
            //update hand
            for(int j = 0; j < holder[0].length; j++){
                if(holder[0][j] != null){
                    int r = holder[0][j].getRow();
                    int c = holder[0][j].getCol();
                    if(r >= 0){
                        Chess12.board.getHolder()[r][c] = holder[0][j];
                        holder[0][j] = null;
                    }
                }
            }
        }
    }

    public void relocate(int ar, int ac, int br, int bc){
        Piece temp = holder[ar][ac];
        holder[ar][ac] = holder[br][bc];
        holder[br][bc] = temp;
    }

    public void capture(Piece target){
        int next = 0;
        for(int k = 0; k < holder[0].length; k++){
            if(holder[0][k] == null){
                next = k;
                break;
            }
        }
        target.setPos(-1 * target.getTeam(), next);
        target.changeTeam();
        holder[0][next] = target;
        target = null;
    }


}
