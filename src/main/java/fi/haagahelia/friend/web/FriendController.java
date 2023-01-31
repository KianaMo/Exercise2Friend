package fi.haagahelia.friend.web;

import fi.haagahelia.friend.domain.Friend;

import java.util.ArrayList;
import java.util.List;	

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class FriendController {
	public List<Friend> friends = new ArrayList<Friend>();
	
	@GetMapping("/index")
	public String friendForm(Model model) {
		model.addAttribute("friends", friends);
		return  "result";
	}
	
	@PostMapping("/index")
	public String friendSubmit(@ModelAttribute Friend newFriend, Model model) {
		friends.add(newFriend);
		
		model.addAttribute("friends", friends);
		return  "redirect:/index";
	}

}