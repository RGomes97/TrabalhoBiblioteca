package br.com.impacta.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// qual tarefa exatamente
		String tarefa = req.getParameter("tarefa");
		if(tarefa==null){
			throw new IllegalArgumentException("Esqueceu de passar a tarefa");
		}
		
		try {
			String nomeClasse = "br.com.web."+ tarefa;
			Class<?> tipo = Class.forName(nomeClasse);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			// para onde redirecionar
			String pagina = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
			throw new ServletException(e);
		}
	}
}
