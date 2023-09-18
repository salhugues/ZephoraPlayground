package com.salhugues.zephoraplayground.misc

interface Mapper<A, B> {
    fun transform(item: A): B
}

interface TwoWayMapper<A, B> : Mapper<A, B> {
    fun revert(item: B): A
}
