package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mmh.knigolyub.databinding.FragmentReaderBinding
import java.io.File


class ReaderFragment : Fragment() {

    private lateinit var binding: FragmentReaderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val file = File(Environment.getExternalStorageDirectory().path, "new.")

        binding.pdfView.fromAsset("testfile.pdf")
            .fitEachPage(true)
            .pageFling(false)
            .load()
    }
}