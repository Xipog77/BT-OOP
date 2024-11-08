public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;
    private static final char[] row = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    /**
     * Hàm khởi tạo đầy đủ Move.
     * @param startX tọa độ xuất phát X.
     * @param startY tọa độ xuất phát Y.
     * @param endX tọa độ kết thúc X.
     * @param endY tọa độ kết thúc Y.
     * @param movedPiece quân cờ di chuyển.
     * @param killedPiece quân cờ mục tiêu.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * Hàm khởi tạo Move không có quân cờ bị ăn.
     * @param startX tọa độ xuất phát X.
     * @param startY tọa độ xuất phát Y.
     * @param endX tọa độ kết thúc X.
     * @param endY tọa độ kết thúc Y.
     * @param movedPiece quân cờ di chuyển.
     */
    public Move(int startX, int endX, int startY, int endY, Piece movedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Hàm trả về thông tin đại diện.
     * @return string.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(movedPiece.getColor() + "-");
        sb.append(movedPiece.getSymbol());
        sb.append(row[endX - 1]);
        sb.append(endY);

        return sb.toString();
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }
}
