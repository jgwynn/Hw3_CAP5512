/**
 * General class containing main program to run the
 * iterated Prisoner's Dilemma (IPD).
 * @author	081028AW
 */
public class RunIPD extends Object
   {
  /**
   * Main program to start IPD program.
   */

   public static void RunIPDFitness(Chromo[] members)
      {
      //int i;
      int maxSteps = 5;

      Strategy player1, player2;
      IteratedPD ipd = null;

//      for (i=0; i<args.length; i++)
//         {
//        /* check parameters */
//         if (args[i].equals("-l") || args[i].equals("-L"))
//            {
//            maxSteps = Integer.parseInt(args[i+1]);
//            System.out.println(" Max steps = " + maxSteps);
//            }  /* if */
//         }  /* for i */
      //Chromo[] members = new Chromo[10];
      for(int i = 0; i<10;i++) {
    	  members[i] = new Chromo();
      }
      
      for(int RED = 0; RED< members.length; RED++) {
    	  player1 = new StrategyTest(members[RED]);
    	  for(int BLUE = RED+1; BLUE< members.length; BLUE++) {
    		  player2 = new StrategyTest(members[BLUE]);
    		  ipd = new IteratedPD(player1, player2);
    		  ipd.runSteps(maxSteps);
    		  members[RED].rawFitness+=ipd.p1Score;
    		  members[BLUE].rawFitness+=ipd.p2Score;
    	  }
      }

      System.out.printf(" Player 1 score = %d\n", ipd.player1Score());
      System.out.printf(" Player 2 score = %d\n", ipd.player2Score());

      }  /* main */
   }  /* class RunIPD */

