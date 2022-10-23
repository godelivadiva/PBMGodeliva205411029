package com.example.pbmgodeliva205411029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)

        val petNameHeader : TextView = findViewById(R.id.textNameHeader)
        val petImageHeader : ImageView = findViewById(R.id.imagePetHeader)
        val petCharacterDetail : TextView = findViewById(R.id.textPetCharacter)

        val bundle : Bundle?= intent.extras
        val petName = bundle!!.getString("petName")
        val petImage = bundle.getInt("petImage")
        val petCharacter = bundle.getString("petCharacter")

        petNameHeader.text = petName
        petImageHeader.setImageResource(petImage)
        petCharacterDetail.text = petCharacter
    }
}