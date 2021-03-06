package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex09/*")
@Log4j
public class Ex09Controller {
	
	@RequestMapping("sub01")
	public String mathod01(RedirectAttributes rttr) {
		log.info("ex09, sub01 method");
		
		rttr.addAttribute("name", "jin");
		rttr.addAttribute("id", 300);
		
		return("redirect:sub02"); // 상대경로 
//		return("redirect:/ex09/sub02"); // 상대경로 
		
	}
	@RequestMapping("sub02")
	public void method02() {
		log.info("ex09, sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03(RedirectAttributes rttr) {
		log.info("ex09, sub03 method");
		
//		rttr.addAttribute("user", new User());
		
		User user = new User();
		user.setAge(3333);
		user.setId("seoul");
		rttr.addFlashAttribute("user", user);
		
		return "redirect:sub04";
	}
	@RequestMapping("/sub04")
	public void method04(Model model) {
		log.info("ex09,sub04 method");
		
		log.info(model.asMap().get("user"));
	}
	

}
