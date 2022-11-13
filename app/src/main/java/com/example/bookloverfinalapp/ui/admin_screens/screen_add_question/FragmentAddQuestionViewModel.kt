package com.example.bookloverfinalapp.app.ui.admin_screens.screen_add_question

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.bookloverfinalapp.app.base.BaseViewModel
import com.example.bookloverfinalapp.app.models.AddBookQuestion
import com.example.bookloverfinalapp.app.utils.dispatchers.DispatchersProvider
import com.example.domain.Mapper
import com.example.domain.Status
import com.example.domain.interactor.AddNewBookQuestionUseCase
import com.example.domain.models.AddBookQuestionDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class FragmentAddQuestionViewModel @Inject constructor(
    private val addNewBookQuestionUseCase: AddNewBookQuestionUseCase,
    private val dispatchersProvider: DispatchersProvider,
    private val mapper: Mapper<AddBookQuestion, AddBookQuestionDomain>,
) : BaseViewModel() {

    fun addNewQuestionBook(question: AddBookQuestion) = liveData(context = viewModelScope.coroutineContext + dispatchersProvider.io()) {
        addNewBookQuestionUseCase.execute(question = mapper.map(question)).collectLatest { resource ->
                when (resource.status) {
                    Status.LOADING -> showProgressDialog()
                    Status.SUCCESS -> {
                        dismissProgressDialog()
                        emit(Unit)
                    }
                    Status.ERROR -> {
                        dismissProgressDialog()
                        error(message = resource.message!!)
                    }
                }
            }
    }

    fun goBack() = navigateBack()

}