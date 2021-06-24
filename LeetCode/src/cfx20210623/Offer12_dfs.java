package cfx20210623;

public class Offer12_dfs {

    /**
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 输入：board = [["A","B","C","E"],
     *               ["S","F","C","S"],
     *               ["A","D","E","E"]],
     *      word = "ABCCED"
     * 输出：true
     *
     * 思路：首先遍历数组，找到第一个字符和网格中字符相同的左边，然后使用深度优先遍历
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int y_length = board.length;
        int x_length = board[0].length;

        if(word == null && word.isEmpty()){
            return false;
        }

        char[] chars = word.toCharArray();
        boolean[][] isUsed = new boolean[y_length][x_length];

        for(int y=0;y<y_length;y++){
            for(int x=0;x<x_length;x++){
                if(chars[0]==board[y][x] && dfs(board,chars,0,isUsed,y,x)){

                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先遍历
     *
     * @param board 字符网格
     * @param chars 字符串
     * @param isUsed 是否被使用
     * @param x 开始点位于第几列
     * @param y 开始点位于第几行
     */
    public boolean dfs(char[][] board, char[] chars, int currentCharIndex, boolean[][] isUsed, int y, int x){
        int y_max = board.length-1;
        int x_max = board[0].length-1;
        isUsed[y][x]=true;
        if(currentCharIndex+1 == chars.length){
            return true;
        }

        if(y>0 && !isUsed[y-1][x] &&  board[y-1][x] == chars[currentCharIndex+1] && dfs(board,chars,currentCharIndex+1,isUsed,y-1,x)){

            return true;
        }

        if(y<y_max && !isUsed[y+1][x] && board[y+1][x] == chars[currentCharIndex+1] && dfs(board,chars,currentCharIndex+1,isUsed,y+1,x)){

            return true;
        }

        if(x>0 && !isUsed[y][x-1] && board[y][x-1] == chars[currentCharIndex+1] && dfs(board,chars,currentCharIndex+1,isUsed,y,x-1)){

            return true;
        }

        if(x<x_max && !isUsed[y][x+1] && board[y][x+1] == chars[currentCharIndex+1] && dfs(board,chars,currentCharIndex+1,isUsed,y,x+1)){

            return true;
        }

        isUsed[y][x]=false;
        return false;
    }

    public static void main(String[] args) {
        Offer12_dfs offer12 = new Offer12_dfs();
       /* char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};*/
        /*char[][] board ={{'C','A','A'},
                         {'A','A','A'},
                         {'B','C','D'}};*/
        char[][] board = {{'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}};

        /*char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};*/

        System.out.print(offer12.exist(board,"ABCESEEEFS"));
//        System.out.print(offer12.exist(board,"ABCB"));
        //System.out.print(board[2][3]);
    }
}
