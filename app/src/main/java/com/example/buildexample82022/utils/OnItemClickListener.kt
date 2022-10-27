package com.example.buildexample82022.utils

interface OnItemClickListener<T> {
    fun onItemClick(position: Int, data: T?)
}