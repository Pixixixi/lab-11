package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class vivodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vivod)

        val file = assets.open("SpisockDel.json")
        val  builder = StringBuilder()
        var b = file.read()
        while (b != -1){
            builder.append(b.toChar())
            b=file.read()
        }
        val json = builder.toString()

        val spisock: List<Spisok> = Gson().fromJson<List<Spisok>>(json, object : TypeToken<List<Spisok>>(){}.type)
        Log.d("yy", spisock.toString())
    }
}