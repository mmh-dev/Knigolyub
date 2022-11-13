package com.example.bookloverfinalapp.app.ui.admin_screens.screen_book_chapters.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bookloverfinalapp.R
import com.example.bookloverfinalapp.app.base.BaseFragment
import com.example.bookloverfinalapp.app.models.Book
import com.example.bookloverfinalapp.app.ui.admin_screens.screen_book_chapters.adapter.AdminChapterAdapter
import com.example.bookloverfinalapp.app.ui.admin_screens.screen_book_chapters.adapter.AdminChapterItemOnClickListener
import com.example.bookloverfinalapp.app.utils.extensions.hideView
import com.example.bookloverfinalapp.app.utils.extensions.setToolbarColor
import com.example.bookloverfinalapp.databinding.FragmentAdminChaptersBinding
import com.github.barteksc.pdfviewer.listener.OnErrorListener
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class FragmentAdminChapters : BaseFragment<FragmentAdminChaptersBinding, FragmentAdminChaptersViewModel>(FragmentAdminChaptersBinding::inflate),
    AdminChapterItemOnClickListener, OnLoadCompleteListener, OnErrorListener, OnPageChangeListener {

    override val viewModel: FragmentAdminChaptersViewModel by viewModels()

    private val book: Book by lazy(LazyThreadSafetyMode.NONE) {
        FragmentAdminChaptersArgs.fromBundle(requireArguments()).book
    }

    private val path: String by lazy(LazyThreadSafetyMode.NONE) {
        FragmentAdminChaptersArgs.fromBundle(requireArguments()).path
    }

    private val adapter: AdminChapterAdapter by lazy(LazyThreadSafetyMode.NONE) {
        AdminChapterAdapter(actionListener = this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        binding().apply {
            pdfView.fromFile(File(path)).onPageChange(this@FragmentAdminChapters).onError(this@FragmentAdminChapters)
                .onLoad(this@FragmentAdminChapters).load()
            toolbar.title = book.title
            setToolbarColor(toolbar = toolbar)
            chapterRecyclerView.adapter = adapter
            toolbar.setNavigationOnClickListener { viewModel.goBack() }

        }
    }

    override fun loadComplete(nbPages: Int) {
        adapter.chapters = binding().pdfView.tableOfContents
    }

    override fun onError(t: Throwable?) {
        viewModel.goBack()
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
    }

    override fun onStart() {
        super.onStart()
        requireActivity().findViewById<BottomNavigationView>(R.id.nav_view).hideView()
    }

    override fun goQuestionFragment(chapter: Int) {
        findNavController().navigate(FragmentAdminChaptersDirections.actionFragmentAdminChaptersToFragmentAllQuestion(id = book.objectId,
            chapter = chapter,
            title = book.title))
    }
}