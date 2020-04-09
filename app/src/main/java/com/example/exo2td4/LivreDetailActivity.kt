package com.example.exo2td4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_livre_detail.*

class LivreDetailActivity : AppCompatActivity() {

    lateinit var livreAdapter: LivreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livre_detail)

        livre_title.text = getIntent().getStringExtra("titre")
        livre_author.text = getIntent().getStringExtra("auteur")
        livre_description.text = getIntent().getStringExtra("description")

    }
}
