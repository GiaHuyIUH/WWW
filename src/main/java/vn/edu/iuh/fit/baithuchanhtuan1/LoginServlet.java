package vn.edu.iuh.fit.baithuchanhtuan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.baithuchanhtuan1.beans.ConnectDB;
import vn.edu.iuh.fit.baithuchanhtuan1.beans.LoginBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "loginServlet", value = "/loginPage")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object us = req.getParameter("us");
        Object pw = req.getParameter("pw");


        LoginBean bean = new LoginBean();

        int result = bean.loginValidation(us.toString(), pw.toString());
        if (result == 1) {

            resp.sendRedirect("loginSuccess.jsp?us=" + us);
        } else if (result == 0) {
            resp.sendRedirect("loginFail.jsp?status=1");
        } else {
            resp.sendRedirect("loginFail.jsp?status=2");
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = ConnectDB.getConnection()) {
            if (conn != null) {
                out.println("<h1>Database connection successful!</h1>");
            } else {
                out.println("<h1>Failed to connect to the database.</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h1>Database connection problem: " + e.getMessage() + "</h1>");
        }


    }
}
