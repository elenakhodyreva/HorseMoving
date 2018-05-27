package ru.kai.servlets;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class HorseMoveServletTest {

    @Test
    public void oneMoveServletTest() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("width")).thenReturn("8");
        when(request.getParameter("height")).thenReturn("8");
        when(request.getParameter("start")).thenReturn("A1");
        when(request.getParameter("end")).thenReturn("B3");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new HorseMoveServlet().doGet(request,response);
        writer.flush();
        assertTrue(stringWriter.toString().contains("<h1>Moving count=" + 1 + "</h1>"));
    }

    @Test
    public void noMoveServletTest() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("width")).thenReturn("8");
        when(request.getParameter("height")).thenReturn("8");
        when(request.getParameter("start")).thenReturn("A1");
        when(request.getParameter("end")).thenReturn("F50");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new HorseMoveServlet().doGet(request,response);
        writer.flush();
        assertTrue(stringWriter.toString().contains("<h1>Moving count=" + -1 + "</h1>"));
    }

    @Test
    public void notEnoughOfDataServletTest() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new HorseMoveServlet().doGet(request,response);
        writer.flush();
        assertTrue(stringWriter.toString().contains("<h1>недостаточно данных</h1>"));
    }
}