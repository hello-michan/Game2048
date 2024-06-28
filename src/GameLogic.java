import java.util.ArrayList;

public class GameLogic {
	ArrayList<Integer> checkRow;
	ArrayList<Integer> checkCol;

	/*
	 * this method is called when key is up
	 */
	public int[][] makeUpMovement(int[][] arr) {
		for (int c = 0; c < arr.length; c++) {
			checkRow = new ArrayList<Integer>();
			for (int r = 0; r < arr.length - 1; r++) {
				if (arr[r][c] != 0) {
					if (arr[r + 1][c] == 0) {
						arr = checkUp(moveDown(arr, r, c), r, c);
					} else if (arr[r + 1][c] == arr[r][c] && !checkRow.contains(r)) {
						arr = checkUp(combineDown(arr, r, c), r, c);
						checkRow.add(r + 1);
					}

				}
			}
		}
		for (int c = 0; c < arr.length; c++) {
			for (int r = arr.length - 1; r > 0; r--) {
				if (arr[r][c] != 0) {
					if (arr[r - 1][c] == 0) {
						arr = checkDown(moveUp(arr, r, c), r, c);
					}
				}
			}
		}
		return arr;
	}

	//check below cell for up key
	int[][] checkDown(int[][] arr, int r, int c) {
		if (r + 1 < arr.length) {
			if (arr[r + 1][c] != 0) {
				arr = moveUp(arr, r + 1, c);
			}
		}
		if (r + 2 < arr.length) {
			if (arr[r + 2][c] != 0) {
				arr = moveUp(arr, r + 2, c);
			}
		}
		return arr;
	}

	//movement method for up key
	private int[][] moveUp(int[][] arr, int r, int c) {
		arr[r - 1][c] = arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	//combine method for up key
	private int[][] combineUp(int[][] arr, int r, int c) {
		arr[r - 1][c] += arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	public boolean canMoveUp(int[][] arr) {
		for (int c = 0; c < arr.length; c++) {
			for (int r = arr.length - 1; r > 0; r--) {
				if (arr[r][c] != 0) {
					if (arr[r - 1][c] == 0) {
						return true;
					} else if (arr[r - 1][c] == arr[r][c]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * this method is called when key is down
	 */
	public int[][] makeDownMovement(int[][] arr) {
		for (int c = 0; c < arr.length; c++) {
			checkRow = new ArrayList<Integer>();
			for (int r = arr.length - 1; r > 0; r--) {
				if (arr[r][c] != 0) {
					if (arr[r - 1][c] == 0) {
						arr = checkDown(moveUp(arr, r, c), r, c);
					} else if (arr[r - 1][c] == arr[r][c] && !checkRow.contains(r)) {
						arr = checkDown(combineUp(arr, r, c), r, c);
						checkRow.add(r - 1);
					}
				}
			}
		}
		for (int c = 0; c < arr.length; c++) {
			for (int r = 0; r < arr.length - 1; r++) {
				if (arr[r][c] != 0) {
					if (arr[r + 1][c] == 0) {
						arr = checkUp(moveDown(arr, r, c), r, c);
					}

				}
			}
		}
		return arr;
	}

	//check upper cell method for down key
	private int[][] checkUp(int[][] arr, int r, int c) {
		if (r - 1 >= 0) {
			if (arr[r - 1][c] != 0) {
				arr = moveDown(arr, r - 1, c);
			}
		}
		if (r - 2 >= 0) {
			if (arr[r - 2][c] != 0) {
				arr = moveDown(arr, r - 2, c);
			}
		}
		return arr;
	}

	//movement method for down key
	private int[][] moveDown(int[][] arr, int r, int c) {
		arr[r + 1][c] = arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	//combine method for down key
	private int[][] combineDown(int[][] arr, int r, int c) {
		arr[r + 1][c] += arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	public boolean canMoveDown(int[][] arr) {
		for (int c = 0; c < arr.length; c++) {
			for (int r = 0; r < arr.length - 1; r++) {
				if (arr[r][c] != 0) {
					if (arr[r + 1][c] == 0) {
						return true;
					} else if (arr[r + 1][c] == arr[r][c]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * this method is called when right key
	 */
	public int[][] makeRightMovement(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			checkCol = new ArrayList<Integer>();
			for (int c = arr.length - 1; c > 0; c--) {
				if (arr[r][c] != 0) {
					if (arr[r][c - 1] == 0) {
						arr = checkRight(moveLeft(arr, r, c), r, c);
					} else if (arr[r][c - 1] == arr[r][c] && !checkCol.contains(c)) {
						arr = checkRight(combineLeft(arr, r, c), r, c);
						checkCol.add(c - 1);
					}
				}
			}
		}
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length - 1; c++) {
				if (arr[r][c] != 0) {
					if (arr[r][c + 1] == 0) {
						arr = checkLeft(moveRight(arr, r, c), r, c);
					}
				}
			}
		}
		return arr;
	}

	//check upper cell method for right key
	private int[][] checkLeft(int[][] arr, int r, int c) {
		if (c - 1 >= 0) {
			if (arr[r][c - 1] != 0) {
				arr = moveRight(arr, r, c - 1);
			}
		}
		if (c - 2 >= 0) {
			if (arr[r][c - 2] != 0) {
				arr = moveRight(arr, r, c - 2);
			}
		}
		return arr;
	}

	//movement method for right key
	private int[][] moveRight(int[][] arr, int r, int c) {
		arr[r][c + 1] = arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	//combine method for right key
	private int[][] combineRight(int[][] arr, int r, int c) {
		arr[r][c + 1] += arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	public boolean canMoveRight(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length - 1; c++) {
				if (arr[r][c] != 0) {
					if (arr[r][c + 1] == 0) {
						return true;
					} else if (arr[r][c + 1] == arr[r][c]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/*
	 * this method is called when left key
	 */
	public int[][] makeLeftMovement(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			checkCol = new ArrayList<Integer>();
			for (int c = 0; c < arr[0].length - 1; c++) {
				if (arr[r][c] != 0) {
					if (arr[r][c + 1] == 0) {
						arr = checkLeft(moveRight(arr, r, c), r, c);
					} else if (arr[r][c + 1] == arr[r][c] && !checkCol.contains(c)) {
						arr = checkLeft(combineRight(arr, r, c), r, c);
						checkCol.add(c + 1);
					}
				}
			}
		}
		for (int r = 0; r < arr.length; r++) {
			for (int c = arr[0].length - 1; c > 0; c--) {
				if (arr[r][c] != 0) {
					if (arr[r][c - 1] == 0) {
						arr = checkRight(moveLeft(arr, r, c), r, c);
					}
				}
			}
		}
		return arr;
	}

	//check upper cell method for left key
	private int[][] checkRight(int[][] arr, int r, int c) {
		if (c + 1 < arr[0].length) {
			if (arr[r][c + 1] != 0) {
				arr = moveLeft(arr, r, c + 1);
			}
		}
		if (c + 2 < arr[0].length) {
			if (arr[r][c + 2] != 0) {
				arr = moveLeft(arr, r, c + 2);
			}
		}
		return arr;
	}

	//movement method for left key
	private int[][] moveLeft(int[][] arr, int r, int c) {
		arr[r][c - 1] = arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	//combine method for right key
	private int[][] combineLeft(int[][] arr, int r, int c) {
		arr[r][c - 1] += arr[r][c];
		arr[r][c] = 0;
		return arr;
	}

	public boolean canMoveLeft(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = arr.length - 1; c > 0; c--) {
				if (arr[r][c] != 0) {
					if (arr[r][c - 1] == 0) {
						return true;
					} else if (arr[r][c - 1] == arr[r][c]) {
						arr = checkRight(combineLeft(arr, r, c), r, c);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean check2048(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				if (arr[r][c] == 2048)
					return true;
			}
		}
		return false;
	}
}
