package com.collaborate.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.collaborate.Model.Chat;

@Controller
public class SockController {
	
	private List<String> users=new ArrayList<String>();   // to add users - list of username

@Autowired
private SimpMessagingTemplate messagingTemplate;


//$stomClient.subscribe("app/join/"+$scope.user, function(message){})
@SubscribeMapping("/join/{username}")
public List<String> join(@DestinationVariable("username") String username){
	if(!users.contains(username))
		users.add(username); //adding a newly joined username to the list
	
	messagingTemplate.convertAndSend("/topic/join", username);  //to all other users in chatroom
	
	// in frontend  $stompClient.subscribe("/topic/join",function(message) {} )
	return users; //to newly joined user
}


//$stomClient.send("app/chat")
@MessageMapping(value="/chat")
public void chatRecevied(Chat chat) {
	if("all".equals(chat.getTo())) {  //group chat
		messagingTemplate.convertAndSend("/queue/chats", chat);
	}
	else
	{
		messagingTemplate.convertAndSend("/queue/chats/" +chat.getFrom(),chat);
		messagingTemplate.convertAndSend("/queue/chats/" +chat.getTo(),chat);
	}
	
}


}
