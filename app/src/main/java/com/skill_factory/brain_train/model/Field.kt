package com.skill_factory.brain_train.model

import kotlin.random.Random

const val EMPTY = 0
const val PAINTED = 1
const val WRONG = -1

class Field(lvl: Int) {
    val size = 3 + (lvl * 0.33).toInt()
    val shaded = (size * size / 2 - lvl)

    val model = Array(size) { Array(size) { EMPTY } }
    val temp = Array(size) { Array(size) { EMPTY } }


    init {
        var count = 0
        for(i in 0 until size) {
            for(j in 0 until size) {
                if(count < shaded) {
                    model[i][j] = PAINTED
                    count++
                }
            }
        }
        model.mixing()
    }

    private fun <T> Array<Array<T>>.swap(i1: Int, j1: Int, i2: Int, j2: Int) {
        val tmp = this[i1][j1]
        this[i1][j1] = this[i2][j2]
        this[i2][j2] = tmp
    }

    fun <T> Array<T>.mixing() {
        repeat((size * size) / 2) {
            model.swap(
                Random.nextInt(size),
                Random.nextInt(size),
                Random.nextInt(size),
                Random.nextInt(size)
            )
        }
    }
}