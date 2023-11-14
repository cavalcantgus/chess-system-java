package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

// Peça do Rei
public class King extends ChessPiece {
	// Atributo da partida de xadrez
	private ChessMatch chessMatch;

	// Construtor que recebe o tabuleiro, a cor e a partida de xadrez
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	// Sobrescreve o método toString para fornecer uma representação textual da peça
	@Override
	public String toString() {
		return "K";
	}

	// Verifica se é possível mover para uma determinada posição
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	// Verifica se o movimento de roque com a torre é possível
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	// Implementação do método que calcula os movimentos possíveis do Rei
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// Movimento para cima
		p.setRowColumnValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para baixo
		p.setRowColumnValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para a esquerda
		p.setRowColumnValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para a direita
		p.setRowColumnValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para o noroeste
		p.setRowColumnValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para o nordeste
		p.setRowColumnValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para o sudoeste
		p.setRowColumnValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento para o sudeste
		p.setRowColumnValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		// Movimento Especial roque
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #MovimentoEspecial roque com a torre do lado do rei
			Position positionR1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(positionR1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					matrix[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// Movimento Especial roque com a torre do lado da rainha
			Position positionR2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(positionR2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					matrix[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
		return matrix;
	}
}
