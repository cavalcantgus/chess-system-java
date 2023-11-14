package boardgame;

// Classe de exceção personalizada para lidar com erros relacionados ao tabuleiro
public class BoardException extends RuntimeException {
	// Número de série para garantir a consistência durante a serialização
	private static final long serialVersionUID = 1L;

	// Construtor recebendo uma mensagem de erro
	public BoardException(String message) {
		// Chama o construtor da superclasse (RuntimeException) com a mensagem fornecida
		super(message);
	}
}
