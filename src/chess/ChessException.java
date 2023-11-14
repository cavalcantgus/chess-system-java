package chess;

import boardgame.BoardException;

// Exceção personalizada para erros específicos da partida de xadrez que herda de BoardException
public class ChessException extends BoardException {
	// Número de série para garantir a consistência durante a serialização
	private static final long serialVersionUID = 1L;

	// Construtor que recebe uma mensagem de erro e chama o construtor da superclasse
	public ChessException(String message) {
		super(message);
	}
}
