package daily_job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import com.devtech.repository.CouponRepository;

@Configuration
@Scope("singleton")
public class CouponExpirationDailyJob{
	@Autowired
	private CouponRepository couponRepo;
	
	@Transactional
    @Scheduled(cron = "0 0 0 * * *")
	public void deleteExpiredCoupon() {
		couponRepo.deleteExpiredCoupon();
		System.out.println("The process of deleting expired coupon done!");
	}
}