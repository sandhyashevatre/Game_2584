package com.learning.hello;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.learning.hello.contoller.Game2584Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/game2584") //
public class GameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Game2584Controller gc;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = JakartaServletWebApplication.buildApplication(getServletContext());
		final WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		gc = new Game2584Controller();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String action = req.getParameter("action");
	    if("Up".equals(action)) {
	    	gc.up();
	    	gc.spawn();
	    	
	    }
	    if("Down".equals(action)) {
	    	gc.down();
	    	gc.spawn();
	    	
	    }
	    if("Left".equals(action)) {
	    	gc.left();
	    	gc.spawn();
	    	
	    }
	    if("Right".equals(action)) {
	    	gc.right();
	    	gc.spawn();
	    	
	    }
	    
	    var out = resp.getWriter();
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    int k = 1;
	    for ( int i = 0; i < gc.board.length; i++ )
        {
            for ( int j = 0; j < gc.board[i].length; j++ )
            {
                String s = gc.board[i][j].toString() + " ";
                System.out.print( s );
                ctx.setVariable("cell"+ k, s);
                k++;
            }
            System.out.println( "" );
	    }
	    ctx.setVariable("score", gc.getScore());
	    templateEngine.process("game2584", ctx, out);
	}
		
		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final IWebExchange webExchange = this.application.buildExchange(req, resp);
		final WebContext ctx = new WebContext(webExchange);
		templateEngine.process("game2584", ctx, resp.getWriter());
	}

}

