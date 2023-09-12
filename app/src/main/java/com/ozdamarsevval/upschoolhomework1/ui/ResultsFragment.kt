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

        binding.apply {
            txtNameSurnameDynamic.text = entireInfo.userInfo.nameSurname
            txtEmailDynamic.text = entireInfo.userInfo.email
            txtPhoneNumberDynamic.text = entireInfo.userInfo.phoneNumber

            txtFavFilm1Dynamic.text = entireInfo.favFilmInfo.favFilmName
            txtFavFilm2Dynamic.text = entireInfo.favFilmInfo.favFilmName2
            txtFavFilm3Dynamic.text = entireInfo.favFilmInfo.favFilmName3

            checkBoxAction.isChecked = entireInfo.favFilmInfo.actionGenre
            checkBoxDramaDynamic.isChecked = entireInfo.favFilmInfo.dramaGenre
            checkBoxRomantic.isChecked = entireInfo.favFilmInfo.romanticGenre
            checkBoxHorrorDynamic.isChecked = entireInfo.favFilmInfo.horrorGenre
            checkBoxScifiDynamic.isChecked = entireInfo.favFilmInfo.scifiGenre

            btnBackToFirstPage.setOnClickListener {
                val action = ResultsFragmentDirections.resultsFragmentToFirstFragment()
                findNavController().navigate(action)
            }
        }
    }
}