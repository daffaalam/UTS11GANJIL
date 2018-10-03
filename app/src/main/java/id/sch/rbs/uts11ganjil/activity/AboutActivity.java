package id.sch.rbs.uts11ganjil.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        WebView webView = new WebView(this);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadUrl("https://telegra.ph/daffaalam-06-06");
        setContentView(webView);
    }

    class CustomWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            progressDialog.show();
            progressDialog.setMessage("loading...");
            progressDialog.setCancelable(false);
            webview.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            setTitle(view.getTitle());
            progressDialog.dismiss();
            view.setVisibility(View.VISIBLE);
        }
    }
}
