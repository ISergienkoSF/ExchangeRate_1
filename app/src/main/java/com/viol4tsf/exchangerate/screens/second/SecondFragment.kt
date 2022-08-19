package com.viol4tsf.exchangerate.screens.second

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.viol4tsf.exchangerate.R
import com.viol4tsf.exchangerate.data.repository.Repository
import com.viol4tsf.exchangerate.screens.first.FirstViewModel
import com.viol4tsf.exchangerate.screens.first.FirstViewModelFactory
import kotlinx.android.synthetic.main.fragment_second.view.*
import java.text.SimpleDateFormat
import java.util.*

class SecondFragment : Fragment() {

    private lateinit var viewModel: SecondViewModel

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_second, container, false)

        val repository = Repository()
        val viewModelFactory = SecondViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
        viewModel.getCash()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response->
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val date: Date = formatter.parse(response.Timestamp) as Date
            v.lastUpdateTextView.text = DateFormat.format("yyyy-MM-dd HH:mm:ss", date)

            v.KZTCodeTextView.text = response.Valute.KZT.CharCode
            v.KZTnameTextView.text = response.Valute.KZT.Name
            v.KZTbuyTextView.text = String.format("%.3f", response.Valute.KZT.Value/100)
            v.KZTdiffTextView.text = String.format("%.3f",(response.Valute.KZT.Value/100 - response.Valute.KZT.Previous/100))

            v.BYNCodeTextView.text = response.Valute.BYN.CharCode
            v.BYNnameTextView.text = response.Valute.BYN.Name
            v.BYNbuyTextView.text = String.format("%.3f", response.Valute.BYN.Value)
            v.BYNdiffTextView.text = String.format("%.3f",(response.Valute.BYN.Value - response.Valute.BYN.Previous))

            v.UAHCodeTextView.text = response.Valute.UAH.CharCode
            v.UAHnameTextView.text = response.Valute.UAH.Name
            v.UAHbuyTextView.text = String.format("%.3f", response.Valute.UAH.Value/10)
            v.UAHdiffTextView.text = String.format("%.3f",(response.Valute.UAH.Value/10 - response.Valute.UAH.Previous/10))

            v.KGSCodeTextView.text = response.Valute.KGS.CharCode
            v.KGSnameTextView.text = response.Valute.KGS.Name
            v.KGSbuyTextView.text = String.format("%.3f", response.Valute.KGS.Value/100)
            v.KGSdiffTextView.text = String.format("%.3f",(response.Valute.KGS.Value/100 - response.Valute.KGS.Previous/100))
        })

        return v
    }
}