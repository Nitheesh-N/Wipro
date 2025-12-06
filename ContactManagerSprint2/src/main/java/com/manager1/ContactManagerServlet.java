package com.manager1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contactManager")
public class ContactManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("contacts") == null) {
            getServletContext().setAttribute("contacts", new ArrayList<Contact>());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String indexStr = request.getParameter("index");
        List<Contact> contacts = (List<Contact>) getServletContext().getAttribute("contacts");

        // Prepare for edit operation
        if ("edit".equals(action) && indexStr != null) {
            int idx = Integer.parseInt(indexStr);
            if (idx >= 0 && idx < contacts.size()) {
                request.setAttribute("editContact", contacts.get(idx));
                request.setAttribute("editIndex", idx);
            }
        }
        request.getRequestDispatcher("/WEB-INF/contactManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<Contact> contacts = (List<Contact>) getServletContext().getAttribute("contacts");
        String message = null;
        String error = null;

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            if (name == null || name.trim().isEmpty()) {
                error = "Name cannot be blank!";
            } else {
                contacts.add(new Contact(name, email, phone));
                message = "Contact added successfully!";
            }
        } else if ("edit".equals(action)) {
            String indexStr = request.getParameter("index");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int idx = Integer.parseInt(indexStr);
            if (name == null || name.trim().isEmpty()) {
                error = "Name cannot be blank!";
            } else if (idx >= 0 && idx < contacts.size()) {
                contacts.set(idx, new Contact(name, email, phone));
                message = "Contact updated successfully!";
            }
        } else if ("delete".equals(action)) {
            String indexStr = request.getParameter("index");
            int idx = Integer.parseInt(indexStr);
            if (idx < 0 || idx >= contacts.size()) {
                error = "Invalid contact selected for deletion.";
            } else {
                contacts.remove(idx);
                message = "Contact deleted successfully!";
            }
        }

        request.setAttribute("message", message);
        request.setAttribute("error", error);
        doGet(request, response); // Forward back to GET to show updated list
    }
}
