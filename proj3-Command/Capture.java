package assignment03;

import static assignment03.BoardColors.NONE;

public class Capture implements Command {
	int iccf;
	int undoICCF;
	Piece lost;
	Board board;
	public Capture (Board brd, int i) {
		iccf = i;
		board = brd;
		// Compute undoICCF (see Move)

		undoICCF = iccf % 100 * 100 + iccf / 100;
	
	}

	@Override
	public void execute() {
		int fromICCF = iccf/100;
		int toICCF = iccf%100;
		Piece p = board.getICCF(fromICCF);
		board.setICCF(new Piece(NONE, "--", " ", fromICCF, false));
		lost = board.getICCF(toICCF);
		lost.setActive(false);
		p.setPos(toICCF);
		board.setICCF(p);
	}

	@Override
	public void undo() {
		// first reverse the move executed above
		// as is done in Move
		
		// next set lost back to active
		// set its position to its old location
		// set it onto the board.
		
		int fromICCF = undoICCF % 100;
		int toICCF = undoICCF / 100;
		Piece p = board.getICCF(toICCF);
		board.setICCF(new Piece(NONE, "--", " ", toICCF, false));
		lost.setActive(true);
		lost.setPos(toICCF);
		board.setICCF(lost);
		p.setPos(fromICCF);
		board.setICCF(p);
	}
}
