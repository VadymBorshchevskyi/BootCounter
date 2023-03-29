package com.example.bootcounter.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.bootcounter.R
import com.example.bootcounter.databinding.BootFragmentBinding
import com.example.bootcounter.ui.viewmodel.BootViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BootFragment : Fragment() {

    private lateinit var binding: BootFragmentBinding
    private val viewModel: BootViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        binding = BootFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.boots
                    .collectLatest { boots ->
                       if (boots.isEmpty()) {
                            binding.bootsCounter.setText(R.string.empty_boots)
                       } else {
                           val text = java.lang.StringBuilder()
                           boots.forEachIndexed { index, timestamp ->
                               text.append(index + 1)
                               text.append(" - ")
                               text.append(timestamp)
                               text.append("\n")
                           }
                           binding.bootsCounter.text = text.toString().trim()
                       }
                    }
            }
        }
    }
}