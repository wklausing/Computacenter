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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("detailViewer.jsp");
        view.forward(req, resp);
//        DatabaseConnector db = new DatabaseConnector();
//        db.deleteContact("3");
//
//        System.out.println("Ich bin hier");
//        String[] action = req.getParameterValues("action");
//        if (action[1].equals("delete")) {
//            String id = action[1];
//            DatabaseConnector db = new DatabaseConnector();
//            db.deleteContact("3");
//        } else {
//            RequestDispatcher view = req.getRequestDispatcher("detailViewer.jsp");
//            view.forward(req, resp);
//        }
//
//        String id = action[1];
//        DatabaseConnector db = new DatabaseConnector();
//        db.deleteContact("3");
    }
}
