package com.example.kotlin_b2.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "L'objectif de ce projet est de mettre en pratique tout ceux qu'on a fait pendant le cours Kotlin 2022.\n" +
                "L'application se presente avec un side-menu.\n" +
                "dans ce side-menu il y a Accueil, A propos, UI app, Listing, Multi-fontions.\n" +
                "Pour la page A propos, elle explique sur le projet, Pour la page UI app, elle montre un Grid UI\n" +
                "Pour la page Listing, elle montre une liste des choses, Pour la page Snack Bar, dans cette page il y a des boutons qui permettent de montrer les fonctionalites du snack bar.\n" +
                "\n Merci :) Enjoy notre application."
    }
    val text: LiveData<String> = _text
}