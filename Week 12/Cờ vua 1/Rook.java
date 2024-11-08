public class Rook extends Piece {
    public Rook(int x, int y) {
        super(x, y);
    }

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }


    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     *  Hàm di chuyển quân xe.
     * @param board bàn cờ.
     * @param x vị trí đến.
     * @param y vị trí đến.
     * @return có di chuyển được không.
     */
    @Override
    public boolean canMove(Board board, int x, int y) {

        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }

        //Đi thẳng
        if (this.getCoordinatesY() == y) {
            // Đi lên
            if (this.getCoordinatesX() < x) {
                for (int i = this.getCoordinatesX() + 1; i < x; i++) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.getCoordinatesX() - 1; i > x; i--) {
                    if (board.getAt(i, y) != null) {
                        return false;
                    }
                }
            }
        }
        // Đi ngang
        if (this.getCoordinatesX() == x) {
            // Sang trái
            if (this.getCoordinatesY() < y) {
                for (int i = this.getCoordinatesY() + 1; i < y; i++) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.getCoordinatesY() - 1; i > y; i--) {
                    if (board.getAt(x, i) != null) {
                        return false;
                    }
                }
            }
        }
        //Ăn quân
        if (board.getAt(x, y) != null) {
            Piece target = board.getAt(x, y);
            if (target.getColor().equals(this.getColor())) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
}
