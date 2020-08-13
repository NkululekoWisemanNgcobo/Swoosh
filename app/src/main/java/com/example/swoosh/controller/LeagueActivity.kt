package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.model.Player
import com.example.swoosh.utility.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var player = Player("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClick(view: View){
        if (player.league != "") {
            val skillactivity = Intent(this, SkillActivity::class.java)
            skillactivity.putExtra(EXTRA_PLAYER , player)
            startActivity(skillactivity)
        }else{
            Toast.makeText(this, "Please select League", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMensClick(view: View){
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = if (mensLeagueButton.isChecked) "mens" else ""
    }

    fun onWomensClick(view: View){
        mensLeagueButton.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = if (womensLeagueBtn.isChecked) "Womens" else ""
    }

    fun onCoedClick(view: View){
        mensLeagueButton.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = if (coedLeagueBtn.isChecked) "coed" else ""
    }
}