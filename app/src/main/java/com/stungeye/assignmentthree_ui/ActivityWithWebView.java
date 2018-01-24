package com.stungeye.assignmentthree_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityWithWebView extends AppCompatActivity {

    private Button showStaticHTMLButton;
    private Button showWEButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_with_web_view);
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new MyWebViewClient());

        // Tried to find the buttons when they were inside of a nested layout but couldn't.
        /*
        LinearLayout ll = findViewById(R.id.webviewButtons);
        showStaticHTMLButton = ll.findViewById(R.id.staticHTMLButton);
        showWEButton = ll.findViewById(R.id.loadWEButton);
        */

        showStaticHTMLButton = findViewById(R.id.staticHTMLButton);
        showWEButton = findViewById(R.id.loadWEButton);

        showStaticHTMLButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String summary = "<html><body><p>This <b>really</b> is static HTML.</p><img src='http://stungeye.com/images/eye.jpg'></body></html>";
                webView.loadData(summary, "text/html", "UTF-8");
            }
        });

        showWEButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.winnipegelection.ca";
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url);
            }
        });


    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Ensures that we also handle URL loading within the webview and not within the system browser.
            return false;
        }
    }
}
