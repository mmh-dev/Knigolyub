package com.example.bookloverfinalapp.app.di

import com.example.domain.interactor.*
import com.example.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @Provides
    fun provideGetAllBooksUseCase(repository: BooksRepository): GetAllBooksUseCase = GetAllBooksUseCase(repository = repository)

    @Provides
    fun provideBooksOnRefreshUseCase(repository: BooksRepository): BooksOnRefreshUseCase = BooksOnRefreshUseCase(repository = repository)


    @Provides
    fun provideAddNewBookQuestionUseCase(repository: BooksRepository): AddNewBookQuestionUseCase = AddNewBookQuestionUseCase(repository = repository)

    @Provides
    fun provideGetSimilarBooksUseCase(repository: BooksRepository): GetSimilarBooksUseCase = GetSimilarBooksUseCase(repository = repository)

    @Provides
    fun provideGetSearchBookUseCase(repository: BooksRepository): GetSearchBookUseCase = GetSearchBookUseCase(repository = repository)

    @Provides
    fun provideAddNewBookUseCase(repository: BooksRepository): AddNewBookUseCase = AddNewBookUseCase(repository = repository)

    @Provides
    fun provideDeleteBookQuestionUseCase(repository: BooksRepository): DeleteBookQuestionUseCase = DeleteBookQuestionUseCase(repository = repository)

    @Provides
    fun provideUpdateBookQuestionUseCase(repository: BooksRepository): UpdateBookQuestionUseCase = UpdateBookQuestionUseCase(repository = repository)

    @Provides
    fun provideGetBookForReadingUseCase(repository: BooksRepository): GetBookForReadingUseCase = GetBookForReadingUseCase(repository = repository)

    @Provides
    fun provideGetAllChapterQuestionsUseCase(repository: BooksRepository): GetAllChapterQuestionsUseCase =
        GetAllChapterQuestionsUseCase(repository = repository)

    @Provides
    fun provideDeleteBookUseCase(repository: BooksRepository): DeleteBookUseCase = DeleteBookUseCase(repository = repository)

    @Provides
    fun provideUpdateBookUseCase(repository: BooksRepository): UpdateBookUseCase = UpdateBookUseCase(repository = repository)


    @Provides
    fun provideGetBookThatReadUseCase(repository: BookThatReadRepository): GetBookThatReadUseCase = GetBookThatReadUseCase(repository = repository)

    @Provides
    fun provideGetStudentBooksUseCase(repository: BookThatReadRepository): GetUsersBooksUseCase = GetUsersBooksUseCase(repository = repository)

    @Provides
    fun provideBooksThatReadOnRefreshUseCase(repository: BookThatReadRepository): BooksThatReadOnRefreshUseCase =
        BooksThatReadOnRefreshUseCase(repository = repository)


    @Provides
    fun provideGetMyStudentBooksUseCase(repository: BookThatReadRepository): GetMyStudentBooksUseCase =
        GetMyStudentBooksUseCase(repository = repository)


    @Provides
    fun provideDeleteFromMyBooksUseCase(repository: BookThatReadRepository): DeleteFromMyBooksUseCase =
        DeleteFromMyBooksUseCase(repository = repository)


    @Provides
    fun provideGetMyBookUseCase(repository: BookThatReadRepository): GetMyBookUseCase = GetMyBookUseCase(repository = repository)


    @Provides
    fun provideAddNewStudentBookUseCase(repository: BookThatReadRepository): AddNewBookThatReadUseCase =
        AddNewBookThatReadUseCase(repository = repository)

    @Provides
    fun provideUpdateChaptersUseCase(repository: BookThatReadRepository): UpdateChaptersUseCase = UpdateChaptersUseCase(repository = repository)


    @Provides
    fun provideUpdateProgressUseCase(repository: BookThatReadRepository): UpdateProgressUseCase = UpdateProgressUseCase(repository = repository)

    @Provides
    fun provideGetMyStudentsUseCase(repository: UserRepository): GetMyStudentsUseCase = GetMyStudentsUseCase(repository = repository)

    @Provides
    fun provideDeleteUserUseCase(repository: UserRepository): DeleteUserUseCase = DeleteUserUseCase(repository = repository)

    @Provides
    fun provideAddSessionTokenUseCase(repository: UserRepository): AddSessionTokenUseCase = AddSessionTokenUseCase(repository = repository)

    @Provides
    fun provideGetClassStudentsUseCase(repository: UserRepository): GetClassUsersUseCase = GetClassUsersUseCase(repository = repository)

    @Provides
    fun provideUpdateUserUseCase(repository: UserRepository): UpdateUserUseCase = UpdateUserUseCase(repository = repository)

    @Provides
    fun provideGetSchoolStudentsUseCase(repository: UserRepository): GetSchoolStudentsUseCase = GetSchoolStudentsUseCase(repository = repository)

    @Provides
    fun provideUpdateStudentClassUseCase(repository: UserRepository): UpdateStudentClassUseCase = UpdateStudentClassUseCase(repository = repository)

    @Provides
    fun provideStudentsOnRefreshUseCase(repository: UserRepository): StudentsOnRefreshUseCase = StudentsOnRefreshUseCase(repository = repository)

    @Provides
    fun provideSignUpUseCase(repository: LoginRepository): SignUpUseCase = SignUpUseCase(repository = repository)

    @Provides
    fun provideSignInUseCase(repository: LoginRepository): SignInUseCase = SignInUseCase(repository = repository)

    @Provides
    fun providePasswordResetUseCase(repository: LoginRepository): PasswordResetUseCase = PasswordResetUseCase(repository = repository)

    @Provides
    fun provideGetAllSchoolsUseCase(repository: SchoolRepository): GetAllSchoolsUseCase = GetAllSchoolsUseCase(repository = repository)

    @Provides
    fun provideGetAllClassUseCase(repository: ClassRepository): GetAllClassUseCase = GetAllClassUseCase(repository = repository)

    @Provides
    fun provideDeleteClassUseCase(repository: ClassRepository): DeleteClassUseCase = DeleteClassUseCase(repository = repository)

    @Provides
    fun provideAddNewClassUseCase(repository: ClassRepository): AddNewClassUseCase = AddNewClassUseCase(repository = repository)

    @Provides
    fun provideGetAllClassesCloudUseCase(repository: ClassRepository): GetAllClassesCloudUseCase = GetAllClassesCloudUseCase(repository = repository)


}