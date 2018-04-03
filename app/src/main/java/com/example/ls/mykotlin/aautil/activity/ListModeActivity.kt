package com.example.ls.mykotlin.aautil.activity

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.andview.refreshview.XRefreshView
import com.example.ls.mykotlin.BR
import com.example.ls.mykotlin.R
import com.example.ls.mykotlin.aautil.adapter.BaseAdapter
import com.example.ls.mykotlin.aautil.adapter.BaseViewHolder
import com.example.ls.mykotlin.aautil.base.ListIPresenterBase

/**
 * Created by zhuyuanshuju on 2018/3/29.
 */
open class  ListModeActivity<T : ViewDataBinding>(val layout:Int) : Activity() {

    lateinit var binding:T;
    var page=1

    open fun <D> init(model: ListIPresenterBase<D>,itemLayout:Int){
        binding =DataBindingUtil.setContentView<T>(this, layout);
        // binding.pull.setAutoLoadMore(false)
        var xf=findViewById<XRefreshView>(R.id.pull)
        var listview=findViewById<RecyclerView>(R.id.news_rv)
        xf.setPullLoadEnable(true)
        xf.setXRefreshViewListener(object: XRefreshView.SimpleXRefreshListener(){
            override fun onRefresh() {
                page=1
                model.getData(page)
            }

            override fun onLoadMore(isSilence: Boolean) {
                model.getData(++page)
            }
        })

        listview.layoutManager = LinearLayoutManager(this);

        listview.adapter = AllAdapter(this,model.itemViewModel,itemLayout);

        xf.startRefresh()
    }

    class AllAdapter<D>(context: Context, list: List<D>,val item:Int): BaseAdapter<D, BaseViewHolder<ViewDataBinding>>(context,list) {

        override fun onCreateVH(parent: ViewGroup?, viewType: Int): BaseViewHolder<ViewDataBinding> {
            val dataBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater, item, parent, false)
            return BaseViewHolder(dataBinding)
        }

        override fun onBindVH(vh: BaseViewHolder<ViewDataBinding>, position: Int) {
            val binding = vh.getBinding()
            binding.setVariable(BR.dataItem, mList[position])
            binding.setVariable(BR.position, position)
            if(BR.listener!=null)
                binding.setVariable(BR.listener, mContext)
            binding.executePendingBindings() //防止闪烁
        }
    }

}