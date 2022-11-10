package com.example.bookloverfinalapp.app.di

import com.example.data.ResourceProvider
import com.example.data.cache.models.BookCache
import com.example.data.cache.models.BookThatReadCache
import com.example.data.cache.models.ClassCache
import com.example.data.cache.models.UserCache
import com.example.data.cache.source.BooksCacheDataSource
import com.example.data.cache.source.BooksThatReadDataSource
import com.example.data.cache.source.ClassCacheDataSource
import com.example.data.cache.source.UsersCacheDataSource
import com.example.data.cloud.models.AddNewBookThatReadCloud
import com.example.data.cloud.models.SignUpAnswerCloud
import com.example.data.cloud.models.UserCloud
import com.example.data.cloud.service.LoginService
import com.example.data.cloud.service.SchoolService
import com.example.data.cloud.source.BooksCloudDataSource
import com.example.data.cloud.source.BooksThatReadCloudDataSource
import com.example.data.cloud.source.ClassCloudDataSource
import com.example.data.cloud.source.UsersCloudDataSource
import com.example.data.models.*
import com.example.data.repository.*
import com.example.domain.Mapper
import com.example.domain.models.*
import com.example.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        service: LoginService,
        signInMapper: Mapper<UserCloud, UserDomain>,
        signUpMapper: Mapper<SignUpAnswerCloud, PostRequestAnswerDomain>,
        resourceProvider: ResourceProvider,
    ): LoginRepository =
        LoginRepositoryImpl(service = service, signInMapper = signInMapper, signUpMapper = signUpMapper, resourceProvider = resourceProvider)


    @Provides
    @Singleton
    fun provideBooksRepository(
        resourceProvider: ResourceProvider,
        cloudDataSource: BooksCloudDataSource,
        cacheDataSource: BooksCacheDataSource,
        bookCashMapper: Mapper<BookCache, BookData>,
        addBookDomainMapper: Mapper<AddNewBookDomain, AddNewBookData>,
        bookDomainMapper: Mapper<BookData, BookDomain>,
        updateBookDomainMapper: Mapper<UpdateBookDomain, UpdateBookData>,
        questionsMapper: Mapper<BookQuestionData, BookQuestionDomain>,
        questionsDomainMapper: Mapper<AddBookQuestionDomain, AddBookQuestionData>,
    ): BooksRepository = BooksRepositoryImpl(resourceProvider = resourceProvider,
        cloudDataSource = cloudDataSource,
        cacheDataSource = cacheDataSource,
        bookCashMapper = bookCashMapper,
        bookDomainMapper = bookDomainMapper,
        questionsMapper = questionsMapper,
        questionsDomainMapper = questionsDomainMapper,
        addBookDomainMapper = addBookDomainMapper,
        updateBookDomainMapper = updateBookDomainMapper)

    @Provides
    @Singleton
    fun provideSchoolRepository(
        service: SchoolService,
        resourceProvider: ResourceProvider,
    ): SchoolRepository = SchoolRepositoryImpl(service = service, resourceProvider = resourceProvider)


    @Provides
    @Singleton
    fun provideUserRepository(
        cloudDataSource: UsersCloudDataSource,
        cacheDataSource: UsersCacheDataSource,
        studentDomainMapper: Mapper<StudentData, StudentDomain>,
        userCloudMapper: Mapper<UserCloud, UserDomain>,
        userCacheMapper: Mapper<UserCache, StudentData>,
    ): UserRepository = UserRepositoryImpl(cloudDataSource = cloudDataSource,
        cacheDataSource = cacheDataSource,
        studentDomainMapper = studentDomainMapper,
        userCloudMapper = userCloudMapper,
        userCacheMapper = userCacheMapper)


    @Provides
    @Singleton
    fun provideBookThatReadRepository(
        cloudDataSource: BooksThatReadCloudDataSource,
        cacheDataSource: BooksThatReadDataSource,
        bookCashMapper: Mapper<BookThatReadCache, BookThatReadData>,
        bookDomainMapper: Mapper<BookThatReadData, BookThatReadDomain>,
        addNewBookMapper: Mapper<AddNewBookThatReadDomain, AddNewBookThatReadCloud>,
    ): BookThatReadRepository = BookThatReadRepositoryImpl(cloudDataSource = cloudDataSource,
        cacheDataSource = cacheDataSource,
        bookCashMapper = bookCashMapper,
        bookDomainMapper = bookDomainMapper,
        addNewBookMapper = addNewBookMapper)

    @Provides
    @Singleton
    fun provideClassRepository(
        cloudDataSource: ClassCloudDataSource,
        cacheDataSource: ClassCacheDataSource,
        classMapper: Mapper<ClassData, ClassDomain>,
        classCashMapper: Mapper<ClassCache, ClassData>,
    ): ClassRepository = ClassRepositoryImpl(cloudDataSource = cloudDataSource,
        cacheDataSource = cacheDataSource,
        classMapper = classMapper,
        classCashMapper = classCashMapper)


}