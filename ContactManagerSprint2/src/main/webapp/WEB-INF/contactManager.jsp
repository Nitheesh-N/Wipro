<%@ page import="java.util.List" %>
<%@ page import="com.manager1.Contact" %>
<%
    List<Contact> contacts = (List<Contact>) application.getAttribute("contacts");
    String error = (String) request.getAttribute("error");
    String message = (String) request.getAttribute("message");
    Contact editContact = (Contact) request.getAttribute("editContact");
    Integer editIndex = (Integer) request.getAttribute("editIndex");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Contact Manager</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        body { padding: 20px; }
        .contact-form { max-width: 500px; }
        .message { margin-top: 10px; }
    </style>
</head>
<body>
<div class="container">
    <h1>Contact Manager</h1>
    <c:if test="${not empty error}">
        <div class="alert alert-danger message"><%= error %></div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="alert alert-success message"><%= message %></div>
    </c:if>
    <!-- Add or Edit Form -->
    <form class="contact-form mb-4" method="post" action="contactManager">
        <input type="hidden" name="action" value="<%= editContact != null ? "edit" : "add" %>"/>
        <% if (editContact != null) { %>
            <input type="hidden" name="index" value="<%= editIndex %>"/>
        <% } %>
        <div class="mb-3">
            <label class="form-label">Name *</label>
            <input type="text" name="name" class="form-control" value="<%= editContact != null ? editContact.getName() : "" %>" required />
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control" value="<%= editContact != null ? editContact.getEmail() : "" %>" />
        </div>
        <div class="mb-3">
            <label class="form-label">Phone</label>
            <input type="text" name="phone" class="form-control" value="<%= editContact != null ? editContact.getPhone() : "" %>" />
        </div>
        <button type="submit" class="btn btn-primary"><%= editContact != null ? "Update Contact" : "Add Contact" %></button>
        <% if (editContact != null) { %>
            <a href="contactManager" class="btn btn-secondary ms-2">Cancel</a>
        <% } %>
    </form>

    <h2 class="mt-4">My Contacts</h2>
    <% if (contacts == null || contacts.isEmpty()) { %>
        <p>No contacts added yet.</p>
    <% } else { %>
        <table class="table table-bordered table-striped">
            <thead class="table-dark"><tr><th>Name</th><th>Email</th><th>Phone</th><th>Actions</th></tr></thead>
            <tbody>
            <% for (int i = 0; i < contacts.size(); i++) {
                Contact c = contacts.get(i); %>
                <tr>
                    <td><%= c.getName() %></td>
                    <td><%= c.getEmail() != null ? c.getEmail() : "-" %></td>
                    <td><%= c.getPhone() != null ? c.getPhone() : "-" %></td>
                    <td style="width: 160px;">
                        <a href="contactManager?action=edit&index=<%= i %>" class="btn btn-warning btn-sm">Edit</a>
                        <form method="post" action="contactManager" style="display:inline;">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="index" value="<%= i %>"/>
                            <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete?');">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    <% } %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
