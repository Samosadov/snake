package com.example.snake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.snake.results.RecorderImpl

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InputFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var button: Button
    private lateinit var edittext: EditText

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
        val rootView = inflater.inflate(R.layout.fragment_input, container, false)
        edittext = rootView.findViewById(R.id.ed_name)
        button = rootView.findViewById(R.id.btnOk)
        addListenerOnButton(button)
        return rootView
    }

    private fun addListenerOnButton(button: Button?) {
        button?.setOnClickListener({
            RecorderImpl().update(edittext.text.toString(), 0)
            getActivity()?.supportFragmentManager?.popBackStack()
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}