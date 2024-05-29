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
import com.jfsd.funfit.model.Participant;
import com.jfsd.funfit.service.BatchService;
import com.jfsd.funfit.service.ParticipantService;


/**
 * Servlet implementation class ParticipantController
 */
@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final ParticipantService ps;
	private final BatchService bs;

	public ParticipantController() {
		this.ps = new ParticipantService();
		this.bs = new BatchService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String flagValue = request.getParameter("flag");
		
		if (flagValue.equals("1")) {
			List<Participant> listOfParticipants = ps.viewAllParticipants();
			hs.setAttribute("participants", listOfParticipants);
			response.sendRedirect("viewParticipants.jsp");
		} else 
			if (flagValue.equals("2")){
			String participantId = request.getParameter("participantId");
			ps.deleteParticipant(Integer.parseInt(participantId));

			List<Participant> listOfParticipants2 = ps.viewAllParticipants();
			HttpSession hs2 = request.getSession();
			hs2.setAttribute("participants", listOfParticipants2);
			response.sendRedirect("viewParticipants.jsp");
		} else 
			if (flagValue.equals("3")) {
			String participantId = request.getParameter("participantId");
			Participant participant = ps.getParticipant(Integer.parseInt(participantId));
			List<Batch> listOfBatch = bs.viewAllBatch();
			hs.setAttribute("participant", participant);
			hs.setAttribute("batches", listOfBatch);
			response.sendRedirect("updateParticipant.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String participantId = request.getParameter("participantId");
		String fname = request.getParameter("firstName");
		int age = Integer.parseInt(request.getParameter("age"));
		String phoneNumber = request.getParameter("phoneNumber");
		int bid = Integer.parseInt(request.getParameter("batchId"));

		Participant pp = new Participant();
		pp.setFirstName(fname);
		pp.setAge(age);
		pp.setPhoneNumber(phoneNumber);
		pp.setBatchId(bid);

		if(participantId !=  null) {
			pp.setParticipantId(Integer.parseInt(participantId));
			ps.updateParticipant(pp);
			List<Participant> listOfParticipants = ps.viewAllParticipants();
			HttpSession hs = request.getSession();
			hs.setAttribute("participants", listOfParticipants);
			response.sendRedirect("viewParticipants.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
			String result = ps.addParticipant(pp);
			pw.print(result);
			rd.include(request, response);
		}

	}
}
