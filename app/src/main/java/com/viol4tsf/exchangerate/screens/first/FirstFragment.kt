package com.viol4tsf.exchangerate.screens.first

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.viol4tsf.exchangerate.R
import com.viol4tsf.exchangerate.data.repository.Repository
import kotlinx.android.synthetic.main.fragment_first.view.*
import java.text.SimpleDateFormat
import java.util.*

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_first, container, false)

        val repository = Repository()
        val viewModelFactory = FirstViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FirstViewModel::class.java)
        viewModel.getCash()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response->
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val date: Date = formatter.parse(response.Timestamp) as Date
            v.lastUpdateTextView.text = DateFormat.format("yyyy-MM-dd HH:mm:ss", date)

            v.USDCodeTextView.text = response.Valute.USD.CharCode
            v.USDnameTextView.text = response.Valute.USD.Name
            v.USDbuyTextView.text = String.format("%.3f", response.Valute.USD.Value)
            v.USDdiffTextView.text = String.format("%.3f",(response.Valute.USD.Value - response.Valute.USD.Previous))

            v.EURCodeTextView.text = response.Valute.EUR.CharCode
            v.EURnameTextView.text = response.Valute.EUR.Name
            v.EURbuyTextView.text = String.format("%.3f", response.Valute.EUR.Value)
            v.EURdiffTextView.text = String.format("%.3f",(response.Valute.EUR.Value - response.Valute.EUR.Previous))

            v.CNYCodeTextView.text = response.Valute.CNY.CharCode
            v.CNYnameTextView.text = response.Valute.CNY.Name
            v.CNYbuyTextView.text = String.format("%.3f", response.Valute.CNY.Value/10)
            v.CNYdiffTextView.text = String.format("%.3f",(response.Valute.CNY.Value/10 - response.Valute.CNY.Previous/10))

            v.SEKCodeTextView.text = response.Valute.SEK.CharCode
            v.SEKnameTextView.text = response.Valute.SEK.Name
            v.SEKbuyTextView.text = String.format("%.3f", response.Valute.SEK.Value/10)
            v.SEKdiffTextView.text = String.format("%.3f",(response.Valute.SEK.Value/10 - response.Valute.SEK.Previous/10))
        })

        return v
    }

}