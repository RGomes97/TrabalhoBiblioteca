package br.com.impacta.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.impacta.modelo.Usuario;

@WebFilter("/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String usuario = getUsuario(req);
		String uri = req.getRequestURI();
		System.out.println(usuario+ " acessando a URI "+ uri);
		// chama a proxima requisicao
		chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("logadoComo");
		if(usuario==null) return "<deslogado>";
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
}
