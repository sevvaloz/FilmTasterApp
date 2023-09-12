package com.ozdamarsevval.upschoolhomework1.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozdamarsevval.upschoolhomework1.R
import com.ozdamarsevval.upschoolhomework1.common.viewBinding
import com.ozdamarsevval.upschoolhomework1.databinding.FragmentSecondBinding
import com.ozdamarsevval.upschoolhomework1.model.UserInfo
import com.ozdamarsevval.upschoolhomework1.utils.showToast

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)
    private val args by navArgs<SecondFragmentArgs>()
    private lateinit var userNameSurname: String
    private lateinit var userEmail: String
    private lateinit var userPhoneNumber: String
    private lateinit var userInfo: UserInfo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.page2NameSurname.text = args.nameSurname

        binding.btnContinue.setOnClickListener {
            userNameSurname = binding.page2NameSurname.text.toString()
            userEmail = binding.edtTxtEmail.text.toString()
            userPhoneNumber = binding.edtTxtPhoneNumber.text.toString()
            if (userEmail.isNotEmpty() && userPhoneNumber.isNotEmpty()) {
                userInfo = UserInfo(userNameSurname, userEmail, userPhoneNumber)
                val action = SecondFragmentDirections.secondFragmentToThirdFragment(userInfo)
                findNavController().navigate(action)
            } else {
                showToast(requireContext(), "Make sure you entered everything correctly")
            }
        }

    }
}