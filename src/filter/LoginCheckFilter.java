package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.FORWARD }
					, asyncSupported = true, description = "ログインチェックにより分岐", servletNames = { "PlanReserveServlet" })
public abstract class LoginCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//ログイン情報の確認


		//フォワード処理
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
		chain.doFilter(request, response);
	}

}
