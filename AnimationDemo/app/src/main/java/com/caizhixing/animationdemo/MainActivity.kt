package com.caizhixing.animationdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.caizhixing.animationdemo.Animation.AnimationActivity
import com.caizhixing.animationdemo.Animator.AnimatorActivity
import com.caizhixing.animationdemo.LayoutChangeAnimation.LayoutChangeAnimationActivity
import com.caizhixing.animationdemo.LayoutTransition.LayoutTransitionActivity
import com.caizhixing.animationdemo.ListAnimation.Main3Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animation_ac.setOnClickListener {
            val intent = Intent(this@MainActivity,AnimationActivity::class.java)
            startActivity(intent)
        }

        animator_ac.setOnClickListener {
            val intent = Intent(this@MainActivity,AnimatorActivity::class.java)
            startActivity(intent)
        }

        anim.setOnClickListener {
            val intent = Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(intent)
        }

        anim4.setOnClickListener {
            val intent = Intent(this@MainActivity,Main3Activity::class.java)
            startActivity(intent)
        }

        anim5.setOnClickListener {
            val intent = Intent(this@MainActivity,LayoutTransitionActivity::class.java)
            startActivity(intent)
        }

        anim6.setOnClickListener {
            val intent = Intent(this@MainActivity,LayoutChangeAnimationActivity::class.java)
            startActivity(intent)
        }
    }
}
