package control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Form;
import model.User;

@WebFilter("/faces/restricted/*")
public class AuthorizationFilter implements Filter {
	 Map<String,String> url=new HashMap<String, String>();
	 

	 
	 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {    
       	url.put("statestic","/formm/faces/restricted/forms/FormStatestic.xhtml");
	  
	    url.put("viewSubmissions","/formm/faces/restricted/forms/viewSubmissions.xhtml");
	    url.put("display","/formm/faces/restricted/forms/display.xhtml");
	   
    	System.out.println("start filter");
    	HttpServletRequest req = (HttpServletRequest) request;
    	System.out.println("form_id"+req.getParameter("form_id"));
      Login   login = (Login) req.getSession().getAttribute("login");
     

System.out.println("spot 1");

   
   
if (login!=null&&login.isStatus()) {
	
	 chain.doFilter(request, response);
      	
     
      }
else {
          // User is not logged in, so redirect to index.
    	 
    	
    	  
    		  String redirectUrl = 	req.getRequestURI()+"?faces-redirect=true";
    	    	String parameter=req.getParameter("form_id");
    	    	if(parameter!=null){
    	    		redirectUrl=	redirectUrl+"&form_id="+parameter;
    	    	}
    	    	 req.getSession().setAttribute("redirectUrl", redirectUrl);
    	  
    	
          HttpServletResponse res = (HttpServletResponse) response;
          System.out.println(req.getContextPath() + "/faces/login.xhtml");
          res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
      }
    }
	@Override
	public void destroy() {
		System.out.println("destroyed");
		
	}

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init filter");
	

	}

    // You need to override init() and destroy() as well, but they can be kept empty.
}