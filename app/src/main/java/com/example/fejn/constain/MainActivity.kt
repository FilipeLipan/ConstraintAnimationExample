package com.example.fejn.constain

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(root)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_main_reduce)

        var changed = false
        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            val constraint = if (changed) constraintSet1 else constraintSet2
            constraint.applyTo(root)
            changed = !changed
        }
    }
}
