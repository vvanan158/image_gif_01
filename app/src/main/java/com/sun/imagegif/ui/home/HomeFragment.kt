package com.sun.imagegif.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R
import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.repositories.GifRepository
import com.sun.imagegif.ui.home.adapter.TrendingAdapter
import com.sun.imagegif.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), OnItemRecyclerViewClickListener<Gif>, HomeContract.View {

    private val trendingAdapter by lazy {
        TrendingAdapter()
    }
    private val presenter by lazy {
        HomePresenter(GifRepository.INSTANCE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        presenter.run {
            setView(this@HomeFragment)
            getTrending()
        }
    }

    override fun onGetTrendingSuccess(gifs: MutableList<Gif>) {
        trendingAdapter.addTrending(gifs)
    }

    override fun onError(exception: Exception?) = Unit

    override fun onItemClickListener(item: Gif?) = Unit

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(trendingRecyclerView) {
            trendingAdapter.registerItemRecyclerViewClickListener(this@HomeFragment)
            adapter = trendingAdapter
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
