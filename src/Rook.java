public class Rook extends ChessPiece {
    public Rook(String color) {
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
        } else if ((line == toLine) || (column == toColumn)) {
            return this.canMoveToPositionCheckColor(chessBoard, line, column, toLine, toColumn) && this.straightMoves(chessBoard, line, column, toLine, toColumn);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
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

    public boolean straightMoves(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine) {
            // The rook is moving horizontally
            int deltaColumn = column < toColumn ? 1 : -1;
            int j = column + deltaColumn;
            while (j != toColumn) {
                if (chessBoard.board[line][column] != null) {
                    return false;
                }
                j += deltaColumn;
            }
        } else {
            // The rook is moving vertically
            int deltaLine = line < toLine ? 1 : -1;
            int i = line + deltaLine;
            while (i != toLine) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
                i += deltaLine;
            }
        }

        // If all checks pass, the move is valid
        return true;


    }
}

