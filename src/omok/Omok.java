package omok;
import java.util.*;
public class Omok {
    public static void main(String[] args) {
        Player user = new Player("사용자", "O");
        Player computer = new Player("컴퓨터", "X");
        Board board = new Board(19);
        play(board, user, computer);
    }

    private static void play(Board board, Player user, Player computer) {
        board.print();
        Scanner scan = new Scanner(System.in);
        String player = "사용자";

        while(true) {
            // 위치 입력받기
            System.out.println(player + "> ");
            String line = scan.nextLine().toUpperCase();
            String[] p = line.split(" ");  //스페이스 기준으로 배열에 저장

            char colCh = p[0].charAt(0);
            int col = (colCh - 'A' ) + 1; // 들어온 아스키코드 -65, 인덱스 열 범위 1~19
            int row = Integer.parseInt(p[1]);

            // 오목 시행
            String stone = player.equals("사용자") ? user.stone : computer.stone; // 문자열 비교. 삼항연사자로 조건 시행
            board.map[row][col] = stone;
            board.print();




            /*String coordinate = scan.nextLine(); // 사용자에게 좌표 입력 받음 "x y" 형태
            String[] splitCoordinate = coordinate.split(" "); // 띄어쓰기로 분리

            System.out.println(Arrays.toString(splitCoordinate)); // 분리 확인용 코드

            int u_x = Integer.parseInt(splitCoordinate[0]); // 배열의 0번 인덱스는 x
            int u_y = Integer.parseInt(splitCoordinate[1]); // 1번 인덱스는 y

            if (board.map[u_x][u_y] == "O") {
                ;
            }



            board.print();

             */
        }




    }
    /* 돌 놓기
     * scanner
     * 반복문(사용자, 컴퓨터가 한 번씩 해야 턴이 끝남)
     * 사용자 좌표 입력 (String)
     * 내부 열 인덱스 1 ~ 19 a~s
     * 내부 행 인덱스 0 ~ 18
     * 사용자 /컴퓨터 턴 구분 > user.stone / computer.stone
     * board.map [row][col] = stone;
     * 턴 넘김
     * 이미 둔 곳이면 다시 입력
     * map[x][y] = "X";
     */


    /* 승리 판정
     * 현재 놓은 돌 기준으로 각 방향 탐색
     * 현재 좌표 양쪽 합이 5면 승리
     * 가로 세로 양쪽대각
     */
}