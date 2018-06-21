package bigcookingdata_engine.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.sun.javafx.collections.ArrayListenerHelper;

import bigcookingdata_engine.business.data.recipe.Ingredient;
import bigcookingdata_engine.business.data.recipe.Recipe;
import bigcookingdata_engine.business.engine.Session;
import bigcookingdata_engine.database.Neo4J;

/**
 * Servlet implementation class ServletFrigo
 */
@WebServlet("/ServletFrigo")
public class ServletFrigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Ingredient> listIngredFrigo = new ArrayList<>();
		try {
			String userMail = Session.getInstance().getUser().getMail();
			listIngredFrigo = Neo4J.getIngreFromFridge(userMail);
		} catch (JSONException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listIngred", listIngredFrigo);
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
