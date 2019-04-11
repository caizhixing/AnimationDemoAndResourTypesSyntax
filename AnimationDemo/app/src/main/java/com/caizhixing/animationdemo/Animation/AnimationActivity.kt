package com.caizhixing.animationdemo.Animation

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import com.caizhixing.animationdemo.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        image.setBackgroundResource(R.drawable.animation_frame)

        animation_bu_1.setOnClickListener {
            val scaleAnimation = ScaleAnimation(0f, 50f, 0f, 50f)
            val rotateAnimation = RotateAnimation(0f, 180f)
            val set = AnimationSet(true)
            set.addAnimation(scaleAnimation)
            set.addAnimation(rotateAnimation)
            it.startAnimation(rotateAnimation)
        }

        animation_bu_2.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.abc_slide_in_bottom)
            it.startAnimation(animation)
        }

        frame_animation.setOnClickListener {
            val animation = image.background
            if(animation is Animatable){
                animation.start()
            }
        }
    }
}
