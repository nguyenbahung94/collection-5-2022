package com.example.buildexample82022.testci

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.buildexample82022.databinding.AihWebViewBinding
import kotlinx.android.synthetic.main.aih_web_view.*

class AiHealthWebView : AppCompatActivity() {
    companion object {
        fun open(activity: Activity, url: String?) {
            val intentWebView = Intent(activity, AiHealthWebView::class.java).apply {
                putExtra("url", url)
            }
            activity.startActivity(intentWebView)
        }
    }

    private lateinit var binding: AihWebViewBinding
    private var url = ""
    private var currentUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AihWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setSomeThing()
    }

    private fun setSomeThing() {

        binding.btnGoForward.setOnClickListener {
            if (binding.aihWebView.canGoForward()) {
                aihWebView.goForward()
            }
        }
        binding.btnGoPrevious.setOnClickListener {
            if (binding.aihWebView.canGoBack()) {
                binding.aihWebView.goBack()
            }
        }
        binding.btnReload.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.aihWebView.reload()
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView() {
        val originUrl = intent.getStringExtra("url").toString()
        url =
            if (originUrl.contains("https://") or originUrl.contains("http://")) originUrl else "https://$url"
        binding.progressBar.max = 100
        if (url.isNotBlank()) {
            binding.aihWebView.loadUrl(url)
            binding.aihWebView.settings.javaScriptEnabled = true
            binding.aihWebView.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    binding.progressBar.visibility = View.VISIBLE
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    binding.progressBar.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }
            binding.aihWebView.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    binding.progressBar.progress = newProgress

                }

                override fun onReceivedTitle(view: WebView?, title: String?) {
                    super.onReceivedTitle(view, title)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (binding.aihWebView.canGoBack()) {
            binding.aihWebView.goBack()
        } else {
            finish()
        }
    }
}

class fmaxSize : Fragment() {
    private var _binding: AihWebViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AihWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        event()
    }

    private fun init() {

    }

    private fun event() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun newInstance(): fmaxSize {
        return fmaxSize().apply {
            arguments = Bundle().apply {
            }
        }
    }
}