package com.ms.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class UiConfig {

	private static final Logger log = LoggerFactory.getLogger(UiConfig.class);

	@Value("${data.from.file}")
	private String filePath;

	@Value("${data.from.config_map}")
	private String configValue;

	@Value("${key1}")
	private String key1;

	@Value("${key2}")
	private String key2;

	@Autowired
	private ResourceLoader resourceLoader;

	@PostConstruct
	public void postConstruct() {
		log.info("inside Post Config :: filePath:{}, configValue:{}", filePath, configValue);
		readFile();
	}

	private void readFile() {
		log.info("reading file...key1:{}, key2:{}", key1, key2);

		SAXBuilder builder = new SAXBuilder();
		try {
			// File xmlFile = ResourceUtils.getFile(filePath);
			File xmlFile = resourceLoader.getResource(filePath).getFile();

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("staff");

			for (int i = 0; i < list.size(); i++) {
				Element node = (Element) list.get(i);
				log.info("First Name:{}, Last Name:{}, Nick Name:{}, Salary:{}", node.getChildText("firstname"),
						node.getChildText("lastname"), node.getChildText("nickname"), node.getChildText("salary"));
			}
		} catch (IOException io) {
			log.error("IOException ", io);
		} catch (JDOMException jdomex) {
			log.error("JDOMException ", jdomex);
		} catch (Exception e) {
			log.error("Exception ", e);
		}

	}
}
