package com.example.kotlin_b2.ui.multifontions

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.kotlin_b2.R
import com.example.kotlin_b2.SnackbarActivity
import com.example.kotlin_b2.ui.multifontions.MultifontionsViewModel
import com.example.kotlin_b2.databinding.MultifontionsFragmentBinding
import com.google.android.material.snackbar.Snackbar

class Multifontions : Fragment() {

    private lateinit var multifontionsViewModel: MultifontionsViewModel
    private var _binding: MultifontionsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        multifontionsViewModel =
            ViewModelProvider(this).get(MultifontionsViewModel::class.java)

        _binding = MultifontionsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textMultifontions
        multifontionsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var llmain : LinearLayout = requireActivity().findViewById(R.id.main)
        var btn1 : Button = requireActivity().findViewById(R.id.btn1)
        var btn2 : Button = requireActivity().findViewById(R.id.btn2)
        var btn3 : Button = requireActivity().findViewById(R.id.btn3)

        btn1.setOnClickListener { view ->
            val defaultSnackbar: Snackbar = Snackbar.make(llmain, "Coucou, :)", Snackbar.LENGTH_LONG)
            defaultSnackbar.show()
        }

        btn2.setOnClickListener {
            val customSnackbar: Snackbar = Snackbar.make(llmain, "essayez encore :(", Snackbar.LENGTH_LONG).setAction("Re-try"){}
            customSnackbar.setActionTextColor(Color.RED)
            customSnackbar.show()
        }

        btn3.setOnClickListener {
            val actionSnackbar = Snackbar.make(llmain,"Message is supprime ;/", Snackbar.LENGTH_LONG).setAction("UNDO",object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val snackbar = Snackbar.make(llmain,"Message est restaure!!", Snackbar.LENGTH_LONG)
                    snackbar.show()
                }

            })
            actionSnackbar.show()
        }
    }


}

