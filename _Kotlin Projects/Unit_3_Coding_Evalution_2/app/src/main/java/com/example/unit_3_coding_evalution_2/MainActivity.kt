package com.example.unit_3_coding_evalution_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ItemClickListener{
    private lateinit var musicList: List<Result>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiCall("baby");
        etSearchSongs.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString() != "") {
                    Log.d("abhishek", s.toString())
                    apiCall(s.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }


        })
    }


    private fun apiCall(s: String) {
        var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getMusic(s).enqueue(object : Callback<MusicResponse> {
            override fun onResponse(call: Call<MusicResponse>, response: Response<MusicResponse>) {
                response.body()?.run {
                    Log.d("abhi", results[0].artistName);
                    musicList = results
                    setAdapter()
                }
            }

            override fun onFailure(call: Call<MusicResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load!", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setAdapter() {
        var musicAdapter = MusicAdapter(musicList, this);
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.adapter = musicAdapter
        recyclerView.layoutManager = linearLayoutManager
    }

    override fun onCardClicked(result: Result) {
        val intent = Intent(this, MusicPlayActivity::class.java)
        var bundle = Bundle()
        result?.run {
            intent.putExtra("image", artworkUrl100)
            intent.putExtra("trackName", trackName)
            intent.putExtra("artistName", artistName)
            intent.putExtra("collectionName", collectionName)
            intent.putExtra("song", previewUrl)
        }
        startActivity(intent)

    }

}
