package com.ozdamarsevval.upschoolhomework1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozdamarsevval.upschoolhomework1.R
import com.ozdamarsevval.upschoolhomework1.common.viewBinding
import com.ozdamarsevval.upschoolhomework1.databinding.FragmentResultsBinding
import com.ozdamarsevval.upschoolhomework1.model.EntireInfo


class ResultsFragment : Fragment(R.layout.fragment_results) {

    private val binding by viewBinding(FragmentResultsBinding::bind)
    private val args by navArgs<ResultsFragmentArgs>()
    private lateinit var entireInfo: EntireInfo

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        entireInfo = args.entireInform

        binding.txtNameSurnameDynamic.text = entireInfo.userInfo.nameSurname
        binding.txtEmailDynamic.text = entireInfo.userInfo.email
        binding.txtPhoneNumberDynamic.text = entireInfo.userInfo.phoneNumber

        binding.txtFavFilm1Dynamic.text = entireInfo.favFilmInfo.favFilmName
        binding.txtFavFilm2Dynamic.text = entireInfo.favFilmInfo.favFilmName2
        binding.txtFavFilm3Dynamic.text = entireInfo.favFilmInfo.favFilmName3

        binding.checkBoxAction.isChecked = entireInfo.favFilmInfo.actionGenre
        binding.checkBoxDramaDynamic.isChecked = entireInfo.favFilmInfo.dramaGenre
        binding.checkBoxRomantic.isChecked = entireInfo.favFilmInfo.romanticGenre
        binding.checkBoxHorrorDynamic.isChecked = entireInfo.favFilmInfo.horrorGenre
        binding.checkBoxScifiDynamic.isChecked = entireInfo.favFilmInfo.scifiGenre

        binding.btnBackToFirstPage.setOnClickListener {
            val action = ResultsFragmentDirections.resultsFragmentToFirstFragment()
            findNavController().navigate(action)
        }
    }

}