package boardgame;

// Classe que representa uma posição no tabuleiro
public class Position {
	// Atributos que representam a linha e a coluna da posição da peça
	private int row;
	private int column;
	
	// Construtor padrão da classe Position
	public Position() {
		
	}
	
	// Construtor recebendo a linha e a coluna da posição
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	// Obtém a linha da posição
	public int getRow() {
		return row;
	}
	
	// Define a linha da posição
	public void setRow(int row) {
		this.row = row;
	}
	
	// Obtém a coluna da posição
	public int getColumn() {
		return column;
	}
	
	// Define a coluna da posição
	public void setColumn(int column) {
		this.column = column;
	}
	
	// Define os valores de linha e coluna da posição
	public void setRowColumnValues(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	// Sobrescreve o método toString para fornecer uma representação textual compreensível da posição
	@Override
	public String toString() {
		return row + ", " + column;
	}
}
