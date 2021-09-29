package com.mmh.knigolyub.ui.fragments

import android.os.Bundle
import android.os.Environment
import android.view.*
import androidx.fragment.app.Fragment
import com.github.barteksc.pdfviewer.PDFView
import com.mmh.knigolyub.R
import com.mmh.knigolyub.databinding.FragmentReaderBinding
import com.mmh.knigolyub.ui.dialogs.AboutDocDialog
import com.mmh.knigolyub.utils.transactionOperation
import java.io.File


class ReaderFragment : Fragment() {

    private lateinit var binding: FragmentReaderBinding
    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.reader_dot_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.dot_search -> {
                transactionOperation(AboutDocDialog())
            }
            R.id.dot_one_page -> {
                pdfView.isFitEachPage
            }
            R.id.dot_night_mode -> {
                pdfView.setNightMode(true)
            }
            R.id.dot_fullScreen -> {
                pdfView.pageFillsScreen()
            }
            R.id.dot_help -> {

            }
            R.id.dot_about -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

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

        pdfView = binding.pdfView
        pdfView.fromAsset("testfile.pdf")
            .pageFling(false)
            .load()
    }
}