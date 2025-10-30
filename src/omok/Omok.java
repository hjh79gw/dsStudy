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

        while (true) {
            // 위치 입력받기
            System.out.println(player + "> ");
            String cordiante = scan.nextLine().toUpperCase(); //대소문자 처리
            String[] p = cordiante.split(" ");  //스페이스 기준으로 배열에 저장

            char colCh = p[0].charAt(0);
            int col = (colCh - 'A') + 1; // 들어온 아스키코드 -65, 인덱스 열 범위 1~19
            int row = Integer.parseInt(p[1]); // 두번째 입력받은 수 저장

            // 오목 시행
            String stone = player.equals("사용자") ? user.stone : computer.stone; // 문자열 비교. 삼항연사자로 조건 시행
            board.map[row][col] = stone;
            board.print();

            if (win(board)) {
                System.out.println(player + "승리");
                break;
            }
            player = player.equals("사용자") ? "컴퓨터" : "사용자";  // 턴 변경.
        }
        scan.close();
    }



            /*
            String coordinate = scan.nextLine(); // 사용자에게 좌표 입력 받음 "x y" 형태
            String[] splitCoordinate = coordinate.split(" "); // 띄어쓰기로 분리

            System.out.println(Arrays.toString(splitCoordinate)); // 분리 확인용 코드

            int u_x = Integer.parseInt(splitCoordinate[0]); // 배열의 0번 인덱스는 x
            int u_y = Integer.parseInt(splitCoordinate[1]); // 1번 인덱스는 y

            if (board.map[u_x][u_y] == "O") {
                ;
            }



            board.print();

             */





    //한 줄씩 탐색
    private static boolean win(Board b) {
        for (int r = 0; r <b.size; r++)  // 행(r,1) 부터 오른쪽
            if(navigate(b, r, 1, 0, 1)) {
                return true;
            }

        for (int c = 1; c <b.size; c++)  // 열 (0,c) 부터 아래쪽
            if(navigate(b, 0, c, 1, 0)) {
                return true;
            }

        for (int c = 1; c <b.size; c++)  // 대각 아래, 오른쪽 경계
            if(navigate(b, 0, c, 1, 1)) {
                return true;
            }

        for (int r = 0; r <  b.size; r++)  // 대각 아래 , 왼쪽 경게
            if(navigate(b, r, 1, 1, 1)) {
                return true;
            }

        for (int c = 1; c <= b.size; c++)  // 대각 위 , 오른쪽 경계
            if(navigate(b, b.size - 1, c, -1, 1)) {
                return true;
            }

        for (int r = b.size; r >= 0; r--)  // 대각 위 , 왼쪽 경계
            if(navigate(b, r, 1, -1, 1)) {
                return true;
            }



        return false;
    }

    private static boolean navigate(Board b, int sr, int sc, int dr, int dc) {
        int r = sr, c = sc; // 위치
        int findO = 0, findX = 0; //  사용자/컴퓨터 연속된 돌의 개수
        // sr 시작행 sc 시작 열 dr 행 변화량 dc 열 변화량

        while (0 <= r && r <= b.size - 1 && 1 <= c && c <= b.size) {  //탐색 범위 지정
            String location = b.map[r][c];

            if ("O".equals(location)) {  // 사용자 돌 발견시
                findO++;                 // 사용자 돌 개수 증가, 컴퓨터 돌 개수 증감
                findX = 0;
            } else if ("X".equals(location)) {   // 위와 반대
                findX++;
                findO = 0;
            } else {    // 돌 없는 경우 사용자/컴퓨터 돌 개수 0 초기화
                findO = 0;
                findX = 0;
            }

            if (findO >= 5 || findX>= 5) {
                return true;
            }

            r += dr;   //이동
            c += dc;

        }
        return false;
    }
}








/* 돌 놓기
 * scanner
 * 반복문(사용자, 컴퓨터가 한 번씩 해야 턴이 끝남)
 * 사용자 좌표 입력 (String)
 * 내부 열 인덱스 1 ~ 19 (A ~ S)
 * 내부 행 인덱스 0 ~ 18
 * 사용자 /컴퓨터 턴 구분 > user.stone / computer.stone
 * board.map [row][col] = stone;
 * 턴 넘김
 * 이미 둔 곳이면 다시 입력
 * map[x][y] = "X";
 */


/* 승리 판정
 * 모든 행 / 열 / 대각 훑기?
 * 왼 > 오 방향으로 연속된 O OR X 탐색 + 대각?
 * 탐색 범위 지정
 * 현재 칸의 값 확인
 * "O" 발견시 "x" 초기화 , "x" 발견시 "O" 초깅화, "." 발견시 "O" , "x" 초기화
 *
 */