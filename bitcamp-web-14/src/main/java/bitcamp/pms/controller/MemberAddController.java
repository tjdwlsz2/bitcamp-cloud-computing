package bitcamp.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller
public class MemberAddController {
    
    MemberDao memberDao;
    
    public MemberAddController() {}
    
    public MemberAddController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping("/member/add")
    public String add(
            Member momber) throws Exception {
        
        Member member = new Member();
        
        memberDao.insert(member);
        return "redirect:list";
    }
    
    
}









