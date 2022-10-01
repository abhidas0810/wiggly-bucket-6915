import java.util.Scanner;

import com.masai.banking.usecases.DepisitUseCase;
import com.masai.banking.usecases.GetAllCustomerUseCase;
import com.masai.banking.usecases.GetCustomerUseCase1;
import com.masai.banking.usecases.LoginAccountantUseCase1;
import com.masai.banking.usecases.LoginCustomerUseCase;
import com.masai.banking.usecases.RegisterCustomerUseCase2;
import com.masai.banking.usecases.RemoveAccountUseCase;
import com.masai.banking.usecases.TransferMoneyUseCase;
import com.masai.banking.usecases.UpdateAlreadyAvailableAccount;
import com.masai.banking.usecases.WithdrawlAmmountUseCase;

public class App {

	public static void main(String[] args) {

		System.out.println("Welcome to Masai Bank");
		System.out.println("========================");
		App app = new App();
		app.selectOption();

	}

	public static void selectOption() {

		try {
			Scanner in = new Scanner(System.in);

			System.out.println("Please select an option");
			System.out.println("++++++++++++++++++++++++++++++++++++");
			System.out.println("Enter 1 For Accountant Login");
			System.out.println("Enter 2 For Customer Login");
			System.out.println("++++++++++++++++++++++++++++++++++++");

			int choice = in.nextInt();

			switch (choice) {
			case 1: {
				LoginAccountantUseCase1 la = new LoginAccountantUseCase1();
				boolean f = la.run();

				if (f) {

					System.out.println("Please select an option");
					System.out.println("++++++++++++++++++++++++++++++++++++");
					System.out.println("Enter 1 To Open New Account");
					System.out.println("Enter 2 To Get Account Details By Account Number");
					System.out.println("Enter 3 To Get All Account Details In Bank");
					System.out.println("Enter 4 To Update Customer Details");
					System.out.println("Enter 5 To Close Account");
					System.out.println("Enter 6 To Withdraw Ammount");
					System.out.println("Enter 7 To Deposit Ammount");
					System.out.println("Enter 8 For Logout");
					System.out.println("++++++++++++++++++++++++++++++++++++");
					int case2 = in.nextInt();
					switch (case2) {
					case 1: {
						RegisterCustomerUseCase2 registerCustomer = new RegisterCustomerUseCase2();
						registerCustomer.run();
						break;
					}
					case 2: {
						GetCustomerUseCase1 gc = new GetCustomerUseCase1();
						gc.run();
						break;
					}
					case 3: {
						GetAllCustomerUseCase gac = new GetAllCustomerUseCase();
						gac.run();
						break;
					}
					case 4: {
						UpdateAlreadyAvailableAccount ae = new UpdateAlreadyAvailableAccount();
						ae.run();
						break;
					}
					case 5: {
						RemoveAccountUseCase ra = new RemoveAccountUseCase();
						ra.run();
						break;
					}
					case 6: {
						WithdrawlAmmountUseCase wa = new WithdrawlAmmountUseCase();
						wa.run();
						break;
					}
					case 7: {
						DepisitUseCase da = new DepisitUseCase();
						da.run();
						break;
					}
					case 8: {
						App app = new App();
						app.selectOption();
						break;
					}
					default:
						break;
					}

				} else {
					App app = new App();
					app.selectOption();
				}

				break;
			}
			case 2: {

				LoginCustomerUseCase lc = new LoginCustomerUseCase();
				boolean f = lc.run();

				if (f) {
					System.out.println("Please select an option");
					System.out.println("++++++++++++++++++++++++++++++++++++");
					System.out.println("Enter 1 For Customer Login");
					System.out.println("Enter 2 For Logout");
					System.out.println("++++++++++++++++++++++++++++++++++++");
					int case3 = in.nextInt();
					switch (case3) {
					case 1:

						TransferMoneyUseCase tm = new TransferMoneyUseCase();
						tm.run();

						break;

					case 2:
						App app = new App();
						app.selectOption();
						break;
					}
				} else {
					App app = new App();
					app.selectOption();
				}
				break;
			}
			default:
				break;
			}

			in.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
}
