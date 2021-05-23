package com.skill_factory.brain_train

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment

class TwistingFragment : GameFragment() {

    lateinit var animator: ObjectAnimator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Creating rotation animator
        val rotationHolder: PropertyValuesHolder = PropertyValuesHolder.ofFloat("rotation", -90.0F, 90F)
        animator = ObjectAnimator.ofPropertyValuesHolder(fieldView, rotationHolder).apply {
            duration = lvl * 650L
            interpolator = DecelerateInterpolator()
        }
    }

    override fun startLevel(lvl: Int) {
        super.startLevel(lvl)
        animator.start()
    }
}