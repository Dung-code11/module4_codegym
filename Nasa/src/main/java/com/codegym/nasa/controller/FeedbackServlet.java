package com.codegym.nasa.controller;



import com.codegym.nasa.DAO.FeedbackDAO;
import com.codegym.nasa.model.Feedback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private FeedbackDAO dao = new FeedbackDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("add".equals(action)) {
            Feedback fb = new Feedback();
            fb.setName(req.getParameter("name"));
            fb.setComment(req.getParameter("comment"));
            fb.setRating(Integer.parseInt(req.getParameter("rating")));
            fb.setCreatedDate(LocalDate.now());
            fb.setLikes(0);

            dao.save(fb);
        } else if ("like".equals(action)) {
            Long id = Long.parseLong(req.getParameter("id"));
            dao.like(id);
        }

        resp.sendRedirect("index.jsp");
    }
}
