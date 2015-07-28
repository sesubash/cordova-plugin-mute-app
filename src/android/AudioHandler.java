import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import android.content.Context;
import android.media.AudioManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class AudioHandler extends CordovaPlugin {
public static final String TAG = "Mute App Plugin";
/**
* Constructor.
*/
public AudioHandler() {}
	/**
	* Sets the context of the Command. This can then be used to do things like
	* get file paths associated with the Activity.
	*
	* @param cordova The context of the main Activity.
	* @param webView The CordovaWebView Cordova is running in.
	*/
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		Log.v(TAG,"Init Plugin");
	}
	public boolean execute(final String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		// final int duration = Toast.LENGTH_SHORT;
		// // Shows a toast
		// Log.v(TAG,"CordovaPlugin received:"+ action);
		// cordova.getActivity().runOnUiThread(new Runnable() {
		// public void run() {
		// Toast toast = Toast.makeText(cordova.getActivity().getApplicationContext(), action, duration);
		// 	toast.show();
		// 	}
		// });
		// return true;
		if (action.equals("mute")) {
	      mute();
	      return true;
	    }else if (action.equals("unmute")) {
	      unmute();
	      return true;
	    }

	    return false;
	}

	private void mute(){
		//mute audio
		AudioManager amanager = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);;
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        amanager.setStreamMute(AudioManager.STREAM_RING, true);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
	}

	private void unmute(){
		//unmute audio
		AudioManager amanager = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);;
        amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
        amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        amanager.setStreamMute(AudioManager.STREAM_RING, false);
        amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
	}
}