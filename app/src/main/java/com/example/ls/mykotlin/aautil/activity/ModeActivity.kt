package com.example.ls.mykotlin.aautil.activity

import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.ls.mykotlin.R
import com.example.ls.mykotlin.aautil.model.AllNavModel
import com.example.ls.mykotlin.databinding.ActivityListviewDemo1Binding

/**
 * Created by zhuyuanshuju on 2018/3/29.
 */
open abstract class  ModeActivity<T : ViewDataBinding>(var layout:Int)  :Activity() {

    lateinit  var binding:T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<T>(this, layout)

        init()
    }

    abstract fun init()


}