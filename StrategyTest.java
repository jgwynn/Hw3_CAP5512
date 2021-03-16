


public class StrategyTest extends Strategy
{
	/**
	 * Encoding for tit-for-tat strategy.
	 */

	public StringBuilder lastFourMoves;
	public Chromo reaction;

	// 0 = defect, 1 = cooperate

	public StrategyTest(Chromo thing)
	{
		name = "Our Strategy";
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~maybe change hardcoded first 4 moves
		lastFourMoves = new StringBuilder();
		lastFourMoves.append("1100");
		this.setReaction(thing);

		// 1010 = 1 our move, 0 opponents move, 
	}  /* StrategyTitForTat */

	public int nextMove()
	{
		double randnum;
		//updates the last moves of our opponent.
		char lastMove = lastFourMoves.charAt(3);
		lastFourMoves.setCharAt(1, lastMove);
		lastFourMoves.setCharAt(3, (char) (this.opponentLastMove + 48));
		//updates the last moves of us
		char ourlastMove = lastFourMoves.charAt(2);
		lastFourMoves.setCharAt(0, lastMove);
		lastFourMoves.setCharAt(2, (char) (this.myLastMove + 48));
		
		
		switch(lastFourMoves.toString()) {
		case "0000": return this.reaction.chromo[0];
		case "0001": return this.reaction.chromo[1];
		case "0010": return this.reaction.chromo[2];
		case "0011": return this.reaction.chromo[3];
		case "0100": return this.reaction.chromo[4];
		case "0101": return this.reaction.chromo[5];
		case "0110": return this.reaction.chromo[6];
		case "0111": return this.reaction.chromo[7];
		case "1000": return this.reaction.chromo[8];
		case "1001": return this.reaction.chromo[9];
		case "1010": return this.reaction.chromo[10];
		case "1011": return this.reaction.chromo[11];
		case "1100": return this.reaction.chromo[12];
		case "1101": return this.reaction.chromo[13];
		case "1110": return this.reaction.chromo[14];
		case "1111": return this.reaction.chromo[15];
		default:
			randnum = Search.r.nextDouble();
			if (randnum > 0.5) return 0;
			else return 1;
		}
	}  /* nextMove */
	
	//public String getLastFourMoves() {return lastFourMoves;}

	//public void setLastFourMoves(String lastFourMoves) {this.lastFourMoves = lastFourMoves;}

	public Chromo getReaction() {return reaction;}
	
	@Override
	public void setReaction(Chromo reaction) {this.reaction = reaction;}
}  /* class StrategyTitForTat */
