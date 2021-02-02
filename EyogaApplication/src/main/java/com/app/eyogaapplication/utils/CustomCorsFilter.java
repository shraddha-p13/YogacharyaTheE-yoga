package com.app.eyogaapplication.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * @purpose to handle CORS related operations.
 * @author bhosarah
 *
 */
@Component
public class CustomCorsFilter implements Filter {

	@Value("${cors.allowed.origins}")
	private String[] corsAllowedOrigins;

	@Value("${cors.allowed.headers}")
	private String corsAllowedHeaders;

	@Value("${cors.allowed.methods}")
	private String corsAllowedMethods;

	@Value("${cors.preflight.maxage}")
    private String corsPreflightMaxage;

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		// unused
	}

	@Override
	public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, corsAllowedOrigins[0]);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, corsAllowedMethods);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, corsAllowedHeaders);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, corsPreflightMaxage);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		// unused
	}
}
