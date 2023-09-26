package application;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.ChessSounds;
import chess.Color;


public class UI {
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_TRANSPARENT = "\u001B[38;2;146;111;79m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[93m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";
	public static final String ANSI_BORDA = "\u001B[1;37m";

	
	public static final String ANSI_GREY_BACKGROUND = "\u001B[100m";
	public static final String ANSI_BROWN_BACKGROUND = "\u001B[48;2;146;111;79m";
	public static final String ANSI_LIGHT_BROWN_BACKGROUND = "\u001B[48;2;198;151;94m";
	public static final String ANSI_LB_BACKGROUND = "\u001B[48;2;125;91;66m";
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_LIGHT_BLUE_BACKGROUND = "\u001B[104m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	private static boolean changeColor;
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static boolean isChangeColor() {
		return changeColor;
	}

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String inputPosition = sc.nextLine();
			char column = inputPosition.charAt(0);
			int row = Integer.parseInt(inputPosition.substring(1));
			return new ChessPosition(column, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
		}
	}
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		if(!chessMatch.getCheckMate()){
			System.out.println("Waiting player " + chessMatch.getCurrentPlayer());
			if(chessMatch.getCheck()) {
				ChessSounds.checkSound();
				System.out.println("CHECK!");
			}
		}
		else {
			ChessSounds.checkMateSound();
			System.out.println("CHECKMATE!");
			System.out.println("WINNER " + chessMatch.getCurrentPlayer());
		}
	}
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				if((i + j) % 2 == 0) {
					changeColor = true;
				}
				else {
					changeColor = false;
				}
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				if((i + j) % 2 == 0) {
					changeColor = true;
				}
				else {
					changeColor = false;
				}
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	private static void printPiece(ChessPiece piece, boolean background) {

		if(isChangeColor()) {
			System.out.print(ANSI_BROWN_BACKGROUND);
		}else {
			System.out.print(ANSI_LIGHT_BROWN_BACKGROUND);
		}
		if (background) {
			System.out.print(ANSI_WHITE_BACKGROUND);
		}
		if(piece == null) {
			System.out.print(ANSI_TRANSPARENT + "  " + ANSI_RESET);
		}
		
		else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_BRIGHT_WHITE + piece + " "+ ANSI_RESET);
			} 
			else {
				System.out.print(ANSI_BLACK+ piece + " " + ANSI_RESET);
			}
		}
		System.out.print("");
	}
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(y -> y.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces:");
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));
		System.out.println(ANSI_RESET);
		
	}
}
