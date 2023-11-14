package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	// Construtor padrão da classe Board
	public Board() {
		
	}
	
	// Construtor recebendo o número de linhas e colunas do tabuleiro
	public Board(int rows, int columns) { 
		// Verifica se o número de linhas e colunas é válido
		if(rows < 1 || columns < 1) { 
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		// Inicializa a matriz de peças com as dimensões fornecidas
		pieces = new Piece[rows][columns];
	}
	
	// Método para obter o número de linhas do tabuleiro
	public int getRows() {
		return rows;
	}
	
	// Método para obter o número de colunas do tabuleiro
	public int getColumns() {	
		return columns;
	}
	
	// Método para obter a peça em uma posição específica (linha e coluna)
	public Piece piece(int row, int column) {
		// Verifica se a posição está dentro dos limites do tabuleiro
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	// Método para obter a peça em uma posição específica (utilizando objeto Position)
	public Piece piece(Position position) {
		// Verifica se a posição está dentro dos limites do tabuleiro
		if(!positionExists(position.getRow(), position.getColumn())) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Método para colocar uma peça em uma posição específica
	public void placePiece(Piece piece, Position position) {
		// Verifica se já existe uma peça na posição fornecida
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece in that position " + position);
		}
		// Coloca a peça na matriz de peças e define a posição da peça
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	// Método para remover uma peça de uma posição específica
	public Piece removePiece(Position position) {
		// Verifica se a posição está dentro dos limites do tabuleiro
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		// Verifica se não há uma peça na posição fornecida
		if(piece(position) == null) {
			return null;
		}
		// Remove a peça da matriz de peças e limpa a posição da peça
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}

	// Verifica se uma posição (linha e coluna) está dentro dos limites do tabuleiro
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	// Verifica e determina se uma posição (utilizando objeto Position) está dentro dos limites do tabuleiro
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	// Verifica se há uma peça em uma posição específica
	public boolean thereIsAPiece(Position position) {
		// Verifica se a posição está dentro dos limites do tabuleiro
		if(!positionExists(position.getRow(), position.getColumn())) {
			throw new BoardException("Position not on the board");
		}
		// Retorna verdadeiro se houver uma peça na posição, falso caso contrário
		return piece(position) != null;
	}
}
