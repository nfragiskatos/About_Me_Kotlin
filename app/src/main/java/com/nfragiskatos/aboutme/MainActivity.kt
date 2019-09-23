package com.nfragiskatos.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nfragiskatos.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aaron Rodgers")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        binding.doneButton.setOnClickListener(this::addNickname)
    }

    private fun addNickname(btn: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(btn.windowToken, 0)
    }
}
