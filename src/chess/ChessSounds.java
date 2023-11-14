package chess;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Classe que contém métodos para reprodução de sons relacionados ao xadrez
public class ChessSounds {
	// Reproduz o som de movimento de peça
	protected static void pieceMoveSound() {
		try {
			// Caminho do arquivo de som de movimento de peça
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\piece_move_sound.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Inicia a reprodução do som e pausa a thread atual para aguardar a conclusão
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Reproduz o som de peça capturada
	protected static void capturedPiece() {
		try {
			// Caminho do arquivo de som de peça capturada
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\captured_piece.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Inicia a reprodução do som e pausa a thread atual para aguardar a conclusão
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Reproduz o som de roque
	protected static void castlingSound() {
		try {
			// Caminho do arquivo de som de roque
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\castling_sound.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Inicia a reprodução do som e pausa a thread atual para aguardar a conclusão
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Reproduz o som de xeque
	public static void checkSound() {
		try {
			// Caminho do arquivo de som de xeque
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\check.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Inicia a reprodução do som e pausa a thread atual para aguardar a conclusão
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Reproduz o som de xeque-mate
	public static void checkMateSound() {
		try {
			// Caminho do arquivo de som de xeque-mate
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\checkmate.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Inicia a reprodução do som e pausa a thread atual para aguardar a conclusão
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Reproduz o som de fim de jogo
	public static void gameOverSound() {
		try {
			// Caminho do arquivo de som de fim de jogo
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\game_over.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Inicia a reprodução do som e pausa a thread atual para aguardar a conclusão
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
