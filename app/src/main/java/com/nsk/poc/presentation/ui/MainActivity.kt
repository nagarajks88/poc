package com.nsk.poc.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsk.poc.data.util.Resource
import com.nsk.poc.databinding.ActivityMainBinding
import com.nsk.poc.presentation.adapter.FactsAdapter
import com.nsk.poc.presentation.viewmodel.FactsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val factsViewModel: FactsViewModel by viewModels()
    @Inject
    lateinit var factsAdapter: FactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        loadFacts()

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            loadFacts()
        }

    }

    private fun loadFacts() {
        factsViewModel.getFacts()
        factsViewModel.liveData.observe(this, {
                response ->
            when(response) {
                is Resource.Success ->{
                    hideProgressBar()
                    binding.noDataTextView.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    response.data?.let {
                        setToolBarTitle(response.data?.title)
                        factsAdapter.differ.submitList(it.rows.toList())
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }

                is Resource.Error -> {
                    hideProgressBar()
                    binding.noDataTextView.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        })
    }

    private fun setToolBarTitle(title: String) {
        setTitle(title)
    }

    private fun initRecyclerView() {

        binding.recyclerView.apply {
            adapter = factsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }
}