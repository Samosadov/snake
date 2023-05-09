package com.example.snake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MenuFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var btn_game: Button
    private lateinit var btn_res: Button
    private lateinit var btn_about: Button

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
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)
        btn_game = rootView.findViewById(R.id.btnStart)
        btn_res = rootView.findViewById(R.id.btnResults)
        btn_about = rootView.findViewById(R.id.btnAbout)

        btn_game.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.gameFragment, null))
        btn_res.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.results, null))
        btn_about.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.about, null))

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}