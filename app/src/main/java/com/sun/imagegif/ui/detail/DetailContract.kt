package com.sun.imagegif.ui.detail

import com.sun.imagegif.ui.home.HomeContract
import com.sun.imagegif.utils.BasePresenter

interface DetailContract {

    interface Presenter : BasePresenter<View> {
    }

    interface View : HomeContract.View {
        fun onDetailSuccess()
        fun onError()
    }
}
