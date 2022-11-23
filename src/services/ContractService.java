package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installments;

public class ContractService {
	
	private OnlinePaymentServices onlinePaymentServices;

	public ContractService(OnlinePaymentServices onlinePaymentServices) {
		super();
		this.onlinePaymentServices = onlinePaymentServices;
	}
	public void processContract (Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for (int i = 1; i<= months; i++) {
				LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentServices.Interest(basicQuota, i);
			double fee = onlinePaymentServices.paymentFree(basicQuota + interest);	
			double quota = basicQuota + interest + fee;
			
			contract.getInstalments().add(new Installments(dueDate, quota));
		}
			
		}
	}
	

