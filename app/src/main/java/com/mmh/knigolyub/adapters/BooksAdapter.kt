package com.mmh.knigolyub.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mmh.knigolyub.databinding.BooksItemBinding
import com.mmh.knigolyub.entities.Book

class BooksAdapter : ListAdapter<Book, BooksAdapter.BooksViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding = BooksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val currentBook = getItem(position)
        holder.bind(currentBook)
    }

    class BooksViewHolder(private val binding: BooksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.apply {
                bookTitle.text = book.title
                bookAuthor.text = book.author
                publishedYear.text = book.publishYear
                bookPages.text = book.numberOfPages
                book.progress?.let { bookProgress.setProgress(it.toInt()) }
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book) =
            oldItem == newItem

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Book, newItem: Book) =
            oldItem == newItem
    }
}