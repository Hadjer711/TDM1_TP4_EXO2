package com.example.exo2td4

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_livre_detail.*

class MainActivity : AppCompatActivity(), LivreAdapter.OnLivreListener {
    var toolbar: Toolbar? = null
    private lateinit var livreAdapter: LivreAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.toolbar)
        initRecycleView()
        addDataSet()




    }
    private fun addDataSet(){
        val data= DataSource.createDataSet()
        livreAdapter.submitList(data)
    }

    private fun initRecycleView(){
        recycleview. apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecoration= TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            livreAdapter= LivreAdapter(this@MainActivity)
            adapter= livreAdapter
        }

    }

    override fun onLivreClick(livre: Livre, position: Int) {
        Toast.makeText(this, livre.titre, Toast.LENGTH_SHORT).show()
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            livre_title.text= livre.titre
            livre_author.text= "Ecrit par "+livre.auteur
            livre_description.text= "   "+livre.description

        } else {
            val intent= Intent(this, LivreDetailActivity::class.java)
            intent.putExtra("titre", "Titre du livre : "+livre.titre)
            intent.putExtra("description", "Description du Livre : " +livre.description)
            intent.putExtra("auteur", "Auteur du Livre : "+livre.auteur)
            intent.putExtra("image", livre.image)
            startActivity(intent)
        }


    }
}
