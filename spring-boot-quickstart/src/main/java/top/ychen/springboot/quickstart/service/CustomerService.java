package top.ychen.springboot.quickstart.service;

import org.springframework.stereotype.Service;
import top.ychen.springboot.quickstart.enums.RequestType;

@Service
public class CustomerService {
    public String handleRequest(RequestType requestType) {
        return switch (requestType) {
            case QUERY -> handleQuery();
            case COMPLAINT -> handleComplaint();
            case SUGGESTIONS -> handleSuggestions();
        };
    }

    private String handleQuery() {
        return "查询请求";
    }
    private String handleComplaint() {
        return "投诉请求";
    }
    private String handleSuggestions() {
        return "建议请求";
    }
}
