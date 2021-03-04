package com.sun.imagegif.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.imagegif.R
import com.sun.imagegif.ui.main.page.PageContainerFragment
import com.sun.imagegif.utils.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(PageContainerFragment.newInstance(), R.id.containerLayout)
    }
}
