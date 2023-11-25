package com.stockbuddy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.stockbuddy.R
import com.stockbuddy.databinding.FragmentPortfolioBinding
import com.stockbuddy.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PortfolioFragment : Fragment() {

    private var _binding: FragmentPortfolioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPortfolioBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBuysell.setOnClickListener {
            findNavController().navigate(R.id.action_portfolioFragment_to_settingsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
