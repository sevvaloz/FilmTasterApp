package com.ozdamarsevval.upschoolhomework1.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozdamarsevval.upschoolhomework1.R
import com.ozdamarsevval.upschoolhomework1.common.viewBinding
import com.ozdamarsevval.upschoolhomework1.databinding.FragmentThirdBinding
import com.ozdamarsevval.upschoolhomework1.model.EntireInfo
import com.ozdamarsevval.upschoolhomework1.model.FavFilmInfo
import com.ozdamarsevval.upschoolhomework1.model.UserInfo
import com.ozdamarsevval.upschoolhomework1.utils.showToast

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private val binding by viewBinding(FragmentThirdBinding::bind)
    private val args by navArgs<ThirdFragmentArgs>()
    private lateinit var userInfo: UserInfo
    private lateinit var  favFilmInfo: FavFilmInfo
    private lateinit var entireInfo: EntireInfo
    private lateinit var favFilmName: String
    private lateinit var favFilmName2: String
    private lateinit var favFilmName3: String
    private var horrorGenre: Boolean = false
    private var dramaGenre: Boolean = false
    private var romanticGenre: Boolean = false
    private var actionGenre: Boolean = false
    private var scifiGenre: Boolean = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userInfo = args.userInform
        binding.page3NameSurname.text = userInfo.nameSurname

        binding.btnFinish.setOnClickListener {
            favFilmName = binding.edtTxtFilm1.text.toString()
            favFilmName2 = binding.edtTxtFilm2.text.toString()
            favFilmName3 = binding.edtTxtFilm3.text.toString()
            horrorGenre = binding.checkBoxHorror.isChecked
            dramaGenre = binding.checkBoxDrama.isChecked
            romanticGenre = binding.checkBoxRomantic.isChecked
            actionGenre = binding.checkBoxAction.isChecked
            scifiGenre = binding.checkBoxScifi.isChecked

            if(favFilmName.isNotEmpty() && favFilmName2.isNotEmpty() && favFilmName3.isNotEmpty()){
                favFilmInfo = FavFilmInfo(favFilmName, favFilmName2, favFilmName3, horrorGenre, dramaGenre, romanticGenre, actionGenre, scifiGenre)
                entireInfo = EntireInfo(userInfo, favFilmInfo)
                val action = ThirdFragmentDirections.thirdFragmentToResultsFragment(entireInfo)
                findNavController().navigate(action)
            } else{
                showToast(requireContext(),"Make sure you entered everything correctly")
            }


        }
    }

}