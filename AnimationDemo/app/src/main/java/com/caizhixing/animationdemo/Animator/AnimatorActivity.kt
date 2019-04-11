package com.caizhixing.animationdemo.Animator

import android.animation.*
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animator.*


class AnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.caizhixing.animationdemo.R.layout.activity_animator)

        object_animator.setOnClickListener {
            // 目标对象必须有setter方法 例如：View.setAlpha 那么propertyName可以设置为alpha
            val animtor = ObjectAnimator.ofFloat(it, "alpha", 0f, 1f, 0f, 1f)
            // 插值器 返回的值 范围在 0-1
            animtor.setInterpolator(TimeInterpolator {
                it
            })
            // 估值器
            animtor.setEvaluator(object : TypeEvaluator<Float> {
                // fraction的值是通过Interpolator计算得来的
                override fun evaluate(fraction: Float, startValue: Float?, endValue: Float?): Float {
                    return fraction * (endValue!! - startValue!!)
                }
            })
            animtor.duration = 3000
            animtor.start()
        }

        object_animator2.setOnClickListener {
            val animator = AnimatorInflater.loadAnimator(
                this@AnimatorActivity,
                com.caizhixing.animationdemo.R.animator.animator_object
            )
            animator.setTarget(it)
            animator.start()
        }

        object_animator3.setOnClickListener {
            val button = it
            val animator = ValueAnimator.ofArgb(Color.WHITE, Color.BLUE)
            animator.duration = 3000
            // ofArgb默认使用ArgbEvaluator 同理还有
//            animator.setEvaluator(ArgbEvaluator())
            animator.addUpdateListener {
                val value = it.animatedValue as Int
                button.setBackgroundColor(value)
            }
            animator.repeatCount = 2
            animator.start()
        }

        object_animator4.setOnClickListener {
            val frame0 = Keyframe.ofFloat(0f, 0f)
            val frame1 = Keyframe.ofFloat(0.1f, -20f)
            val frame2 = Keyframe.ofFloat(1f, 0f)

            val frame3 = Keyframe.ofFloat(0f,0.2f)
            val frame4 = Keyframe.ofFloat(0.4f,1f)
            // 多个属性
            val frameHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2)
            val alphaHolder = PropertyValuesHolder.ofKeyframe("rotation", frame3,frame4)
            val animator = ObjectAnimator.ofPropertyValuesHolder(it, frameHolder, alphaHolder)
            animator.duration = 1000
            animator.start()
        }
    }
}
