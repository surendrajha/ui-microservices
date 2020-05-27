package com.ms.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UiRestController {
	private Logger log = LoggerFactory.getLogger(UiRestController.class);

	@RequestMapping("/")
	public String welcome() {
		log.info("welcome...");
		return "Welcome to UI Rest Controller..";
	}
}
