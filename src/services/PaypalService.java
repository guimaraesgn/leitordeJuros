package services;

public class PaypalService implements OnlinePaymentServices{

	@Override
	public double paymentFree(double amount) {
		
		return amount * 0.02;
	}

	@Override
	public double Interest(double amount, int months) {
		// TODO Auto-generated method stub
		return amount * 0.01 * months;	}
	

}
