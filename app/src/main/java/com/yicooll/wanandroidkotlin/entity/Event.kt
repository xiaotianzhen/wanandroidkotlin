package com.yicooll.wanandroidkotlin.entity

class Event<T> constructor(action: String) {

    private var action: String = ""
    private var data: T? = null

    init {
        this.action=action
    }

    constructor(action: String, data: T) : this(action) {
        this.action = action
        this.data = data
    }

    fun getAction(): String {
        return action
    }

    fun getData(): T? {
        return data
    }

}