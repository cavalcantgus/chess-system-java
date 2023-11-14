package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

// Classe abstrata - representa uma peça do jogo de xadrez
public abstract class ChessPiece extends Piece {
	// Atributos de cor da peça e número de movimentos realizados
	private Color color;
	private int moveCount;
	
	// Construtor que recebe o tabuleiro e a cor da peça
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// Obtém a cor da peça
	public Color getColor() {
		return color;
	}
	
	// Incrementa o contador de movimentos
	public void increaseMoveCount() {
		moveCount++;
	}
	
	// Decrementa o contador de movimentos
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	// Obtém o número de movimentos realizados pela peça
	public int getMoveCount() {
		return moveCount;
	}
	
	// Obtém a posição da peça no formato específico (Letra para linha e número para coluna) do xadrez
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);	
	}
	
	// Verifica se há uma peça adversária na posição determinada
	protected boolean isThereOpponentPiece(Position position) {
		// Obtém a peça na posição fornecida
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		// Retorna verdadeiro se houver uma peça na posição e ela for de cor diferente
		return piece != null && piece.getColor() != color;
	}
}
