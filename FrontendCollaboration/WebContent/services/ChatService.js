/*
 * ChatService
 * 
 * 
 * SockJS is a javaScript file
 * 
 * frame==properties=(1=command,2=headers,3=body)  */



app.filter('reverse', function() {
	  return function(items) {
	    return items.slice().reverse();
	  };
	});

	app.directive('ngFocus', function() {
	  return function(scope, element, attrs) {
	    element.bind('click', function() {
	      $('.' + attrs.ngFocus)[0].focus();
	    });
	  };
	});

	app.factory('socket', function($rootScope) {
	  alert('app factory')
	    var socket = new SockJS('/RestController/portfolio');
	    var stompClient = Stomp.over(socket);
	    
	  //function(frame)=connect websocket and call a frame...
	    stompClient.connect('', '', function(frame) {
	    	
	    	//after connected websocket then $rootScope call $broadcast function,,,call a frame
	      $rootScope.$broadcast('sockConnected', frame);
	    });

	    return {
	      stompClient: stompClient
	    };
	});

