package 섞여있는_계산로직_분리;

import java.time.LocalDate;
import java.time.YearMonth;

public class Main {

	public void provideServicePeriod(Long ordNo, LocalDate loginDate) {
		// period, order 구하고 검사하는 코드 생략
		ServicePeriod period = new ServicePeriodCalculator(order, loginDate).calculate();
		updatePeriod(period, period.getSdate(), period.getEdate());
	}
}
