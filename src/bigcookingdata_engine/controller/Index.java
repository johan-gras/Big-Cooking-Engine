package bigcookingdata_engine.controller;

import bigcookingdata_engine.business.engine.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Index")
public class Index extends HttpServlet {
    public Index() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Session.getInstance().isConnected())
            request.getRequestDispatcher("index.jsp").forward(request, response);
        else
            response.sendRedirect("LoginServlet");
    }
}
