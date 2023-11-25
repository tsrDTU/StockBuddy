package com.stockbuddy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.stockbuddy.R
import com.stockbuddy.databinding.FragmentAccountBinding
import com.stockbuddy.databinding.FragmentFirstBinding
import com.stockbuddy.databinding.FragmentHistoryBinding
import com.stockbuddy.databinding.FragmentSecondBinding
import com.stockbuddy.databinding.FragmentNotificationsBinding
import com.stockbuddy.databinding.FragmentSettingsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.settingbackground1.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_stockFragment)
        }

        //PUPPYATTACK
//        binding.StockBackground1.setOnClickListener {
//            findNavController().navigate(R.id.action_)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}