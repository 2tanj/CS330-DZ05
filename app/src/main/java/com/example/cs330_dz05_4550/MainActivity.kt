package com.example.cs330_dz05_4550

import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var items =
        arrayOf<CharSequence>("FIT", "Fakultet za menadžment", "Fakultet digitalnih umetnosti")
    var itemChecked: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        showDialog(0)
    }

    override fun onCreateDialog(id: Int): Dialog? {
        when (id) {
            0 -> return AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Univerzitet Metropolitan Fakulteti")
                .setPositiveButton(
                    "OK"
                ) { dialog, whichButton ->
                    val i = Intent("android.intent.action.VIEW")
                    when (itemChecked) {
                        0 -> i.data = Uri.parse("https://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija/")
                        1 -> i.data = Uri.parse("https://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment/")
                        2 -> i.data = Uri.parse("https://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2/")
                    }
                    startActivity(i)
                }
                .setNegativeButton(
                    "Cancel"
                ) { dialog, whichButton ->
                    Toast.makeText(
                        baseContext,
                        "Cancel je kliknut!", Toast.LENGTH_SHORT
                    ).show()
                }
                .setSingleChoiceItems(items, itemChecked
                ) { dialog, checkedItem ->
                    itemChecked = checkedItem
                }.create()
        }
        return null
    }
}