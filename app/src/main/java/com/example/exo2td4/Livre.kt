package com.example.exo2td4

data class Livre(
    var titre: String,

    var description: String,

    var image: String,

    var auteur: String

){
    override fun toString(): String {
        return "Livre(titre='$titre', image='$image', auteur='$auteur', description='$description')"
    }
}