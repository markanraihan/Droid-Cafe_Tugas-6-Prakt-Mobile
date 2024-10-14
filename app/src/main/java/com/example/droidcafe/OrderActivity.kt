package com.example.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    private val cityList = arrayOf("Kota Bandung", "Kota Cimahi", "Kabupaten Bandung")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val citySpinner: Spinner = findViewById(R.id.city_spinner)


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cityList
        )


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        citySpinner.adapter = adapter


        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCity = parent.getItemAtPosition(position).toString()
                displayToast("Kota yang dipilih: $selectedCity")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }


    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked) {
                displayToast(getString(R.string.same_day_messenger_service))
            }

            R.id.nextday -> if (checked) {
                displayToast(getString(R.string.next_day_ground_delivery))
            }

            R.id.pickup -> if (checked) {
                displayToast(getString(R.string.pick_up))
            }
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
