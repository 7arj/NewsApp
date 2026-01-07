package com.arjun.newsapp.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arjun.newsapp.databinding.ActivityMainBinding
import com.arjun.newsapp.ui.adapter.NewsAdapter
import com.arjun.newsapp.ui.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe news
        viewModel.news.observe(this) { articles ->
            binding.recyclerView.adapter = NewsAdapter(articles) { article ->
                val intent = android.content.Intent(
                    android.content.Intent.ACTION_VIEW,
                    android.net.Uri.parse(article.url)
                )
                startActivity(intent)
            }
        }


        // Observe loading
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        // Observe error
        viewModel.errorMessage.observe(this) { error ->
            binding.errorText.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.errorText.text = error
        }

        viewModel.fetchNews()
    }
}
