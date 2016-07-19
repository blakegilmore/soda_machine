package hello;

/**
 * Created by blakegilmore on 7/13/16.
 */


public class Currency {
        Selection selection = new Selection();

        public void insertMoney(String brand) {
                PaymentService paymentService = new PaymentService();
                String input = selection.captureUserInput("cash or card?");
                if (input.equals("cash")) {
                        paymentService.payWithCash(brand);
                }
                else if (input.equals("card")){
                        paymentService.payWithCard(brand);
                }
                else {
                        System.out.println("Must enter card or cash.");
                }
        }

}