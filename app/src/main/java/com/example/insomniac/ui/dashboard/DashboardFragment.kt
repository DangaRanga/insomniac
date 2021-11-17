package com.example.insomniac.ui.dashboard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.insomniac.R
import com.example.insomniac.databinding.FragmentDashboardBinding
import java.lang.Exception


class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private var run = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        StartAwake(view)
        view.findViewById<Button>(R.id.start_sleep).setOnClickListener {
            run=false;
            findNavController().navigate(R.id.action_navigation_dashboard_to_dashboardFragment2)
        }
    }

    private fun StartAwake(view: View)= Thread {
        var seconds=0
        while (run) {
            try {
                Thread.sleep(1000)
                Handler(Looper.getMainLooper()).post {

                    seconds += 1
                    var hours = seconds/3600
                    var minutes=(seconds%3600)/60
                    var seconds2=(seconds%60)
                    Log.i("test",hours.toString()+" "+minutes.toString()+" "+seconds.toString()+" "+seconds2.toString())
                    val showCount=view.findViewById<TextView>(R.id.Time_Awake)
                    showCount.text=(hours.toString()+":"+minutes.toString()+":"+seconds2.toString() )
                }
            } catch (e: Exception) {
            }
        }
    }.start()


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
