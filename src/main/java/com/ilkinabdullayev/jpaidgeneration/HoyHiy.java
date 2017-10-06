/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpaidgeneration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author ilkinabdullayev
 */
@WebServlet(name = "HoyHiy", urlPatterns = {"/HoyHiy"})
public class HoyHiy extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Resource
    private UserTransaction ut;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        for (int i = 1; i <= 111; i++) {
            Person p = new Person();
            p.setName("qaz" + i);
            create(p);
        }

        for (int i = 1; i <= 111; i++) {
            Employee t = new Employee();
            t.setEmpName("qaz" + i);
            t.setEmpSalary(23);
            create(t);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HoyHiy</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HoyHiy at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void create(Person p) {
        try {
            ut.begin();
            em.persist(p);
            ut.commit();
        } catch (Exception ex) {
            try {
                ut.rollback();
                Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex1) {
                Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void create(Employee t) {
        try {
            ut.begin();
            em.persist(t);
            ut.commit();
        } catch (Exception ex) {
            try {
                ut.rollback();
                Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex1) {
                Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}
