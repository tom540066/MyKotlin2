package com.example.ls.mykotlin.activity

import android.databinding.ObservableField
import com.example.ls.mykotlin.R
import com.example.ls.mykotlin.aautil.activity.ModeActivity
import com.example.ls.mykotlin.databinding.ActivityDetailBinding
import com.example.ls.mykotlin.model.DetailModel

class DetailActivity : ModeActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    lateinit var dModel:DetailModel


    override fun init() {
        dModel = DetailModel("123")
        binding.viewModel = dModel


    }
}