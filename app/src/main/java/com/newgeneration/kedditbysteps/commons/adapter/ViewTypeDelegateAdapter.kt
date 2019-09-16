package com.newgeneration.kedditbysteps.commons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.newgeneration.kedditbysteps.ViewType

interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}