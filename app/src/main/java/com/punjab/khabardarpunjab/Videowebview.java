package com.punjab.khabardarpunjab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.wang.avi.AVLoadingIndicatorView;

public class Videowebview extends AppCompatActivity {
    AVLoadingIndicatorView avi_loader3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_videowebview);

        avi_loader3=findViewById(R.id.avi_loader3);
        final FullScreenVideoView videoView =  findViewById(R.id.videoView);

        videoView.setVideoURI(Uri.parse("http://cdn.smartstream.video/smartstream-us/sfjtv/sfjtv/playlist.m3u8"));
        videoView.requestFocus();



        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
              //  Toast.makeText(getApplicationContext(), "Video over", Toast.LENGTH_SHORT).show();
               // avi_loader3.setVisibility(View.VISIBLE);



            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                avi_loader3.setVisibility(View.GONE);
                videoView.start();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(Videowebview.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                Log.d("API123", "What " + what + " extra " + extra);
                return false;
            }
        });
      /*  WebView webView = (WebView) findViewById(R.id.wv_live);
        webView.setWebViewClient(new myWebClient());
        webView.loadUrl("http://cdn.smartstream.video/smartstream-us/sfjtv/sfjtv/playlist.m3u8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClientCustomPoster());*/

    }

    private class WebChromeClientCustomPoster extends WebChromeClient {

        @Override
        public Bitmap getDefaultVideoPoster() {

            return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        }
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            avi_loader3.setVisibility(View.VISIBLE);

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            avi_loader3.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            avi_loader3.setVisibility(View.GONE);
        }
    }
}
