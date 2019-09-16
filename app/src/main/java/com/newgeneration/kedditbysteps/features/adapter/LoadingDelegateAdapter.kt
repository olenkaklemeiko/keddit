package com.newgeneration.kedditbysteps.features.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgeneration.kedditbysteps.R
import com.newgeneration.kedditbysteps.ViewType
import com.newgeneration.kedditbysteps.commons.adapter.ViewTypeDelegateAdapter
import com.newgeneration.kedditbysteps.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)
    )

}