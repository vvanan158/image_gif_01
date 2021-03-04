package com.sun.imagegif.ui.storage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R

class StorageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_storage, container, false)
    }

    companion object {
        fun newInstance() = StorageFragment()
    }
}
