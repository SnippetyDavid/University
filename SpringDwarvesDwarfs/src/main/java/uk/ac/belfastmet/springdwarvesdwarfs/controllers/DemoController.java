package uk.ac.belfastmet.springdwarvesdwarfs.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Demo")
public class DemoController {
	@GetMapping("/")
	public String disney(Model model) {
		return "Hello World!";
	}
	
	@GetMapping("/Waffle")
	public String waffle(Model model) {
		return "WAFFLESSSSSS!!!!!!!!";
	}
	
	@GetMapping("/quickmaths")
	public String quickMaths(Model model) {
		return "Two plus two is four, minus one that's three, quick maths\r\n" + 
				"Everyday man's on the block, smoke trees\r\n" + 
				"See your girl in the park, that girl is a uckers\r\n" + 
				"When the ting went quack-quack-quack, you man were ducking (you man ducked)\r\n" + 
				"Hold tight, Asznee (my brudda), he's got the pumpy (big ting)\r\n" + 
				"Hold tight, my man (my guy), he's got the frisbee\r\n" + 
				"I trap, trap, trap on the phone, movin' that cornflakes\r\n" + 
				"Rice Krispies, hold tight my girl Whitney (my G)\r\n" + 
				"On the road doin' ten toes, like my toes (like my toes)\r\n" + 
				"You man thought I froze, I see a peng girl, then I pose (chilin')\r\n" + 
				"If she ain't on it, I ghost, hah, look at your nose (check your nose, fam)\r\n" + 
				"You donut, nose long like garden hose";
	}
}
