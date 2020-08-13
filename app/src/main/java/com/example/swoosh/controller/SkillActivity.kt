package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utility.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    lateinit var player : Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        println(player.league)
    }

    fun finishOnClick(view: View){
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER , player)
            startActivity(finishActivity)
        }
        else{
            Toast.makeText(this ,"Please pick a skill level" , Toast.LENGTH_SHORT)
        }
    }

    fun beginnerOnCLick(view: View){
        balerBtn.isChecked = false
        player.skill = if(beginnerBtn.isChecked) "beginner" else ""
    }

    fun balerOnClick(view: View){
        beginnerBtn.isChecked = false
        player.skill = if(balerBtn.isChecked) "baler" else ""
    }
}