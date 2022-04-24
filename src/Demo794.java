public class Demo794 {

    public boolean validTicTacToe(String[] board) {
        int xCur = 0;
        int yCur = 0;
        char[][] array = new char[3][3];
        for(int i = 0; i < board.length; i++){
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++){
                array[i][j] = chars[j];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "千变科技有限公司";
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < chars.length; i++){
//            System.out.println(chars[i]);
//        }

        String regEx = "[\\u4e00-\\u9fa5]";

        String term= str.replaceAll(regEx, "aa");

        int count = term.length()-str.length();

        System.out.println(count);

    }
}
