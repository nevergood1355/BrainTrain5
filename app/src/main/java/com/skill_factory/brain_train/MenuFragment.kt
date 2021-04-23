package com.skill_factory.brain_train

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Находим кнопку
        val menu1: View = view.findViewById(R.id.menu1)
        //Вешаем обработчик событий
        menu1.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.root, GameFragment()).addToBackStack(null).commit()
        }
    }
}