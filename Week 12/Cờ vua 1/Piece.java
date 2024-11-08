public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Hàm khởi tạo quân cờ, mặc định là màu trắng.
     * @param coordinatesX vị trí.
     * @param coordinatesY vị trí.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        if (coordinatesX >= 1 && coordinatesX <= 8 && coordinatesY >= 1 && coordinatesY <= 8) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = "white";
        }
    }

    /**
     * Hàm khởi tạo quân cờ.
     * @param coordinatesX vị trí.
     * @param coordinatesY vị trí.
     * @param color màu.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        if (coordinatesX >= 1 && coordinatesX <= 8 && coordinatesY >= 1 && coordinatesY <= 8) {
            this.coordinatesX = coordinatesX;
            this.coordinatesY = coordinatesY;
            this.color = color;
        }
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    public boolean checkPosition(Piece piece) {
        return coordinatesX == piece.getCoordinatesX()
                && coordinatesY == piece.getCoordinatesY();
    }
}
