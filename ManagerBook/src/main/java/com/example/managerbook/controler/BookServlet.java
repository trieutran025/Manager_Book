package com.example.managerbook.controler;

import com.example.managerbook.bean.Book;
import com.example.managerbook.bean.CardBook;
import com.example.managerbook.bean.Student;
import com.example.managerbook.serrvice.BookCardServiceI;
import com.example.managerbook.serrvice.BookServiceI;
import com.example.managerbook.serrvice.Impl.BookCardServiceImpl;
import com.example.managerbook.serrvice.Impl.BookServiceImpl;
import com.example.managerbook.serrvice.Impl.StudentServiceImpl;
import com.example.managerbook.serrvice.StudentServiceI;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    BookServiceI bookServiceI = new BookServiceImpl();
    BookCardServiceI bookCardServiceI = new BookCardServiceImpl();
    StudentServiceI studentServiceI = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "listBook":
                viewListBook(req, resp);
                break;
            case "list":
                viewList(req, resp);
                break;
            case "muon":
                viewMuon(req, resp);
                break;
            default:
                break;
        }
    }

    private void viewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CardBook> cardBooks = bookCardServiceI.findAllBookCard();
        req.setAttribute("cardBooks", cardBooks);
        req.getRequestDispatcher("/WEB-INF/book/listViewCardBook.jsp").forward(req, resp);
    }

    private void viewMuon(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookServiceI.findByIdBook(id);
        List<Student> students = studentServiceI.findAllStudent();
        req.setAttribute("book", book);
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/book/bookCard.jsp").forward(req, resp);
    }

    private void viewListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookServiceI.findAllBook();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/WEB-INF/book/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "muon":
                doMuon(req, resp);
                break;
            case "delete":
                doDeletes(req,resp);
            default:
                break;
        }
    }

    private void doDeletes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] idRemove = req.getParameterValues("idRemove");
        for (String idR : idRemove) {
            bookCardServiceI.deleteBookCard(Integer.parseInt(idR));
        }
        resp.sendRedirect("/book?action=list");
    }

    private void doMuon(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CardBook cardBook = new CardBook();
        int id_Card = Integer.parseInt(req.getParameter("idCard"));
        int idBook = Integer.parseInt(req.getParameter("idBook"));

        Book book = bookServiceI.findByIdBook(idBook);
        book.setIdBook(idBook);
        int idStudent = Integer.parseInt(req.getParameter("idStudent"));

        Student student = studentServiceI.findByIDStudent(idStudent);
        student.setIdStudent(idStudent);

        String codeCardBook = req.getParameter("codeCard");
        boolean status = true;
        String DateMuon = LocalDate.now().toString();
        String DateTra = req.getParameter("ngayTra");

        cardBook = new CardBook(id_Card, book, student, codeCardBook, status, DateMuon, DateTra);
        bookCardServiceI.add(cardBook);
        resp.sendRedirect("/book?action=list");
    }
}
