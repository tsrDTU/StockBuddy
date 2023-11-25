package com.stockbuddy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.stockbuddy.R
import com.stockbuddy.databinding.FragmentTradingBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TradingFragment : Fragment() {

    private var _binding: FragmentTradingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTradingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAcceptPurchaseOne.setOnClickListener {
            findNavController().navigate(R.id.action_tradingFragment_to_historyFragment)//action_FirstFragment_to_SecondFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}