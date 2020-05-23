package com.mm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UiRestController {

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to UI Rest Controller..";
	}
}
