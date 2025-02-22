package com.example.cadastro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        private val activityMainBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        var nome = ""
        var telefone = ""
        var email = ""
        var recebeEmails = false
        var sexo = ""
        var cidade = ""
        var uf = ""

        with (activityMainBinding) {
            nomeEt.addTextChangedListener { nome = it.toString() }
            telefoneEt.addTextChangedListener { telefone = it.toString() }
            emailEt.addTextChangedListener { email = it.toString() }
            cidadeEt.addTextChangedListener { nome = it.toString() }

            emailCb.setOnClickListener { recebeEmails = (it as CheckBox).isChecked }

            masculinoRb.setOnClickListener { sexo = (it as RadioButton).text.toString() }
            femininoRb.setOnClickListener { sexo = (it as RadioButton).text.toString() }

            ufSp.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    uf = resources.getStringArray(R.array.valores_iniciais)[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

            salvarBt.setOnClickListener {
                if (nome.isNotEmpty() && telefone.isNotEmpty() && email.isNotEmpty()) {
                    val formulario = Formulario(nome, telefone, email, recebeEmails, sexo, cidade, uf)
                    Toast.makeText(this@MainActivity, formulario.toString(), Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@MainActivity, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
                }
            }

            limparBt.setOnClickListener {
                nomeEt.setText("")
                telefoneEt.setText("")
                emailEt.setText("")
                cidadeEt.setText("")
                emailCb.isChecked = false
                masculinoRb.isChecked = true
                femininoRb.isChecked = false
                ufSp.setSelection(0)
            }
        }
    }
}