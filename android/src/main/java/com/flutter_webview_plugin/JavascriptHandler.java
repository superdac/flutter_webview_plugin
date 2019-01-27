package com.flutter_webview_plugin;

import android.webkit.JavascriptInterface;

import java.util.HashMap;
import java.util.Map;

public class JavascriptHandler {

    private String methodName = "onJavascriptMessage";

    @JavascriptInterface
    public boolean bootstrap() {
        return true;
    }

    @JavascriptInterface
    public void cancel() {
        FlutterWebviewPlugin.channel.invokeMethod(methodName, getMap("cancel", null));
    }

    @JavascriptInterface
    public void finish(String data) {
        FlutterWebviewPlugin.channel.invokeMethod(methodName, getMap("finish", data));
    }

    @JavascriptInterface
    public void popUp() {
        FlutterWebviewPlugin.channel.invokeMethod(methodName, getMap("popup", null));
    }

    private Map<String, Object> getMap(String message, String data) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("data", data);
        return result;
    }
}
