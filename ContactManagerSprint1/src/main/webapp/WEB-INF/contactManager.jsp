<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.management.Contact" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Contact Manager</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body { padding: 20px; }
    </style>
    <script>
        function toggleForm() {
            var form = document.getElementById("addContactForm");
            if (form.style.display === "none" || form.style.display === "") {
                form.style.display = "block";
            } else {
                form.style.display = "none";
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h1>Welcome to Contact Manager</h1>
    <button class="btn btn-primary my-3" onclick="toggleForm()">Add Contact</button>

    <form id="addContactForm" method="post" style="display:none; max-width: 500px;">
        <div class="mb-3">
            <label for="name" class="form-label">Name *</label>
            <input required type="text" class="form-control" id="name" name="name" placeholder="Enter name" />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" />
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter phone number" />
        </div>
        <button type="submit" class="btn btn-success">Save Contact</button>
    </form>

    <h2 class="mt-5">My Contacts</h2>
    <%
        List<Contact> contacts = (List<Contact>) application.getAttribute("contacts");
        if (contacts == null || contacts.isEmpty()) {
    %>
        <p>No contacts added yet.</p>
    <% } else { %>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
            <tr>
                <th>Name</th><th>Email</th><th>Phone</th>
            </tr>
            </thead>
            <tbody>
            <% for (Contact c : contacts) { %>
                <tr>
                    <td><%= c.getName() %></td>
                    <td><%= c.getEmail() != null ? c.getEmail() : "-" %></td>
                    <td><%= c.getPhone() != null ? c.getPhone() : "-" %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    <% } %>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
