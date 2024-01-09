package com.example.wordletr

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.wordletr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        keepPassingFocus()

        binding.edt15.addTextChangedListener {
            validateRow(
                binding.edt11,
                binding.edt12,
                binding.edt13,
                binding.edt14,
                binding.edt15,
            )
        }

        binding.edt25.addTextChangedListener {
            validateRow(
                binding.edt21,
                binding.edt22,
                binding.edt23,
                binding.edt24,
                binding.edt25,
            )
        }

        binding.edt35.addTextChangedListener {
            validateRow(
                binding.edt31,
                binding.edt32,
                binding.edt33,
                binding.edt34,
                binding.edt35,
            )
        }

        binding.edt45.addTextChangedListener {
            validateRow(
                binding.edt41,
                binding.edt42,
                binding.edt43,
                binding.edt44,
                binding.edt45,
            )
        }

        binding.edt55.addTextChangedListener {
            validateRow(
                binding.edt51,
                binding.edt52,
                binding.edt53,
                binding.edt54,
                binding.edt55,
            )
        }

        binding.edt65.addTextChangedListener {
            validateRow(
                binding.edt61,
                binding.edt62,
                binding.edt63,
                binding.edt64,
                binding.edt65,
            )
        }
    }

    private fun validateRow(
        edt1: EditText,
        edt2: EditText,
        edt3: EditText,
        edt4: EditText,
        edt5: EditText
    ) {
        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()
        val edt5Text = edt5.text.toString()

        val word1 = WORD[0].toString()
        val word2 = WORD[1].toString()
        val word3 = WORD[2].toString()
        val word4 = WORD[3].toString()
        val word5 = WORD[4].toString()

        if (edt1Text == word2 || edt1Text == word3 || edt1Text == word4 || edt1Text == word5) {
            edt1.setBackgroundColor(resources.getColor(R.color.charfalse))
        }

        if (edt2Text == word1 || edt2Text == word3 || edt2Text == word4 || edt2Text == word5) {
            edt2.setBackgroundColor(resources.getColor(R.color.charfalse))
        }

        if (edt3Text == word1 || edt3Text == word2 || edt3Text == word4 || edt3Text == word5) {
            edt3.setBackgroundColor(resources.getColor(R.color.charfalse))
        }

        if (edt4Text == word1 || edt4Text == word2 || edt4Text == word3 || edt4Text == word5) {
            edt4.setBackgroundColor(resources.getColor(R.color.charfalse))
        }

        if (edt5Text == word1 || edt5Text == word2 || edt5Text == word3 || edt5Text == word4) {
            edt5.setBackgroundColor(resources.getColor(R.color.charfalse))
        }

        if (edt1Text == word1) {
            edt1.setBackgroundColor(resources.getColor(R.color.chartrue))
        }

        if (edt2Text == word2) {
            edt2.setBackgroundColor(resources.getColor(R.color.chartrue))
        }

        if (edt3Text == word3) {
            edt3.setBackgroundColor(resources.getColor(R.color.chartrue))
        }

        if (edt4Text == word4) {
            edt4.setBackgroundColor(resources.getColor(R.color.chartrue))
        }

        if (edt5Text == word5) {
            edt5.setBackgroundColor(resources.getColor(R.color.chartrue))
        }

        if (edt1Text != word1 && edt1Text != word2 && edt1Text != word3 && edt1Text != word4 && edt1Text != word5) {
            edt1.setBackgroundColor(resources.getColor(R.color.textbackground))
        }

        if (edt2Text != word1 && edt2Text != word2 && edt2Text != word3 && edt2Text != word4 && edt2Text != word5) {
            edt2.setBackgroundColor(resources.getColor(R.color.textbackground))
        }

        if (edt3Text != word1 && edt3Text != word2 && edt3Text != word3 && edt3Text != word4 && edt3Text != word5) {
            edt3.setBackgroundColor(resources.getColor(R.color.textbackground))
        }

        if (edt4Text != word1 && edt4Text != word2 && edt4Text != word3 && edt4Text != word4 && edt4Text != word5) {
            edt4.setBackgroundColor(resources.getColor(R.color.textbackground))
        }

        if (edt5Text != word1 && edt5Text != word2 && edt5Text != word3 && edt5Text != word4 && edt5Text != word5) {
            edt5.setBackgroundColor(resources.getColor(R.color.textbackground))
        }

        if (edt1Text == word1 && edt2Text == word2 && edt3Text == word3 && edt4Text == word4 && edt5Text == word5) {
            Toast.makeText(this, "Tebrikler, Bildiniz!", Toast.LENGTH_SHORT).show()
            binding.txtWinnerLooser.visibility = View.VISIBLE
            binding.txtWinnerLooser.text = "Tebrikler, Bildiniz!"
            makeGameInactive()
            return
        }

        if (edt5.id == R.id.edt_65) {
            Toast.makeText(this, "Üzgünüm, Bilemediniz!", Toast.LENGTH_SHORT).show()
            binding.txtWinnerLooser.visibility = View.VISIBLE
            binding.txtWinnerLooser.text = "Üzgünüm, Bilemediniz!"
            makeGameInactive()
            return
        }
    }

    private fun makeGameInactive() {
        binding.edt11.isEnabled = false
        binding.edt12.isEnabled = false
        binding.edt13.isEnabled = false
        binding.edt14.isEnabled = false
        binding.edt15.isEnabled = false
        binding.edt21.isEnabled = false
        binding.edt22.isEnabled = false
        binding.edt23.isEnabled = false
        binding.edt24.isEnabled = false
        binding.edt25.isEnabled = false
        binding.edt31.isEnabled = false
        binding.edt32.isEnabled = false
        binding.edt33.isEnabled = false
        binding.edt34.isEnabled = false
        binding.edt35.isEnabled = false
        binding.edt41.isEnabled = false
        binding.edt42.isEnabled = false
        binding.edt43.isEnabled = false
        binding.edt44.isEnabled = false
        binding.edt45.isEnabled = false
        binding.edt51.isEnabled = false
        binding.edt52.isEnabled = false
        binding.edt53.isEnabled = false
        binding.edt54.isEnabled = false
        binding.edt55.isEnabled = false
        binding.edt61.isEnabled = false
        binding.edt62.isEnabled = false
        binding.edt63.isEnabled = false
        binding.edt64.isEnabled = false
        binding.edt65.isEnabled = false

    }

    private fun keepPassingFocus() {
        passFocusToNextEditText(binding.edt11, binding.edt12)
        passFocusToNextEditText(binding.edt12, binding.edt13)
        passFocusToNextEditText(binding.edt13, binding.edt14)
        passFocusToNextEditText(binding.edt14, binding.edt15)

        passFocusToNextEditText(binding.edt21, binding.edt22)
        passFocusToNextEditText(binding.edt22, binding.edt23)
        passFocusToNextEditText(binding.edt23, binding.edt24)
        passFocusToNextEditText(binding.edt24, binding.edt25)

        passFocusToNextEditText(binding.edt31, binding.edt32)
        passFocusToNextEditText(binding.edt32, binding.edt33)
        passFocusToNextEditText(binding.edt33, binding.edt34)
        passFocusToNextEditText(binding.edt34, binding.edt35)

        passFocusToNextEditText(binding.edt41, binding.edt42)
        passFocusToNextEditText(binding.edt42, binding.edt43)
        passFocusToNextEditText(binding.edt43, binding.edt44)
        passFocusToNextEditText(binding.edt44, binding.edt45)

        passFocusToNextEditText(binding.edt51, binding.edt52)
        passFocusToNextEditText(binding.edt52, binding.edt53)
        passFocusToNextEditText(binding.edt53, binding.edt54)
        passFocusToNextEditText(binding.edt54, binding.edt55)

        passFocusToNextEditText(binding.edt61, binding.edt62)
        passFocusToNextEditText(binding.edt62, binding.edt63)
        passFocusToNextEditText(binding.edt63, binding.edt64)
        passFocusToNextEditText(binding.edt64, binding.edt65)
    }

    private fun passFocusToNextEditText(
        edt1: EditText,
        edt2: EditText
    ) {
        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(edt: Editable?) {
                if (edt?.length == 1) {
                    edt2.requestFocus()
                }
            }
        })
    }

    companion object {
        private val WORD = "valiz"
    }
}


