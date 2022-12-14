package 섞여있는_계산로직_분리;

import java.time.LocalDate;
import java.time.YearMonth;

public class ServicePeriodCalculator {
	private Order order;
	private LocalDate loginDate;

	public ServicePeriodCalculator(Order order, LocalDate loginDate) {
		this.order = order;
		this.loginDate = loginDate;
	}

	public Main calculate() {
		LocalDate edate = null;
		LocalDate currDate = order.getDate();
		LocalDate nextDate = YearMonth.from(currDate.plusMonths(1)).atDay(1);
		if (order.getGubun().equals("AA")) {
			if (order.getPayType().equals("A") ||
				(order.getPayType().equals("W") && order.getIncludePay().equals("1"))) {
				if (order.getPayMonth().equals("T")) {
					edate = YearMonth.from(currDate).atEndOfMonth();
				} else if (order.getPayMonth().equals("N")) {
					edate = YearMonth.from(currDate).plusMonths(1).atEndOfMonth();
				}
				return new ServicePeriod(currDate, edate);
			} else if (order.getPayType().equals("W") && order.getIncludePay().equals("2")) {
				// ... 생략
			}
		} else {
			if (order.getUnit().equals("D")) {
				edate = loginDate.plusDays(order.getQty());
			} else if (order.getUnit().equals("M")) {
				edate = loginDate.plusMonths(order.getQty());
			}
			return new ServicePeriod(loginDate, edate);
		}
	}
}
