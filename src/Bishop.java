public class Bishop extends ChessPiece {

    public Bishop(String color) {
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
        } else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {

            return this.canMoveToPositionCheckColor(chessBoard, line, column, toLine, toColumn) && diagonalMoves(chessBoard, line, column, toLine, toColumn);
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
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

    public boolean diagonalMoves(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {


        // Check that there are no other pieces on the bishop's path
        int deltaLine = line < toLine ? 1 : -1;
        int deltaColumn = column < toColumn ? 1 : -1;
        int i = line + deltaLine;
        int j = column + deltaColumn;
        while ((i != toLine) && (j != toColumn)) {
            if (chessBoard.board[i][j] != null) {
                return false;
            }
            i += deltaLine;
            j += deltaColumn;
        }

        // If all checks pass, the move is valid
        return true;
    }


}
