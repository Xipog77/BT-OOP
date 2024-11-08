import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    public Game() {
        board = new Board();
        moveHistory = new ArrayList<>();
    }

    /**
     * Hàm di chuyển quân cờ.
     * @param piece quân cờ.
     * @param x vị trí đến.
     * @param y vị trí đến.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)
                && board.getPieces().contains(piece)) {

            int startX = piece.getCoordinatesX();
            int startY = piece.getCoordinatesY();

            Piece target = board.getAt(x, y);
            if (target != null) {
                moveHistory.add(new Move(startX, x, startY, y,
                        piece, target));
                board.removeAt(x, y);
            } else {
                moveHistory.add(new Move(startX, x, startY, y,
                        piece));
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
