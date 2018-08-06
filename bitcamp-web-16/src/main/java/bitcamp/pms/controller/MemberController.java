package bitcamp.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
//    @Autowired MemberDao memberDao;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(defaultValue="1") int page, 
            @RequestParam(defaultValue="3") int size,
            Model model) throws Exception {
        
        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;
        
        List<Member> list = memberService.list(page, size);
        
        model.addAttribute("list", list);
        model.addAttribute("page", page); // 변수 값을 담음
        model.addAttribute("size", size);
        model.addAttribute("totalPage",
                memberService.getTotalPage(size));
        
        return "member/list";
    }
    
    @GetMapping(value="form")
    public void form() {
    }
    
    @PostMapping(value="add")
    public String add(Member member) throws Exception {
        
//        memberDao.insert(member);
        memberService.add(member);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(String id) throws Exception {
        
//        memberDao.delete(id);
        memberService.delete(id);
        return "redirect:list";
       
    }
    
    @RequestMapping("update")
    public String update(Member member) throws Exception {
        
//        if (memberDao.update(member) == 0) {
        if (memberService.update(member) == 0) {
            return "member/updatefail";
        } else {
            return "redirect:list";
        }
    }
    
    @RequestMapping("view/{id}")
    public String view(
            @PathVariable String id,
            Model model) throws Exception {
        
//        Member member = memberDao.selectOne(id);
        Member member = memberService.get(id);
        model.addAttribute("member", member);
        return "member/view";
    }
    

}










