package top.ychen.springboot.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private static final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/log")
    public String logDemo() {
        log.trace("trace log");
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
        return "Logs have been generated!";
    }
}
