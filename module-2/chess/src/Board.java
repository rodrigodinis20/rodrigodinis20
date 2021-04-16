import java.util.ArrayList;

public class Board {

    private Field[][] fields;
    private ArrayList<ChessPiece> whitePieces;
    private ArrayList<ChessPiece> blackPieces;

    public Board(int cols, int rows) {
        fields = new Field[cols][rows];
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
            fields[i][j] = new Field(i, j , this);
            }
        }
    }

    public boolean checkMove(int col, int row) {
        if(fields[col][row].isAvailable()){
            return true;
        }
        for(ChessPiece piece : whitePieces) {
            if (!fields[col][row].isAvailable()) {
                
            }
        }
        return false;
    }

    public ArrayList<ChessPiece> getBlackPieces() {
        return blackPieces;
    }

    public ArrayList<ChessPiece> getWhitePieces() {
        return whitePieces;
    }
}
