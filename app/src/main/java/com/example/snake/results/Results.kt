package com.example.snake.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.snake.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Results : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_results, container, false)
        button = rootView.findViewById(R.id.btnOk)
        addListenerOnButton(button)
        return rootView
    }

    private fun addListenerOnButton(button: Button?) {
        button?.setOnClickListener({
            // TODO прочитать из таблицы рекордов
//            recorder.read()
            // TODO добавить переход не к предыдущему фрагменту, а в меню
            getActivity()?.supportFragmentManager?.popBackStack()
        })
    }
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Results().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}