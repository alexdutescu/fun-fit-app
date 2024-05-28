package com.jfsd.funfit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jfsd.funfit.model.Batch;
import com.jfsd.funfit.service.BatchService;


/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	BatchService bs = new BatchService();
     public BatchController() {
        super();

    }
     // view purpose 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Batch> listOfBatch = bs.viewAllBatch();

		HttpSession hs = request.getSession();
		hs.setAttribute("batches", listOfBatch);
		
		String flagValue = request.getParameter("flag");
		
		if (flagValue.equals("2")) {
			response.sendRedirect("addParticipants.jsp");
		} else if(flagValue.equals("1")) {
			response.sendRedirect("viewBatches.jsp");
		} else  if(flagValue.equals("3")) {
			String batchid = request.getParameter("batchid");
			bs.deleteBatch(Integer.parseInt(batchid));

			List<Batch> listOfBatch2 = bs.viewAllBatch();
			HttpSession hs2 = request.getSession();
			hs2.setAttribute("batches", listOfBatch2);
			
			response.sendRedirect("viewBatches.jsp");
		} else {
			HttpSession hs3 = request.getSession();
			String batchid = request.getParameter("batchid");
			
			Batch batch = bs.getBatch(Integer.parseInt(batchid));
			System.out.println(batch);
			hs3.setAttribute("batch", batch);
			
			response.sendRedirect("updateBatch.jsp");
		}
	}
	// store or insert 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String typeofbatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");
		
		RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
		
		Batch bb = new Batch();
		bb.setTypeOfBatch(typeofbatch);
		bb.setTime(time);
		
		String result = bs.addBatch(bb);
		pw.println(result);
		rd.include(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// PrintWriter pw = response.getWriter();
		
				
	}
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AAAA");
	}
}
