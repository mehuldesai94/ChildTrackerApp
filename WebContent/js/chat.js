
$(function() {
	var intervalId = setInterval(function() {
		$.ajax({
	        type: 'GET',
	        url: 'http://localhost:8080/ChildTracker/Chat',
	        data: { parentId: $('#parentId').val(), childId: $('#childId').val()},
	        contentType: 'application/json'
	    })
	        .done(function(data) {
	        	console.log("[Log] Successfully retrieved the chat messages.");
	            $('#messages').empty();
	            var message = "";
	            for (var i=0; i<data.length; i++) {
                    message += data[i].sender + ": " + data[i].msg + '\n';
	            }
	            $('#messages').val(message);
	        })
	        .fail(function(err) {
	        	console.log("[Log] Failed to retrieve chat messages");
	        });
	}, 500);
	
	//clearInterval(intervalId);
	
	$("#send").click(function() {
		postMessage();
	});
})