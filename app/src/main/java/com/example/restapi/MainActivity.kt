package com.example.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.api.ApiCalling
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyleView = findViewById<RecyclerView>(R.id.reclye_view)

        ApiCalling.getService().getMolty().enqueue(object : Callback<ResponeMolty>{
            override fun onResponse(call: Call<ResponeMolty>, response: Response<ResponeMolty>) {
                if(response.isSuccessful){
                    val response = response.body()
                    val dataMolty = response?.results
                    val adapterMolty = MoltyAdapter(dataMolty)
                    recyleView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = adapterMolty
                    }
                }
            }

            override fun onFailure(call: Call<ResponeMolty>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}