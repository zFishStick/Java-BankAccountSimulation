
public class BankAccount {

	private double b;
	private double intRate;

	public BankAccount(double rate) {
		b = 0;
		intRate = rate;
	}

	public boolean deposit(double a) {
		if (a > 0) {
			b = b + a;
			return true;
		} else {
			return false;
		}
	}

	public boolean withdraw(double a) {
		if (a > b) {
			return false;
		} else {
			b = b - a;
			return true;
		}
	}

	public double computeQuarterlyInterest(double rate, int daysInQuarter) {
		double dailyRate = Math.pow(1 + rate, 1.0 / 365) - 1;
		double i = b * Math.pow(1 + dailyRate, daysInQuarter) - b;

		if (b > 10000) {
			i -= (b * 0.01);
		}

		i = Math.floor(i * 100) / 100.0;

		return i;
	}

	public double applyMaintenanceFee(double monthlyFee, int months) {
        double total = 0;

        if (monthlyFee > 0 && months > 0) {
            for (int k = 0; k < months; k++) {
                total = total + monthlyFee;
            }

            double newB = b - total;
            if (newB >= 0) {
                b = newB;
            } else {
                total = b;
                b = 0;
            }
        }

        return total;
    }

	public double applyPenaltyIfLowBalance() {
		if (b < 100) {
			double penalty = 5 + (100 - b) * 0.02;
			b -= penalty;
			return penalty;
		}
		
		return 0;
	}

	public double adjustBalanceForComplianceCheck(double threshold, double factor) {
		double adjustment = 0;

		if (b < threshold) {
			adjustment = (threshold - b) * factor;
			b += adjustment * 0.1;
		} else {
			adjustment = (b - threshold) * factor * 0.05;
			b -= adjustment;
		}

		return adjustment;
	}

	public boolean applyDormancyPolicy(int monthsInactive, double feeRate) {
		if (monthsInactive < 0 || feeRate < 0) {
			return false;
		}

		double penalty = 0;

		if (monthsInactive > 6) {
			penalty = (monthsInactive - 6) * feeRate;

			if (penalty > b * 0.25) {
				penalty = b * 0.25;
			}

			b -= penalty;
			return true;
		}

		return false;
	}

	public void applyMonthlyInterest(int daysInMonth, boolean isHighB) {
		double baseInt = b * intRate / 100;
		double adjustedInt = baseInt * Math.pow(1 + 0.01, daysInMonth / 30.0);

		if (isHighB && b > 10000) {
			adjustedInt *= 1.05;
		} else if (b < 500) {
			adjustedInt *= 0.95;
		}

		deposit(adjustedInt);
	}


	public void addInterest() {
		double interest = b * intRate / 100;
		deposit(interest);
	}


}