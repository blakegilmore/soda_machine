package hello;

/**
 * Created by blakegilmore on 7/13/16.
 */


public class Currency {
        public enum CurrencyChoice {
                CASH, CARD
        }

        Currency currency;

        public Currency(Currency currency) {
                this.currency = currency;
        }

        public void insertMoney() {

                switch (currency) {
                        case CurrencyChoice.CARD:
                                System.out.println("Mondays are bad.");
                                break;

                        case CurrencyChoice.CASH:
                                System.out.println("Fridays are better.");
                                break;

                        default:
                                System.out.println("Midweek days are so-so.");
                                break;
                }
                return;
        }
}