package com.santimattius.template.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santimattius.template.databinding.HomeFragmentBinding
import com.santimattius.template.presentation.adapters.HomeAdapter
import com.santimattius.template.presentation.viewmodels.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }

    private lateinit var viewBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = HomeFragmentBinding.inflate(inflater, container, false).apply {
            this.homePictures.layoutManager = LinearLayoutManager(this.homePictures.context)
            this.homePictures.adapter = adapter
        }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, ::onStateChange)
    }

    private fun onStateChange(state: HomeState) {
        when (state) {
            is Data -> {
                loading(visible = false)
            }
            Error -> {
                showError()
            }
            Loading -> {
                loading(visible = true)
            }
        }
    }

    private fun showError() {

    }

    private fun loading(visible: Boolean) = run { viewBinding.homeProgressBar.isVisible = visible }

}