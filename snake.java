import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class snake{
    private char board[][] = null;
    Queue<Node> queue = new LinkedList<Node>();
    snake(int totalcol,int totalrow){
    board = new char[totalrow][totalcol];
    queue.add(new Node(0, 0));
    board[0][2] = 'X';
    board[4][3] = 'X';
    board[3][1] = 'X';
    board[5][0] = 'X';
    board[3][3] = 'X';
    }
    public void move(int row,int col){
        if(row>=0 && col>=0){
          if(board[row][col]=='.'){
            System.out.println("Game over");
            System.exit(0);
          }
          queue.add(new Node(row, col));
          if(board[row][col]!='X'){
             Node node = queue.poll();
             int r = node.getrow();
             int c = node.getcol();
             System.out.println(r+" "+c);
             board[r][c]='\0';
             System.out.println("1");
          }
          board[row][col]='.';
          
          while (!queue.isEmpty()) {
            Gamedis();
            Scanner getInt = new Scanner(System.in);
            System.out.println("Enter the move :");
            char move = getInt.next().charAt(0);
            if(move == 'R'){
                move(row,++col);
            }
            if(move == 'L'){
                move(row,--col);
            }
            if(move == 'U'){
                move(--row,col);
            }
            if(move == 'D'){
                move(++row,col);
            }
          }

        }
        else{
            System.out.println("Game over");
            System.exit(0);
        }
    }
    private void Gamedis(){
        for(int i=0;i<6;i++){
           for(int j=0;j<6;j++){
            if((board[i][j])=='X' || board[i][j]=='.'){
                System.out.print(board[i][j]+" ");
            }
            else{
                System.out.print("0 ");
            }
           }
           System.out.println();
        }
     }
}
