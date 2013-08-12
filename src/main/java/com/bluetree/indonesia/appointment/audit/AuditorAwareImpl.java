package com.bluetree.indonesia.appointment.audit;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {
	
	@Override
	public String getCurrentAuditor() {
//		Authentication authentication = SecurityContextHolder.getContext().
//				getAuthentication();
//		if (authentication != null) {
//			return authentication.getName();
//		}
		return "SYSTEM";
	}

}
