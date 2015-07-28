var exec = require('cordova/exec');
function AudioHandler() { console.log("AudioHandler.js: is created");

}
AudioHandler.prototype.muteApp = function(){ 
	console.log("AudioHandler.js: mute"); 
	exec(function(result){ 
	/*alert("OK" + reply);*/ 
	}, function(result){ 
	/*alert("Error" + reply);*/ 
	},"AudioHandler",
	"mute",[]);
} 
AudioHandler.prototype.unmuteApp = function(){ 
	console.log("AudioHandler.js: unmute"); 
	exec(function(result){ 
	/*alert("OK" + reply);*/ 
	}, function(result){ 
	/*alert("Error" + reply);*/ 
	},"AudioHandler",
	"unmute",[]);
} 
var audioHandler = new AudioHandler(); 
module.exports = audioHandler;