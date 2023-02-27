public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!this.canMoveToPositionFirstCheck(line, column, toLine, toColumn)) {
            return false;
        } else if (((Math.abs(toLine - line) == 2) && (Math.abs(toColumn - column) == 1)) || ((Math.abs(toLine - line) == 1) && (Math.abs(toColumn - column) == 2))) {

            return this.canMoveToPositionCheckColor(chessBoard, line, column, toLine, toColumn);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    public boolean canMoveToPositionFirstCheck(int line, int column, int toLine, int toColumn) {
        if ((toLine < 0) || (toLine > 7) || (toColumn < 0) || (toColumn > 7)) {
            return false;
        } else return (line != toLine) || (column != toColumn);
    }

    public boolean canMoveToPositionCheckColor(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else

            return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
    }


}
