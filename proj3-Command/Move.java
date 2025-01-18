package assignment03;

import static assignment03.BoardColors.NONE;

public class Move implements Command {
	int iccf; // from*100+to
	int undoICCF; // to*100+from
	Board board;
	public Move (Board brd, int i) {
		iccf = i;
		board = brd;
		// COMPUTE THE VALUE OF undoICCF
		// e.g. if iccf is 1759, undoICCF is 5917
		undoICCF = iccf % 100 * 100 + iccf / 100; // Compute undoICCF

		
		
	}

	@Override
	public void execute() {
		int fromICCF = iccf/100;
		int toICCF = iccf%100;
		Piece p = board.getICCF(fromICCF);
		board.setICCF(new Piece(NONE, "--", " ", fromICCF, false));
		p.setPos(toICCF);
		board.setICCF(p);
	}

	@Override
	public void undo() {
		// just reverse the move executed above
		// do the move undoICCF instead of doing the move iccf

		int fromICCF = undoICCF % 100;
		int toICCF = undoICCF / 100;
		Piece p = board.getICCF(toICCF);
		board.setICCF(new Piece(NONE, "--", " ", toICCF, false));
		p.setPos(fromICCF);
		board.setICCF(p);
	}
}
