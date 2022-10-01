package presentation;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Verification
 */
@WebServlet("/Verification")
public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numero = request.getParameter("num");
		String cin = request.getParameter("cin");
		URL url = new
		URL("http://localhost:8080/concour/bachelier/isInscrits/"+cin+"/"+numero);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "text/plain");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " +conn.getResponseCode());
		}	
		BufferedReader br = new BufferedReader( new InputStreamReader((conn.getInputStream())));
		String output;
	    System.out.println("Output from Server .... \n");
	    while ((output = br.readLine()) != null) {		 
	    	System.out.println(output); 
		 
	    	// VERFICATION SI LE BACHELIER EST INSCRIT  C-A-D S IL EST DEJA ENREGISTRE DANS LA BASE DE DONNEE
	    	if(output.toString().equals("inscrit")) {
	    		url = new	URL("http://localhost:8080/concour/bachelier/isCandidats/"+cin+"/"+numero);
	    		conn = (HttpURLConnection) url.openConnection();
	    		conn.setRequestMethod("GET");
	    		conn.setRequestProperty("Accept", "text/plain");
	    		if (conn.getResponseCode() != 200) {
	    			throw new RuntimeException("Failed : HTTP error code : " +conn.getResponseCode());
	    		}	
	    		br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	    		System.out.println("Output from Server .... \n");
	    		while ((output = br.readLine()) != null) { 
	    			System.out.println(output); 
	
	    			//LE TEST 
	
	    			if(output.toString().equals("Candidat")) {
	    				HttpSession session = request.getSession(true);
						String erreur = "Tu as deja Postuler &#129303;!";
					    String page = "/web.jsp";
						session.setAttribute("erreur", erreur);
						session.setAttribute("page", page);
						getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
					}else{
						url = new URL("http://localhost:8080/concour/bachelier/isaccepter/"+cin+"/"+numero);
				    	conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setRequestProperty("Accept", "text/plain");
						if (conn.getResponseCode() != 200) {
							throw new RuntimeException("Failed : HTTP error code : " +conn.getResponseCode());
						}	
						br = new BufferedReader(
						new InputStreamReader((conn.getInputStream())));
						System.out.println("Output from Server .... \n");
						while ((output = br.readLine()) != null) {
							if(output.toString().equals("accepte")) {
								url = new URL("http://localhost:8080/concour/bachelier/Update/"+cin+"/"+numero);
								conn = (HttpURLConnection) url.openConnection();
								conn.setRequestMethod("GET");
								conn.setRequestProperty("Accept", "text/plain");
								if (conn.getResponseCode() != 200) {
									throw new RuntimeException("Failed : HTTP error code : " +conn.getResponseCode());
								}				
		    					HttpSession session = request.getSession(true);
							    String erreur = "Félicitations, Tu es accepté &#128512; !";
						        String page = "/web.jsp";
						        session.setAttribute("erreur", erreur);
								session.setAttribute("page", page);
								getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
							}else{
								HttpSession session = request.getSession(true);
								String erreur = "Désolé , Tu n’es pas accepté &#128524; !";
								String page = "/web.jsp";
								session.setAttribute("erreur", erreur);
								session.setAttribute("page", page);
								getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
							}							 
						}				 
					} 
				}					 
			}else{
				HttpSession session = request.getSession(true);
				String erreur = "Tu es Non inscrit &#x1F60E; !";
				String page = "/web.jsp";
				session.setAttribute("erreur", erreur);
				session.setAttribute("page", page);
				getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			}	 
		}	
	 }
}


