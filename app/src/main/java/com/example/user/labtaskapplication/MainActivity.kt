package com.example.user.labtaskapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onClick(v: View?) {
        var userName = edtxt1.text.toString()
        var email = edtxt2.text.toString()
        var password = edtxt3.text.toString()
        if(userName.equals("Bilal",false) && email.equals("BilalHameed",false)) {

            if(password.equals("12345")) {


                var intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("UserName",userName)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Invalid Password",Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this,"Invalid UserName or Email",Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.btnLogin)
        var edtxt1 = findViewById<EditText>(R.id.edtxt1)
        var edtxt2 = findViewById<EditText>(R.id.edtxt2)
        var edtxt3 = findViewById<TextInputEditText>(R.id.edtxt3)
        edtxt1.setOnClickListener(this)
        edtxt2.setOnClickListener(this)
        edtxt3.setOnClickListener(this)
        btnLogin.setOnClickListener(this)



    }
}
