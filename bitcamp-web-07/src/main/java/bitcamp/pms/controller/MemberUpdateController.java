package bitcamp.pms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberUpdateController implements PageController {
    
    MemberDao memberDao;
    
    public MemberUpdateController(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }


    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            Member member = new Member();
            member.setId(request.getParameter("id"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            
            if (memberDao.update(member) == 0) {
                return "/member/updatefail.jsp";
            } else {
                return "redirect:list";
            }
        }
    
    
}









