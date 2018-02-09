package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.model.MapsMainData;
import com.vo.MapsDataVO;

@Controller
public class MapsDataController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dataObject", new MapsDataVO());
		model.addAttribute("message", "Hello Spring MVC 5!");
		return "index";
	}
	
	@RequestMapping(value="/getDetails", method=RequestMethod.POST)
	public ModelAndView getData(Model model, @ModelAttribute("dataObject")MapsDataVO data) {
		RestTemplate restTemplate = new RestTemplate();
		MapsMainData mapsData = restTemplate.getForObject("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" +data.getPlaceType().trim() +"+in+"+data.getCity().trim()+"&key=AIzaSyAIXOVEcrFF2yOwYxAB6ua5h11wBZftPCw", MapsMainData.class);
		if("ZERO_RESULTS".equalsIgnoreCase(mapsData.getStatus()))
			model.addAttribute("noResults", "No Results Found");
		else 
			model.addAttribute("MapData", mapsData.getResults());
		model.addAttribute("dataObject", new MapsDataVO());
		return new ModelAndView("index");
	}
}
