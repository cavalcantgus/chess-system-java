package chess;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ChessSounds {
	protected static void pieceMoveSound() {
		try {
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\piece_move_sound.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected static void capturedPiece() {
		try {
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\captured_piece.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected static void castlingSound() {
		try {
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\castling_sound.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void checkSound() {
		try {
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\check.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void checkMateSound() {
		try {
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\checkmate.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void gameOverSound() {
		try {
			File soundFile = new File("C:\\Temp\\ws-eclipse\\ChessSystem\\chess-sounds\\game_over.wav");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
