package com.insurance.verificationsystem.security;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrustedSourceIPFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TrustedSourceIPFilter.class);

    private final List<String> trustedIP;
    private final List<String> internalTrustedIP;
    private final List<String> externalTrustedIP;
    private final Boolean ipBlocking;

    public TrustedSourceIPFilter(Boolean ipBlocking,List<String> trustedIP,List<String> internalTrustedIP,List<String> externalTrustedIP) {
        this.trustedIP = trustedIP;
        this.internalTrustedIP = internalTrustedIP;
        this.externalTrustedIP = externalTrustedIP;
        this.ipBlocking=ipBlocking;
    }
    public TrustedSourceIPFilter(Boolean ipBlocking,String [] trustedIP,String [] internalTrustedIP,String [] externalTrustedIP) {
        this.trustedIP = trustedIP==null?new ArrayList<String>():Arrays.asList(trustedIP);
        this.internalTrustedIP = internalTrustedIP==null?new ArrayList<String>():Arrays.asList(internalTrustedIP);
        this.externalTrustedIP = externalTrustedIP==null?new ArrayList<String>():Arrays.asList(externalTrustedIP);
        this.ipBlocking=ipBlocking;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*if(Boolean.FALSE.equals(ipBlocking)){
            chain.doFilter(request, response);
        }else{*/
            HttpServletRequest httpReq = (HttpServletRequest)request;
            String clientIP = getClientIp((HttpServletRequest)request);
            X509Certificate[] certs = (X509Certificate[]) httpReq.getAttribute("javax.servlet.request.X509Certificate");

            if(verify(clientIP,certs,httpReq.getRequestURI())) {
                //logger.info("Accepted request from IP " + clientIP);
                chain.doFilter(request, response);
            } else {
                logger.error("Rejected request from IP " + clientIP);
                ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        //}
    }

    boolean verify(String clientIP, X509Certificate[] certs, String reqUrl) {
    	// the /manage urls are internalTrustedIPs only
        Optional<String> result = internalTrustedIP.stream().filter(match -> matchOrRegex(match,clientIP)).findAny();
        if (result.isPresent())
            return true;
        else if(reqUrl.toLowerCase().startsWith("/manage") && !reqUrl.startsWith("/manage/health-check")) {
        	return false;
        }
        if(Boolean.FALSE.equals(ipBlocking)) {
        	return true;
        }
        else {
	        Optional<String> resultX = externalTrustedIP.stream().filter(match -> matchOrRegex(match,clientIP)).findAny();
	        if (resultX.isPresent())
	            return true;
	        if (certs != null && certs.length > 0) {
	            Optional<String> result2 = trustedIP.stream().filter(match -> matchOrRegex(match,clientIP)).findAny();
	            return result2.isPresent();
	        }
	        return false;
        }
    }
    
    static boolean matchOrRegex(String pattern, String value){
        return pattern.startsWith("/")?
                Pattern.matches(pattern.substring(1, pattern.length()-1),value)
                :pattern.equals(value);
    }

    private static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
