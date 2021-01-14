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
//        db.testMethod3("DVSDoGet3", req.getParameterValues("create_new_contact_firstname"));
//
//        if (req.getParameterNames().hasMoreElements()) {
//            db.testMethod("DVSDoGet1HadMore");
//        } else if (req.getParameter("delete_id") != null) {
//            db.testMethod2("DVSDoGet3_deleteid", delete_id);
//            db.executeUpdate("DELETE FROM contact WHERE ID = '" + delete_id + "'");
//        }
//        db.executeUpdate("DELETE FROM contact WHERE ID = '" + delete_id + "'");

        if (req.getParameter("delete_id") != null) {//Delete contact
            db.testMethod3("delete", req.getParameterValues("create_new_contact_firstname"));
            String delete_id = req.getParameter("delete_id");
            db.executeUpdate("DELETE FROM contact WHERE ID = '" + delete_id + "'");
        } else if (req.getParameter("create") != null) {//Create contact
            db.testMethod3("create", req.getParameterValues("create_new_contact_firstname"));
            String id = req.getParameter("create_new_contact_ID");
            String firstname = req.getParameter("create_new_contact_firstname");
            String lastname = req.getParameter("create_new_contact_lastname");
            String email = req.getParameter("create_new_contact_email");
            String sql = "INSERT INTO `contact` (`ID`, `firstname`, `lastname`, `email`) VALUES ('" + id + "', '" + firstname + "', '" + lastname + "', '" + email + "')";
            db.executeUpdate(sql);
        } else if (req.getParameter("edit") != null) {//Edit contact

        }


        RequestDispatcher view = req.getRequestDispatcher("detailViewer.jsp");
        view.forward(req, resp);
    }
}
