package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.FragmentMainBinding
import com.mmh.knigolyub.utils.transactionOperation


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bubbleBottomBar.addBubbleListener { id ->
            var fragment: Fragment = BooksFragment()
            when (id) {
                R.id.nav_books -> fragment = BooksFragment()
                R.id.nav_progress -> fragment = ProgressFragment()
                R.id.nav_profile -> fragment = ProfileFragment()
                R.id.nav_settings -> fragment = SettingsFragment()
            }
            transactionOperation(fragment)
        }
    }
}