package com.example.propertyanimation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Declaring and Initializing the
        // ImageView and the Button from the layout file
        val mImageView = findViewById<ImageView>(R.id.image_view_1)
        val mButton1 = findViewById<Button>(R.id.button_1)
        val mButton2 = findViewById<Button>(R.id.button_2)
        val mButton3 = findViewById<Button>(R.id.button_3)
        val mButton4 = findViewById<Button>(R.id.button_4)
        var rotateAnimation =

        // When button is clicked,
        // animation is created and started
            mButton1.setOnClickListener {
                val animator = ObjectAnimator.ofFloat(mImageView, View.ROTATION, -360f, 0f)
                animator.duration = 1000
                animator.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator?) {
                        mButton1.isEnabled = false
                    }
                    override fun onAnimationEnd(animation: Animator?) {
                        mButton1.isEnabled = true
                    }
                })
                animator.start()
        }

        // When button is clicked,
        // animation is created and started
        mButton2.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(mImageView, View.ALPHA, 0f)
            animator.repeatCount = 1
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.disableViewDuringAnimation(mButton2)
            animator.start()

//            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.fade_in)
//            mImageView.startAnimation(animationRotate)
        }

        // When button is clicked,
        // animation is created and started
        mButton3.setOnClickListener {
            val intent = Intent(this, ShowerAnimationActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        mButton4.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(mImageView, View.TRANSLATION_X,
                200f)
            animator.repeatCount = 1
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.disableViewDuringAnimation(mButton4)
            animator.start()
        }

    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {

        // This extension method listens for start/end
        // events on an animation and disables
        // the given view for the entirety of that animation.
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }
        })
    }

}