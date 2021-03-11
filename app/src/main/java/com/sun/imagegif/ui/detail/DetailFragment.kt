package com.sun.imagegif.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R
import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.utils.Constant
import com.sun.imagegif.utils.loadUrl
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        handleEvent()
    }

    private fun initViews() {
        initDetailView()
    }

    private fun initDetailView() {
        arguments?.getParcelable<Gif>(Constant.BUNDLE_GIF)?.let {
            detailsImageView.loadUrl(it.imageUrl)
            userImageView.loadUrl(it.user.avatarUrl)
            titleDetailsTextView.text = it.title
            userNameTextView.text = it.user.name
        }
    }

    private fun handleEvent() {
        previousImageButton.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    companion object {
        fun newInstance(bundle: Bundle) = DetailFragment().apply {
            arguments = bundle
        }
    }
}
