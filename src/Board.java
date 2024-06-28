import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JFrame implements KeyListener {
	private GameLogic gameLogic;
	private int[][] gameArr;
	private JPanel panel;

	public void display() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				JLabel label = new JLabel();
				label.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
				label.setHorizontalAlignment(JLabel.CENTER);
				if (gameArr[r][c] != 0) {
					label.setText(String.valueOf(gameArr[r][c]));
					switch (gameArr[r][c]) {
					case 2:
						label.setBackground(Color.LIGHT_GRAY);
						break;
					case 4:
						label.setBackground(Color.YELLOW);
						break;
					case 8:
						label.setBackground(Color.CYAN);
						break;
					case 16:
						label.setBackground(Color.GREEN);
						break;
					case 32:
						label.setBackground(Color.MAGENTA);
						break;
					case 64:
						label.setBackground(Color.ORANGE);
						break;
					case 128:
						label.setBackground(Color.PINK);
						break;
					}
				}
				label.setOpaque(true);
				panel.add(label);
			}
		}
		addKeyListener(this);
		add(panel);
		setVisible(true);
	}

	/*
	 * generate 2 or 4 randomly and cell with value 0
	 * with 2 having probablity 0.9
	 * with 4 having probablity 0.1
	 */
	public void generateNum() {
		boolean zeroFlag = true;
		while (zeroFlag && canGenerate()) {
			int nR = numLocation();
			int nC = numLocation();
			if (gameArr[nR][nC] == 0) {
				zeroFlag = false;
				gameArr[nR][nC] = Math.random() > 0.1 ? 2 : 4;
			}
		}
	}

	private boolean canGenerate() {
		for (int r = 0; r < gameArr.length; r++) {
			for (int c = 0; c < gameArr.length; c++) {
				if (gameArr[r][c] == 0)
					return true;
			}
		}
		return false;
	}

	public int numLocation() {
		Random r = new Random();
		return r.nextInt(4);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:
			if (gameLogic.canMoveUp(gameArr)) {
				gameArr = gameLogic.makeUpMovement(gameArr);
				generateNum();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (gameLogic.canMoveDown(gameArr)) {
				gameArr = gameLogic.makeDownMovement(gameArr);
				generateNum();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (gameLogic.canMoveRight(gameArr)) {
				gameArr = gameLogic.makeRightMovement(gameArr);
				generateNum();
			}
			break;
		case KeyEvent.VK_LEFT:
			if (gameLogic.canMoveLeft(gameArr)) {
				gameArr = gameLogic.makeLeftMovement(gameArr);
				generateNum();
			}
			break;
		case KeyEvent.VK_X:
			System.exit(0);
			break;
		}
		resetPanel();
		gameEndCondition();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void configFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// GUI title
		String title = "Game 2048";
		setTitle(title);
		setFocusable(true);
		this.setSize(400, 400);
	}

	public void resetPanel() {
		remove(panel);
		removeKeyListener(this);
		display();
	}

	public boolean checkGameOver() {
		return !canGenerate() && !gameLogic.canMoveUp(gameArr) && !gameLogic.canMoveDown(gameArr)
				&& !gameLogic.canMoveRight(gameArr) && !gameLogic.canMoveLeft(gameArr);
	}

	public void gameEndCondition() {
		if (gameLogic.check2048(gameArr)) {
			System.out.println("You win!");
		} else if (checkGameOver()) {
			System.out.println("Game over");
		}
	}

	public void play() {
		gameLogic = new GameLogic();
		gameArr = new int[4][4];
		generateNum();
		generateNum();
		configFrame();
		display();
	}

}
