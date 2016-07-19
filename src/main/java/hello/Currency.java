package hello;

/**
 * Created by blakegilmore on 7/13/16.
 */


public class Currency {
        Selection selection = new Selection();

        public void insertMoney() {
                String input = selection.captureUserInput("cash or card?");
                if (input.equals("cash")) {
                        System.out.println("Mondays are bad.");
                }
                else if (input.equals("card")){
                        System.out.println("Fridays are better.");
                }
                else {
                        System.out.println("Must enter card or cash.");
                }
                return;
        }

}