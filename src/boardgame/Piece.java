package boardgame;

// Classe abstrata - Representa uma peça do jogo
public abstract class Piece {
	// Representa a posição da peça no tabuleiro
	protected Position position;
	// Representa o tabuleiro em que a peça está
	private Board board;

	// Construtor padrão da classe Piece
	public Piece() {
	}

	// Construtor que recebe o tabuleiro - inicializa a posição como nula
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	// Método para obter o tabuleiro
	protected Board getBoard() {
		return board;
	}

	// Método abstrato para calcular os movimentos possíveis da peça
	public abstract boolean[][] possibleMoves();

	// Verificar se um movimento para uma posição específica é possível
	public boolean possibleMove(Position position) {
		// Chama o método possibleMoves e verifica se o movimento para a posição fornecida é permitido
		return possibleMoves()[position.getRow()][position.getColumn()];
	}

	// Verifica se há algum movimento possível para a peça
	public boolean isThereAnyPossibleMove() {
		// Obtém a matriz de movimentos possíveis
		boolean[][] matrix = possibleMoves();
		
		// Itera sobre a matriz e retorna true se houver pelo menos um movimento possível
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]) {
					return true;
				}
			}
		}
		// Se nenhum movimento possível for encontrado, retorna false
		return false;
	}	
}
