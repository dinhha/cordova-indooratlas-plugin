package com.winker.cordovaplugin;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.indooratlas.android.sdk.*;
import com.indooratlas.android.sdk.resources.*;

public class IndoorAtlas extends CordovaPlugin {
		private static final String TAG = "IndoorAtlas";
    private Activity activity;
    private IALocationManager mIALocationManager;
    private IALocationListener mIALocationListener;
    private CallbackContext callback;
    /**
     * Constructor.
     */
    public IndoorAtlas() {
    }

		@Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
      activity = cordova.getActivity();
      callback = callbackContext;

      if (action.equals("init")){
        initIndoorAtlas();
      }
      return true;
    }

    @Override
    public void onStart() {
      activity = cordova.getActivity();
    }

    private void initIndoorAtlas(){      
      mIALocationManager = IALocationManager.create(activity);

       mIALocationListener = new IALocationListener() {
        @Override
        public void onLocationChanged(IALocation location) {
          callback.success("lat: " + location.getLatitude() + "; lng: " + location.getLongitude());
          Log.d(TAG, "Latitude: " + location.getLatitude());
          Log.d(TAG, "Longitude: " + location.getLongitude());
        }
        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }
      };
      activity.runOnUiThread(new Runnable() {
          public void run() {
              callback.success("Ahihi"); // Thread-safe.
          }
      });
    }
}
