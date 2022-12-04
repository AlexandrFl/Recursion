public class Main {
    private static int a = 10;
    private static char[][] field = new char[a][a];
    private static char[][] memory = new char[a][a];
    private static int hX = 8;
    private static int hY = 3;

    public static void main(String[] args) {
        field = field();
        findPath(field, hY, hX, memory);
    }

    public static int whereFrom(char[][] b, int x, int y, char[][] memory) {
        if (memory[x][y] != 0) {
            return memory[x][y];
        }
        if (x > 0) {
            int left_x = x - 1;
            if (left_x == 0 && y == 0) {
                memory[x][y] = 'L';
                return 'L';
            }
            if (b[left_x][y] != '*') {
                if (whereFrom(b, left_x, y, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }
        if (y > 0) {
            int up_y = y - 1;
            if (x == 0 & up_y == 0) {
                memory[x][y] = 'U';
                return 'U';
            }
            if (b[x][up_y] != '*') {
                if (whereFrom(b, x, up_y, memory) != 'N') {
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }


    public static void findPath(char[][] field, int x0, int y0, char[][] memory) {
        char[][] path = new char[a][a];
        int x = x0;
        int y = y0;
        while (x != 0) {
            int direction = whereFrom(field, x, y, memory);
            if (direction == 'N') {
                System.out.println("Пути нет");
            } else if (direction == 'U') {
                path[x][y] = 'д';
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = 'д';
                x -= 1;
            }
        }
        while (y != 0) {
            int direction = whereFrom(field, x, y, memory);
            if (direction == 'N') {
                System.out.println("Пути нет");
            } else if (direction == 'U') {
                path[x][y] = 'д';
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = 'д';
                x -= 1;
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == 0 && j == 0) {
                    field[i][j] = 'Щ';
                } else if (j == hX && i == hY) {
                    field[i][j] = 'Ч';
                } else if (path[i][j] == 'д') {
                    field[i][j] = 'x';
                } else {
                    path[i][j] = field[i][j];
                }
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] field() {
        char[][] field = new char[a][a];
        field[0][3] = '*';
        field[0][4] = '*';
        field[1][4] = '*';
        field[1][6] = '*';
        field[1][7] = '*';
        field[2][3] = '*';
        field[2][5] = '*';
        field[2][9] = '*';
        field[3][1] = '*';
        field[4][6] = '*';
        field[5][2] = '*';
        field[5][5] = '*';
        field[6][3] = '*';
        field[6][6] = '*';
        field[6][7] = '*';
        field[6][8] = '*';
        field[7][7] = '*';
        field[8][7] = '*';
        field[9][5] = '*';
        field[9][6] = '*';
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = '-';
                }
            }
        }
        return field;
    }
}

