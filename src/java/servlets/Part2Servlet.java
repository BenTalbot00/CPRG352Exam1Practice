package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Person;

/**
 *
 * @author Ben
 */
public class Part2Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    public double returnAverageAge() throws FileNotFoundException, IOException {
        String listPath = getServletContext().getRealPath("/WEB-INF/list.txt");
        BufferedReader listReader = new BufferedReader(new FileReader(new File(listPath)));
        String currentLine = "";
        double totalAge = 0;
        int totalPeople = 0;
        while ((currentLine = listReader.readLine()) != null) {
            String ageString = currentLine.split(",")[1];
            double age = Double.parseDouble(ageString);
            
            totalAge = totalAge + age;
            totalPeople++;           
        }
        double averageAge = totalAge / totalPeople;
        return averageAge;
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
        HttpSession session = request.getSession();
        double averageAge = this.returnAverageAge();
        session.setAttribute("averageAge", averageAge);
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
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
        String listPath = getServletContext().getRealPath("/WEB-INF/list.txt");
        PrintWriter personWriter = new PrintWriter(new BufferedWriter(new FileWriter(listPath, true)));
        HttpSession session = request.getSession();
        
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
          
        Person addPerson = new Person(name, age);
        
        personWriter.write(addPerson.toString() + "\n");
        personWriter.flush();
        personWriter.close();
        
        double averageAge = this.returnAverageAge();
        session.setAttribute("averageAge", averageAge);
        
        getServletContext().getRequestDispatcher("/WEB-INF/part2.jsp").forward(request, response);
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

}
