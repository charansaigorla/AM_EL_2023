package com.example.kissangenix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class webView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webViewSetup()
    }
    private fun webViewSetup()
    {
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = WebViewClient()
        webview.loadUrl("https://www.google.com/search?q=fertilizer+shop+near+me&sxsrf=ALeKk00DObb0SGhncQ1TZoQu04GEB0roTQ%3A1629078265636&ei=-cIZYcSfJriE4-EP-PWSaA&oq=fertilizers+shop&gs_lcp=Cgdnd3Mtd2l6EAEYADIKCCMQsQIQyQMQJzIFCAAQkgMyBAgAEAoyBAgAEAoyBAgAEAoyBAgAEAoyBAgAEAoyBAgAEAoyBAgAEAoyBAgAEAo6BwgAEEcQsAM6CwgAEOQCELADEIsDOgQIIxAnOgYIABAWEB46BQgAEIAEOgcIABCABBAKOgUIABCRAjoKCAAQgAQQhwIQFDoHCAAQyQMQCkoFCDwSATFKBAhBGAFQ61NY5WpgiHloAXAAeACAAaoCiAHEEpIBBTAuOC40mAEAoAEByAELuAECwAEB&sclient=gws-wiz")
    }

    override fun onBackPressed() {
        if(webview.canGoBack())
            webview.goBack()
        else
        super.onBackPressed()
    }
}