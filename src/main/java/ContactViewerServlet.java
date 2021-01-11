import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(
        name = "contactViewerServlet",
        urlPatterns = "/ContactViewer"
)


public class ContactViewerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map allContacts = getAllContacts();
        req.setAttribute("contacts", allContacts);
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

    private Map getAllContacts () {
        HashMap<String, Contact> contacts = new HashMap <String, Contact>();

        //TODO Just for testing
        for (int i = 1; i <= 3; i++) {
            String id = String.valueOf(i);
            Contact contact = new Contact(id);
            contacts.put(id, contact);
        }

        return contacts;
    }

    @Override
    public void init() throws ServletException {
        String foo = getInitParameter("foo");
        String bar = getServletContext().getInitParameter("bar");
    }
}
