package com.stungeye.assignmentthree_ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.content.DialogInterface.BUTTON_POSITIVE;

public class ActivityWithWebView extends AppCompatActivity {

    private Button showStaticHTMLButton;
    private Button showWEButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_with_web_view);
        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");


        // Tried to find the buttons when they were inside of a nested layout but couldn't.

        LinearLayout ll = findViewById(R.id.webviewButtons);
        showStaticHTMLButton = ll.findViewById(R.id.staticHTMLButton);
        showWEButton = ll.findViewById(R.id.loadWEButton);


        showStaticHTMLButton = findViewById(R.id.staticHTMLButton);
        showWEButton = findViewById(R.id.loadWEButton);

        showStaticHTMLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Now loading through resource file.
                /*
                String summary = "<html><body><p>This <b>really</b> is static HTML.</p><img src='http://stungeye.com/images/eye.jpg'><input type=\"button\" value=\"Say hello\" onClick=\"showAndroidToast('Hello Android!')\" />\n" +
                        "\n" +
                        "<script type=\"text/javascript\">\n" +
                        "    function showAndroidToast(toast) {\n" +
                        "        Android.showToast(toast);\n" +
                        "    }\n" +
                        "</script></body></html>";
                webView.loadData(summary, "text/html", "UTF-8");*/
                webView.loadUrl("file:///android_asset/index.html");
            }
        });

        showWEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.winnipegelection.ca";

                webView.loadUrl(url);
            }
        });


    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showAlert(String title, String msg) {
            AlertDialog alertDialog = new AlertDialog.Builder(ActivityWithWebView.this).create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(msg);
            alertDialog.setButton( BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            alertDialog.show();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Ensures that we also handle URL loading within the webview and not within the system browser.
            return false;
        }
    }
}
