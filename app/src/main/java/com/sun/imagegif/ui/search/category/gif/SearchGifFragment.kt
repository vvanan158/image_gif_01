package com.sun.imagegif.ui.search.category.gif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R
import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.repositories.GifRepository
import com.sun.imagegif.ui.search.adapter.SearchAdapter
import kotlinx.android.synthetic.main.fragment_search_gif.*

class SearchGifFragment : Fragment(),
    SearchGifContract.View {

    private val presenter by lazy {
        SearchGifPresenter(GifRepository.INSTANCE)
    }
    private val searchAdapter by lazy {
        SearchAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_gif, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        presenter.setView(this)
    }

    override fun showGifs(gifs: MutableList<Gif>) {
        searchAdapter.updateData(gifs)
    }

    override fun onSearchWithGifError(e: Exception?) = Unit

    fun searchWithGif(keyword: String) {
        presenter.searchWithGif(keyword)
    }

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(gifImageRecyclerView) {
            adapter = searchAdapter
        }
    }

    companion object {
        fun newInstance() = SearchGifFragment()
    }
}
