package cfx20190608;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {

        //小块检查
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                if(isRepeated(board,i,j))
                    return false;
            }
        }

        //横竖检查
        for(int i=0;i<9;i++){
            if(colRepeated(board,i) || rowRepeated(board,i))
                return false;
        }
        return true;
    }

    public boolean colRepeated(char[][] board,int colIndex){
        boolean flag=false;
        int[] count={0,0,0,0,0,0,0,0,0};
        for(int i=0;i<9;i++){
            if(board[i][colIndex]>=49)
                count[board[i][colIndex]-49]++;
        }
        for(int i=0;i<9;i++){
            if(count[i]>=2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean rowRepeated(char[][] board,int rowIndex){
        boolean flag=false;
        int[] count={0,0,0,0,0,0,0,0,0};
        for(int i=0;i<9;i++){
            if(board[rowIndex][i]>=49)
                count[board[rowIndex][i]-49]++;
        }
        for(int i=0;i<9;i++){
            if(count[i]>=2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean isRepeated(char[][] board,int rowIndex,int colIndex){
        boolean flag=false;
        int[] count={0,0,0,0,0,0,0,0,0};
        for(int i=rowIndex;i<rowIndex+3;i++){
            for(int j=colIndex;j<colIndex+3;j++){
                if(board[i][j]>=49)
                    count[board[i][j]-49]++;
            }

        }
        for(int i=0;i<9;i++){
            if(count[i]>=2) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] soduko1={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        
        char[][] soduko2={
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        
        char[][] soduko3={
                {'.','.','.','9','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','3','.','.','.','.','.','1'},
                {'.','.','.','.','.','.','.','.','.'},
                {'1','.','.','.','.','.','3','.','.'},
                {'.','.','.','.','2','.','6','.','.'},
                {'.','9','.','.','.','.','.','7','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'8','.','.','8','.','.','.','.','.'}
        };
        
        Solution36 solution36=new Solution36();
        boolean flag=solution36.isValidSudoku(soduko3);
        System.out.print(flag);
    }
}
