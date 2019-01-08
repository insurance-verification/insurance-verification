package com.insurance.verificationsystem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.insurance.verificationsystem.security.TrustedSourceIPFilter;

@Configuration
public class SecurityConfig {

	@Value("${verificationsystem.security.trusted-ip:}")
	private String[] trustedIP;
	@Value("${verificationsystem.security.internal-trusted-ip:}")
	private String[] internalTrustedIP;
	@Value("${verificationsystem.security.external-trusted-ip:}")
	private String[] externalTrustedIP;
	@Value("${verificationsystem.security.ip-blocking:true}")
	private Boolean ipBlocking;

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(trustedSourceIPFilter());
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}

	@Bean
	public TrustedSourceIPFilter trustedSourceIPFilter() {
		return new TrustedSourceIPFilter(ipBlocking, Arrays.asList(trustedIP), Arrays.asList(internalTrustedIP),
				Arrays.asList(externalTrustedIP));
	}

}
