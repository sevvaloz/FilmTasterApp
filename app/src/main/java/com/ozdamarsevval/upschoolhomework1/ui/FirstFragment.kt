package com.ozdamarsevval.upschoolhomework1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ozdamarsevval.upschoolhomework1.R
import com.ozdamarsevval.upschoolhomework1.common.viewBinding
import com.ozdamarsevval.upschoolhomework1.databinding.FragmentFirstBinding
import com.ozdamarsevval.upschoolhomework1.utils.showToast

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding by viewBinding(FragmentFirstBinding::bind)
    private lateinit var userNameSurname: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            userNameSurname = binding.edtTxtNameSurname.text.toString()
            if (userNameSurname.isNotEmpty()) {
                val action = FirstFragmentDirections.firstFragmentToSecondFragment(userNameSurname)
                findNavController().navigate(action)
            } else {
                showToast(requireContext(), "Make sure you entered everything correctly")
            }
        }
    }

}