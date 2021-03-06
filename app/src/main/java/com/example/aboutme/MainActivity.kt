package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val myName:MyName = MyName("Vanessa Fabri")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

   private fun addNickname(view: View) {

       // Para deixar o código mais fácil de ler, usamos o 'binding.apply{}'

       binding.apply {
            //binding.nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll() // invalidar todas as expressões de ligação para que sejam recriadas
                            // com os dados corretos para atualizar a UI com os novos dados
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


       // Para esconder o teclado
       val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       imn.hideSoftInputFromWindow(view.windowToken, 0)
   }

}