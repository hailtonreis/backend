package config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.classmate.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SimpleCorsFilter implements Filter {

public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
	    response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
	    response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    chain.doFilter(req, res);
}

@Override
public boolean include(Object element) {
	// TODO Auto-generated method stub
	return false;
}

}
