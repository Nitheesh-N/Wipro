package com.management;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contactManager")
public class ContactManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Collection to hold contacts (stored in ServletContext)
    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("contacts") == null) {
            getServletContext().setAttribute("contacts", new ArrayList<Contact>());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to JSP page to show welcome & form
        request.getRequestDispatcher("/WEB-INF/contactManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get contact info from form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Simple validation (could be extended)
        if (name != null && !name.isEmpty()) {
            Contact contact = new Contact(name, email, phone);
            @SuppressWarnings("unchecked")
			List<Contact> contacts = (List<Contact>) getServletContext().getAttribute("contacts");
            contacts.add(contact);
        }

        // After adding redirect back to GET
        response.sendRedirect("contactManager");
    }
}
