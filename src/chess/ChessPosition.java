package chess;

import boardgame.Position;

// Classe que representa a posição de uma peça no xadrez
public class ChessPosition {
	// Atributos de coluna (letra) e a linha (número) da posição no xadrez
	private char column;
	private int row;

	// Construtor que recebe a coluna e a linha da posição no formato do xadrez
	public ChessPosition(char column, int row) {
		// Verifica se os valores fornecidos são válidos para uma posição de xadrez
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			// Lança uma exceção se os valores não forem válidos
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	// Obtém a coluna da posição
	public char getColumn() {
		return column;
	}

	// Obtém a linha da posição
	public int getRow() {
		return row;
	}

	// Converte a posição de xadrez para a posição na matriz do tabuleiro
	protected Position toPosition() {
		// Calcula a linha e a coluna da matriz com base nos valores de coluna e linha do xadrez
		int matrixRow = 8 - row;
		int matrixColumn = column - 'a';
		// Retorna um objeto Position com os valores calculados
		return new Position(matrixRow, matrixColumn);
	}

	// Cria uma ChessPosition a partir de uma Position
	protected static ChessPosition fromPosition(Position position) {
		// Cria e retorna uma nova ChessPosition com base nos valores da Position
		return new ChessPosition((char)('a' + position.getColumn()), (8 - position.getRow()));
	}

	// Sobrescreve o método toString para fornecer uma representação textual da ChessPosition
	@Override
	public String toString() {
		return "" + column + row;
	}
}
