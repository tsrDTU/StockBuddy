package com.stockbuddy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.stockbuddy.R
import com.stockbuddy.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

        //PUPPYATTACK
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_accountFragment)
        }
        //stocks
        binding.StockBackground1.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground2.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground3.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground4.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground5.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground6.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground7.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground8.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground9.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground10.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground11.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        binding.StockBackground12.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_stockFragment)
        }
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}