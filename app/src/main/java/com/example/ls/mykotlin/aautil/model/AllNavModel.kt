package com.example.ls.mykotlin.aautil.model

import android.app.Activity
import android.databinding.ObservableField
import android.view.View
import com.kelin.mvvmlight.base.ViewModel

interface AllNavModel  {
    var navTitle : String

    fun backClick(view: View){
        (view.context as Activity).finish()
    }
}