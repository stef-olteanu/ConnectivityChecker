package com.example.connectivitychecker

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment


class DataNotEnabledFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_data_not_enabled,container,false)
        val button : Button = view.findViewById(R.id.acceptButton)
        button.setOnClickListener(openNetorkSettings())
        val fragmentBackground : ConstraintLayout = view.findViewById(R.id.fragmentBackground)
        fragmentBackground.setOnClickListener(openNetorkSettings())
        return view
    }

    private fun openNetorkSettings() : View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(Settings.ACTION_DATA_ROAMING_SETTINGS)
            startActivity(intent)
            fragmentManager!!.popBackStack()
        }
    }
}