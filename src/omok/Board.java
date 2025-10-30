package omok;

public class Board {
    int size;
    String[][] map;

    Board(int size) {
        this.size = size;
        int a = 0;
        char b = 65; // 아스키코드
        map = new String[size + 1][size + 1];

        for (int row = 0; row <= size; row++) {
            map[row][0] = (row < size) ? String.valueOf(row) : "  "; // (19.0) 공백
        }

        char ch = 'A';
        for (int col = 1; col <= size; col++) {
            map[size][col] = String.valueOf(ch++);
        }

        for(int row=0; row < size; row++) {
            for(int col=1; col <=size; col++) {
                map[row][col] = ".";
            }
        }
    }

    /*        for (int col = 0; col < 1; col ++) // 0~18
                for (int row = 0; row < size + 1; row ++) {
                    map[row][col] = "" + a;
                    a++;
                }
            for (int row = size; row < size+1; row ++) // A~S
                for (int col = 1; col <= size; col ++) {
                    map[row][col] = "" + b;
                    b++;
                }
            for (int row = 0; row < size ; row++) {
                for (int col = 1; col < size+1; col++) {
                    map[row][col] = ".";
                }
            }
            map[19][0] = " "; // (19,0)는 공백
        }

     */
    public void print() {
        for (int row = 0; row <= size; row++) {
            for (int col = 0; col <= size ; col++) {
                System.out.printf("%2s", map[row][col]);  //2칸씩 정렬
            }
            System.out.println();
        }

    }
}