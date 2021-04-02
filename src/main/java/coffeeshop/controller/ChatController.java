package coffeeshop.controller;

import coffeeshop.entity.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping
public class ChatController {
    
    @RequestMapping(value="/chat", method = RequestMethod.GET)
    public String chat() {
        return "chat";
    }
    
    @RequestMapping(value="/user/chat", method = RequestMethod.GET)
    public String userChat(){
        return "user/user-chat";
    }
    
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
    @MessageMapping("/user/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessageU(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/user/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUserU(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
}
