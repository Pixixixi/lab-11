package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson

private lateinit var deloText: EditText
private lateinit var timeText: EditText
private lateinit var dataText: EditText
private lateinit var dobav : Button
class Vod_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vod)
        val mPrefs = getPreferences(MODE_PRIVATE)
        deloText = findViewById(R.id.DeloText)
        timeText = findViewById((R.id.TimeText))
        dataText = findViewById(R.id.DataText)
        dobav = findViewById(R.id.button3)
        var Delo : String = deloText.text.toString()
        var Time : String = timeText.text.toString()
        var Data: String = dataText.text.toString()
        val nums : List<String> = listOf(Delo, Time, Data)
        dobav.setOnClickListener{

            val prefsEditor: SharedPreferences.Editor = mPrefs.edit()
            val gson = Gson()
            val json = gson.toJson(nums)
            prefsEditor.putString("MyObject", json)
            prefsEditor.apply()
        }
    }
}