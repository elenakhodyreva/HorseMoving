package ru.kai.servlets;

import ru.kai.services.PathFinder;
import ru.kai.transfer.TaskAnswer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HorseMoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        if (req.getParameter("width") != null && req.getParameter("height") != null
                && req.getParameter("start") != null && req.getParameter("end") != null) {

            Integer width = Integer.parseInt(req.getParameter("width"));
            Integer height = Integer.parseInt(req.getParameter("height"));

            String start = req.getParameter("start");
            String end = req.getParameter("end");

            int aCode = 65;
            int letter1 = (int) start.charAt(0) - aCode;
            int letter2 = (int) end.charAt(0) - aCode;

            int digit1 = Integer.parseInt(start.substring(1));
            int digit2 = Integer.parseInt(end.substring(1));

            if (letter1 >= width || (digit1 - 1) >= height) {
                writer.write("<h1>start is out of bounds</h1>");
            } else {
                PathFinder pf = new PathFinder();
                TaskAnswer taskAnswer = TaskAnswer.builder()
                        .moveCount(String.valueOf(pf.findPath(width, height, letter1, digit1, letter2, digit2)))
                        .build();
                writer.write("<h1>Moving count=" + taskAnswer.getMoveCount() + "</h1>");
            }
        } else {
            writer.write("<h1>not enough of data</h1>");
        }

    }
}