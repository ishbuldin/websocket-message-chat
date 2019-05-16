package ru.ishbuldin.andrei.websocketmessagechat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(path = "/api/all", method = RequestMethod.GET)
    public List<Message> all() {
        return messageRepository.findAll();
    }

    @RequestMapping(path = "/api/{sender}", method = RequestMethod.GET)
    public List<Message> getBySender(@PathVariable String sender) {
        return messageRepository.findBySender(sender);
    }
}
