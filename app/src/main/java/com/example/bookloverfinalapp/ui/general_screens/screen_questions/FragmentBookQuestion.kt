package com.example.bookloverfinalapp.app.ui.general_screens.screen_questions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.bookloverfinalapp.R
import com.example.bookloverfinalapp.app.base.BaseFragment
import com.example.bookloverfinalapp.app.models.BookQuestion
import com.example.bookloverfinalapp.app.models.BookThatRead
import com.example.bookloverfinalapp.app.utils.extensions.*
import com.example.bookloverfinalapp.databinding.FragmentBookQuestionBinding
import com.example.domain.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class FragmentBookQuestion : BaseFragment<FragmentBookQuestionBinding, FragmentBookQuestionViewModel>(FragmentBookQuestionBinding::inflate),
    View.OnClickListener {
    override val viewModel: FragmentBookQuestionViewModel by viewModels()

    private val book: BookThatRead by lazy(LazyThreadSafetyMode.NONE) {
        FragmentBookQuestionArgs.fromBundle(requireArguments()).book
    }
    private val chapter: Int by lazy(LazyThreadSafetyMode.NONE) {
        FragmentBookQuestionArgs.fromBundle(requireArguments()).chapter
    }
    private val path: String by lazy(LazyThreadSafetyMode.NONE) {
        FragmentBookQuestionArgs.fromBundle(requireArguments()).path
    }
    private var index = 0
    private var answer: String = ""
    private var rightAnswer: String? = null
    private var listQuestions = mutableListOf<BookQuestion>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        observeResource()
    }

    private fun setOnClickListeners() {
        binding().apply {
            answerAButton.setOnClickListener(this@FragmentBookQuestion)
            answerBButton.setOnClickListener(this@FragmentBookQuestion)
            answerCButton.setOnClickListener(this@FragmentBookQuestion)
            answerDButton.setOnClickListener(this@FragmentBookQuestion)
            btnNextTest.setOnClickListener(this@FragmentBookQuestion)
            btnPrevTest.setOnClickListener(this@FragmentBookQuestion)
        }
    }

    private fun observeResource() {
        viewModel.getAllChapterQuestions(id = book.bookId, chapter = chapter).onEach { state ->
            when (state.status) {
                Status.LOADING -> loadingDialog.show()
                Status.SUCCESS -> {
                    loadingDialog.dismiss()
                    listQuestions = state.data!!.map { viewModel.mapper.map(it) }.swapElements().toMutableList()
                    setupUi(listQuestions[index])
                }
                Status.ERROR -> {
                    showToast(message = state.message!!)
                    loadingDialog.dismiss()
                }
                Status.EMPTY -> {
                    showToast(message = getString(R.string.no_book_questions))
                    updateObject()
                    loadingDialog.dismiss()
                }
            }
        }.launchWhenStarted(lifecycleScope = lifecycleScope)
    }


    private fun setupUi(bookDomain: BookQuestion) {
        binding().apply {
            restart()
            rightAnswer = bookDomain.rightAnswer
            questionText.text = bookDomain.question
            answerAButton.text = bookDomain.a
            answerBButton.text = bookDomain.b
            answerCButton.text = bookDomain.c
            answerDButton.text = bookDomain.d
        }
    }

    override fun onClick(view: View?) {
        when (view) {
            binding().answerAButton -> answer = "a"
            binding().answerBButton -> answer = "b"
            binding().answerCButton -> answer = "c"
            binding().answerDButton -> answer = "d"
            binding().btnNextTest -> chekAnswer()
            binding().btnPrevTest -> chekPrevQuestion()
        }
    }

    private fun chekAnswer() {
        when {
            answer == "" -> showToast(message = "Выберите ответ")
            rightAnswer == answer -> chekNextQuestion()
            else -> {
                viewModel.goChapterFragment(book = book, path = path)
                showToast(message = getString(R.string.answer_is_error))
            }
        }
    }

    private fun chekPrevQuestion() {
        if (index > 0) {
            index -= 1
            if (index == 0) binding().btnPrevTest.hideView()
            setupUi(bookDomain = listQuestions[index])
        }
    }

    private fun chekNextQuestion() {
        index += 1
        if (index < listQuestions.size) {
            showToast(message = getString(R.string.answer_is_success))
            binding().btnPrevTest.showView()
            setupUi(bookDomain = listQuestions[index])
        } else {
            updateObject()
            showToast(message = getString(R.string.survey_is_success))
        }
    }

    private fun updateObject() {
        val isReadingPages = book.isReadingPages.toMutableList()
        if (chapter < isReadingPages.size) {
            isReadingPages[chapter] = true
            book.isReadingPages = isReadingPages
        }
        viewModel.updateChapters(id = book.objectId, chapters = chapter, isReadingPages = isReadingPages, book = book, path = path)
    }


    private fun restart() {
        binding().apply {
            answer = ""
            answerAButton.isChecked = false
            answerBButton.isChecked = false
            answerCButton.isChecked = false
            answerDButton.isChecked = false
        }
    }

}