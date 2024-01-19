package com.shlokIT.colorpredictiongame

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner
import com.shlokIT.colorpredictiongame.Network.ApiClient
import com.shlokIT.colorpredictiongame.Pojo.CityData
import retrofit2.Call
import retrofit2.Response

class ApiActivity : AppCompatActivity() {
    private lateinit var spin: AppCompatSpinner
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppFullScreenTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        spin = findViewById(R.id.spin) as AppCompatSpinner
        val cities = resources.getStringArray(R.array.City)

        // access the spinner
        if (spin != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
            spin.adapter = adapter

            spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(this@ApiActivity, getString(R.string.selected_item) + " " + "" + cities[position], Toast.LENGTH_SHORT).show()
                    val text: String = spin.getSelectedItem().toString()
                    
                    CallApi(text)

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun CallApi(text: String) {
        val pDialog = ProgressDialog(this@ApiActivity)
        pDialog.setMessage(this@ApiActivity?.getString(R.string.dialog_msg));
        pDialog.setCancelable(false);
        pDialog.show();

        val apiInterface = ApiClient.getClient.GetSelectedCityData("New Delhi"/*text*/)
        apiInterface.enqueue(object : retrofit2.Callback<CityData> {

            override fun onResponse(call: Call<CityData>, response: Response<CityData>) {
                if (response.isSuccessful) {
                    Log.v("CityResponse ==>", "" + response.body()?.current.toString())

                    // here you have to set your data in UI
                    pDialog.dismiss()
                } else {
                    Toast.makeText(applicationContext, response.body()?.current.toString(), Toast.LENGTH_SHORT)
                        .show()
                    pDialog.dismiss()
                }
            }

            override fun onFailure(call: Call<CityData>, t: Throwable) {
                Log.e("ResponseFail", "" + t)
                pDialog.dismiss()
            }
        })
    }
}