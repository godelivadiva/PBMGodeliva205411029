package com.example.pbmgodeliva205411029

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import com.example.pbmgodeliva205411029.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnPetDetail : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This is used to hide the status bar and make
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btnPetDetail = binding.btnPetDetail
        btnPetDetail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btnPetDetail -> run {
                    val intentListActivity = Intent(this@MenuActivity, PetActivity::class.java)
                    startActivity(intentListActivity)
                }
            }
        }
    }
}
