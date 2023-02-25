package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class ShoppingListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = session != null ? (String)session.getAttribute("username") : null;
        
        if(username != null){
            String action = request.getParameter("action");
            
            if(action.equals("logout")){
                session.invalidate();
            } else {
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp")
                .forward(request, response); 
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            
            if(action.equals("register")) {
                String username = request.getParameter("username");
                ArrayList<String> items = new ArrayList<>();
                session.setAttribute("username", username);
                session.setAttribute("items", items);
            }
            else if(action.equals("add")) {
                String item = request.getParameter("item");
                ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
                items.add(item);
                session.setAttribute("items", items);
            } 
            else if(action.equals("delete")) {
                ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
                for(int i = 0; i < items.size(); i++) {
                    String remove = items.get(i);
                    String checked = request.getParameter(remove);
                    if (remove.equals(checked)) {
                        items.remove(i--);
                    }
                }
                session.setAttribute("items", items);
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp")
                    .forward(request, response);
    }
}
