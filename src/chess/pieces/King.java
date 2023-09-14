package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	public King(Board board, Color color) {
		super(board, color);
	}
	@Override
	public String toString() {
		return "K";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		int count = 1;
		// above
		p.setRowColumnValues(position.getRow() - 1, position.getColumn());
		while(count < 2) {
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
				p.setRow(p.getRow() - 1);
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			count++;
		}
		// left 
		count = 1;
		p.setRowColumnValues(position.getRow(), position.getColumn() - 1);
		while(count < 2) {
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() - 1);
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			count++;
		}
		count = 1;
		p.setRowColumnValues(position.getRow(), position.getColumn() + 1);
		while(count < 2) {
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
				p.setColumn(p.getColumn() + 1);
			}
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			count++;
		}
		return matrix;
	}
}
