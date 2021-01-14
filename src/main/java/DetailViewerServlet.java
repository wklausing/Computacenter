import database.DatabaseConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "detailViewerServlet",
        urlPatterns = "/DetailViewer"
)

public class DetailViewerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        DatabaseConnector db = new DatabaseConnector();
//        db.testMethod("DVSDoPost1");

        String delete_id = req.getParameter("delete_id");
        db.executeUpdate("DELETE FROM contact WHERE ID = '" + delete_id + "'");

//        db.testMethod2("DVSDoGet2", delete_id);

        RequestDispatcher view = req.getRequestDispatcher("detailViewer.jsp");
        view.forward(req, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseConnector db = new DatabaseConnector();
//        db.testMethod("DVSDoGet1");

        
        String delete_id = req.getParameter("delete_id");
        db.executeUpdate("DELETE FROM contact WHERE ID = '" + delete_id + "'");

//        db.testMethod2("DVSDoGet2", delete_id);

        RequestDispatcher view = req.getRequestDispatcher("detailViewer.jsp");
        view.forward(req, resp);
    }
}
