package com.example.springbootudemy._01_NewApplicationPackage.ResponseExampleHTML;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //This class uses "application-dev.properties" for configuration !

    // Old MVC way of returning html as response
    @RequestMapping("/html-response")
    public String responseHTML(@RequestParam String name, ModelMap modelMap) {
        modelMap.put("name", name);
        logger.debug("Request param is {}", name); // this package logging level is set to debug in "application-dev.properties"
        return "response";
    }
    /* The URL with @RequestParam should look`s like http://localhost:8080/html-response?name=Georgi or any name.
    We always need ModelMap to take a parameter from the URL and map it to the html(view) file.*/
}
