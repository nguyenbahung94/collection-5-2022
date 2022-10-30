package com.example.buildexample82022.appfetchlocationbyfiled.ui.venue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buildexample82022.R
import com.example.buildexample82022.appfetchlocationbyfiled.ui.VenuesViewModel
import com.example.buildexample82022.appfetchlocationbyfiled.ui.venue.adapter.VenueAdapter
import com.example.buildexample82022.databinding.FragmentVenuesBinding
import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result
import com.example.buildexample82022.databinding.RetryLayoutBinding
import com.example.buildexample82022.utils.gone
import com.example.buildexample82022.utils.launchAndRepeatWithViewLifecycle
import com.example.buildexample82022.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VenuesFragment:Fragment() {

    private val venuesViewModel: VenuesViewModel by activityViewModels()
    private var _binding: FragmentVenuesBinding? = null
    private val binding get() = _binding!!
    private val mAdapter by lazy { VenueAdapter() }

    private var listLastScrollPosition: Int? = null

    companion object {
        private const val LAST_SCROLL_POSITION_KEY = "LAST_SCROLL_POSITION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listLastScrollPosition = savedInstanceState?.getInt(LAST_SCROLL_POSITION_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVenuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchAndRepeatWithViewLifecycle {
            venuesViewModel.venueScreenState.collect { uiState ->
                handleLoadingState(uiState.loading)
                handleVenueListState(uiState.filteredList)
                handleErrorState(uiState.errorMessage)
            }
        }
        binding.btnCategoryFab.setOnClickListener {
            openCategoriesBottomSheet()
        }

    }


    private fun handleVenueListState(venues: List<Result>) {
        if (venues.isNotEmpty()) {
            binding.venueListRecycler.run {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = mAdapter
                mAdapter.submitList(null)
                mAdapter.submitList(venues)
                listLastScrollPosition?.let { scrollToPosition(it) }
            }
        } else {
            handleErrorState(getString(R.string.message_something_went_wrong_str))
        }
    }


    private fun handleErrorState(errorMessage: String?) {
        errorMessage?.let {
            val retryLayoutBinding = RetryLayoutBinding.bind(binding.root)
            retryLayoutBinding.errorMessageTextView.text = errorMessage
            retryLayoutBinding.retryButton.setOnClickListener {
                venuesViewModel.fetchLocationTriggerVenueRequest()
            }
            binding.retryView.visible()
        } ?: run {
            binding.retryView.gone()
        }
    }

    private fun openCategoriesBottomSheet() {
        val action = VenuesFragmentDirections.actionVenueFragmentToCategoryBottomSheet()
        findNavController().navigate(action)
    }

    private fun handleLoadingState(loading: Boolean) {
        if (loading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        (binding.venueListRecycler.layoutManager as? LinearLayoutManager)?.let {
            outState.putInt(LAST_SCROLL_POSITION_KEY, it.findFirstCompletelyVisibleItemPosition())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}