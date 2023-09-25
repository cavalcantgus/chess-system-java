package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		if (getColor() == Color.WHITE) {
			p.setRowColumnValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			p.setRowColumnValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			p.setRowColumnValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			p.setRowColumnValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}

			// #Specialmove enPassant white
			if (position.getRow() == 3) {
				Position left_position = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left_position) && isThereOpponentPiece(left_position)
						&& getBoard().piece(left_position) == chessMatch.getEnPassantVulnerable()) {
					matrix[left_position.getRow() - 1][left_position.getColumn()] = true;
				}
			}
			if (position.getRow() == 3) {
				Position right_position = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right_position) && isThereOpponentPiece(right_position)
						&& getBoard().piece(right_position) == chessMatch.getEnPassantVulnerable()) {
					matrix[right_position.getRow() - 1][right_position.getColumn()] = true;
				}
			}
		} else {
			p.setRowColumnValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			p.setRowColumnValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			p.setRowColumnValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			p.setRowColumnValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}

			// #Specialmove enPassant black
			if (position.getRow() == 4) {
				Position left_position = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().positionExists(left_position) && isThereOpponentPiece(left_position)
						&& getBoard().piece(left_position) == chessMatch.getEnPassantVulnerable()) {
					matrix[left_position.getRow() + 1][left_position.getColumn()] = true;
				}
			}
			if (position.getRow() == 3) {
				Position right_position = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().positionExists(right_position) && isThereOpponentPiece(right_position)
						&& getBoard().piece(right_position) == chessMatch.getEnPassantVulnerable()) {
					matrix[right_position.getRow() + 1][right_position.getColumn()] = true;
				}
			}
		}
		return matrix;
	}

	@Override
	public String toString() {
		return "P";
	}

}
