package com.bluetree.indonesia.appointment.test.audit;

import org.springframework.data.domain.AuditorAware;

public class TestAuditorAwareImpl implements AuditorAware<String> {
	
	@Override
	public String getCurrentAuditor() {
		return "TEST";
	}

}
