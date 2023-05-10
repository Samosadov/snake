package com.example.snake

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.snake.drawer.Drawer
import com.example.snake.game.Keys
import com.example.snake.game.SnakeGame
import com.example.snake.results.RecorderImpl

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btnStop: Button
    private lateinit var btnUp: Button
    private lateinit var btnRight: Button
    private lateinit var btnDown: Button
    private lateinit var btnLeft: Button
    private lateinit var board: SurfaceView
    private lateinit var game: SnakeGame

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
        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        btnStop = rootView.findViewById(R.id.btnStop)
        btnUp = rootView.findViewById(R.id.btnUp)
        btnRight = rootView.findViewById(R.id.btnRight)
        btnDown = rootView.findViewById(R.id.btnDown)
        btnLeft = rootView.findViewById(R.id.btnLeft)
        board = rootView.findViewById(R.id.board)
        game = SnakeGame()
        game.createGame()
//        val drawer: Drawer() TODO
        return rootView
    }

    private fun addListenerOnButton(button: Button?) {
        button?.setOnClickListener {
            when (button) {
                btnUp -> { game.keyPress(Keys.btnUp) }
                btnRight -> { game.keyPress(Keys.btnRight) }
                btnDown -> { game.keyPress(Keys.btnDown) }
                btnLeft -> { game.keyPress(Keys.btnLeft) }
                btnStop -> {
//                    TODO Проверка и запись рекорда
                    Navigation.createNavigateOnClickListener(R.id.inputFragment, null)
                    getActivity()?.supportFragmentManager?.popBackStack()
                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}