import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {}

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    /**
     * Kiểm tra xem vị trí có hợp lệ và có trùng với quân cờ nào không.
     * Thêm quân cờ mới vào danh sách.
     * @param p quân cơ thêm.
     */
    public void addPiece(Piece p) {
        if (validate(p.getCoordinatesX(), p.getCoordinatesY())) {
            for (Piece piece : pieces) {
                if (piece.checkPosition(p)) {
                    return;
                }
            }
            pieces.add(p);
        }
    }

    /**
     * Lấy quân cờ ở vị trí x, y.
     * @param x vị trí.
     * @param y vị trí.
     * @return trả về quân cờ.
     */
    public Piece getAt(int x, int y) {
        if (validate(x, y)) {
            for (Piece piece : pieces) {
                if (piece.getCoordinatesX() == x
                        && piece.getCoordinatesY() == y) {
                    return piece;
                }
            }
        }
        return null;
    }

    /**
     * Xóa quân cờ ở một vị trí.
     * @param x vị trí.
     * @param y vị trí.
     */
    public void removeAt(int x, int y) {
        if (validate(x, y)) {
            pieces.remove(getAt(x, y));
        }
    }
}
