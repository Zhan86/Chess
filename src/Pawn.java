public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        } else if (((this.color.equals("White")) && (line == 1) && (toLine == 3) && (toColumn == column))       // first move
                || ((this.color.equals("Black")) && (line == 6) && (toLine == 4) && (toColumn == column))) {    // first move
            return this.canMoveToPositionCheckColor(chessBoard, line, column, toLine, toColumn);
        } else if (((this.color.equals("White")) && (toLine == (line + 1)) && (toColumn == column))
                || ((this.color.equals("Black")) && (toLine == (line - 1)) && (toColumn == column))) {
            return this.canMoveToPositionCheckColor(chessBoard, line, column, toLine, toColumn);

        } else if (((this.color.equals("White") && (chessBoard.board[toLine][toColumn].getColor().equals("Black"))) // attack
                && (toLine == (line + 1)) && ((toColumn == column + 1)) || (toColumn == column - 1))) {
            return true;
        } else return (this.color.equals("Black") && (chessBoard.board[toLine][toColumn].getColor().equals("White"))) // attack
                && (toLine == (line - 1)) && ((toColumn == column + 1)) || (toColumn == column - 1);

    }


    @Override
    public String getSymbol() {
        return "P";
    }

    public boolean canMoveToPositionFirstCheck(int line, int column, int toLine, int toColumn) {
        if ((toLine < 0) || (toLine > 7) || (toColumn < 0) || (toColumn > 7)) {
            return false;
        } else return (line != toLine) || (column != toColumn);
    }

    public boolean canMoveToPositionCheckColor(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else return false;
    }

}
