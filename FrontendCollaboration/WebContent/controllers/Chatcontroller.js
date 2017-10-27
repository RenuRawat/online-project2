

app.controller('ChatController', function($rootScope,$scope,socket){
	alert('entering chat controller')
	$scope.chats=[]; //array of chat message
	$scope.users=[];  //array of usernames
	$scope.stompClient=scoket.stompClient
	
	$scope.$on('sockConnected',function(event,frame){
		alert('sockconnected')
		$scope.userName=$rootScope.currentUser.username
		//newly joined user
		
		$scope.stompClient.subscribe("/app/join/" +$scope.userName, function(message){  //1st controller func call
			//and return users;......func(message)=message.body==get data as string of usernames...then convert into json data
			
			$scope.users=JSON.parse(message.body)  //List of users
			console.log($scope.users)   //[john,james,smith,jack]
			$scope.$apply();
						
			//JSON.stringfiy()// convert json to string format
			//JSON.parse=== convert a string into json format			
		})
		
		$scope.stompClient.subscribe("/topic/join",function(message){
			user=JSON.parse(message.body)  //message.body = james
			// For newly joined user, if statement will not get satisfied and so statement inside
			// if will not get executed.
			if(user !=$scope.userName && $.inArray(user, $scope.users) == -1) {
				$scope.addUser(user);
				$scope.latestUser = user;
				$scope.$apply();
				$('#joinedChat').fadeIn(100).delay(10000).fadeOut(200);
				
			
			}
		})
		
	})
		
		$scope.addUser=function(user){
			$scope.users.push(user);
			$scope.$apply();
		};
		
		
		$scope.capitalize= function(str) {
			return str.charAt(0).toUpperCase() + str.slice(1);
		};
		
		$scope.sendMessage = function(chat){
			chat.from = $scope.userName;
			//chat.from====$scope username add in server{}.....
			
			$scope.stompClient.send("/app/chat", {}, JSON.stringify(chat));
			$rootScope.$broadcast('sendingChat', chat);
			$scope.chat.message = '';
		};
		
		$scope.$on('sockConnected', function(event, frame) {
			$scope.userName = $rootScope.currentUser.username;
			
			$scope.user = $rootScope.currentUser.username;
			//private chat
			$scope.stompClient.subscribe("/queue/chats/" + $scope.userName, function(message){
				console.log("message for" +$scope.userName)
				$scope.processIncomingMessage(message, false);  //broadcast= false
			});
			
			//group chat
			$scope.stompClient.subscribe("/queue/chats", function(message){
				$scope.processIncomingMessage(message, true);  //broadcast = true
			});
			
		});
		// to add chat message to the chat array $scope.chats=
		     //(message==is a object)
		$scope.processIncomingMessage = function(message, broadcast){
			message =JSON.parse(message.body);
			message.direction = 'incoming';
			if(message.from !=$scope.userName){
				$scope.addChat(message);
				$scope.$apply();  //since inside subscribe closure
			}
		};
	
		
		$scope.addChat = function(chat){
			$scope.chats.push(chat);
		};
		
		//for john
		$scope.$on('sendingChat', function(event, sendChat){
			chat = angular.copy(sendChat);
			chat.from = 'Me';
			chat.direction = 'outgoing';
			$scope.addChat(chat);
		});
	
})