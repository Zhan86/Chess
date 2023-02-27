public class King extends ChessPiece {
    public King(String color) {
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
        } else if (((Math.abs(toLine - line) == Math.abs(toColumn - column)) && (Math.abs(toColumn - column) == 1)) || (((line == toLine) && (Math.abs(toColumn - column) == 1)) || (column == toColumn) && (Math.abs(toLine - line) == 1))) {
            return this.canMoveToPositionCheckColor(chessBoard, line, column, toLine, toColumn);}
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean canMoveToPositionFirstCheck(int line, int column, int toLine, int toColumn) {
        if ((toLine < 0) || (toLine > 7) || (toColumn < 0) || (toColumn > 7)) {
            return false;
        } else return (line != toLine) || (column != toColumn);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (line <= 7 && line >= 0 && column <= 7 && column >= 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board.board[i][j] != null) {
                        if (board.board[i][j].canMoveToPosition(board, i, j, line, column) && (!board.board[i][j].getColor().equals(this.color))) {
                            return true;

                        }
                    }
                }
            }
        }
        return false;

    }

    public boolean canMoveToPositionCheckColor(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else

            return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
    }
}


