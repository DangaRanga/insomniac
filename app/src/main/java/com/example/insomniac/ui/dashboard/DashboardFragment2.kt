package com.example.insomniac.ui.dashboard

import android.icu.util.Calendar
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.insomniac.R
import com.example.insomniac.databinding.FragmentDashboard2Binding
import java.lang.Exception
import java.text.SimpleDateFormat

class DashboardFragment2 : Fragment() {
    private var _binding: FragmentDashboard2Binding? = null

    private val binding get() = _binding!!
    private var run = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboard2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentDateTime(view)
        StartTime(view)
        view.findViewById<Button>(R.id.stop_sleep).setOnClickListener {
            run=false;
            findNavController().navigate(R.id.action_dashboardFragment2_to_navigation_dashboard)
        }
    }

    private fun currentDateTime(view: View)= Thread {
        while (run) {
            try {
                Thread.sleep(10)
                Handler(Looper.getMainLooper()).post {
                    val c = Calendar.getInstance()
                    val fullTime = SimpleDateFormat("hh:mm a").format(c.time)
//                    val full_date=SimpleDateFormat("EEE").format(c.getTime())+" "+SimpleDateFormat("MMMM").format(c.getTime())+" "+SimpleDateFormat("d").format(c.getTime())+","+SimpleDateFormat("yyyy").format(c.getTime())
                    val showView=view.findViewById<TextView>(R.id.text_dashboard2)
                    showView.text=fullTime.toString()
                }
            } catch (e: Exception) {
            }
        }
    }.start()

    private fun StartTime(view: View)= Thread {
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
                    val showCount=view.findViewById<TextView>(R.id.Time_Slp2)
                    showCount.text=(hours.toString()+":"+minutes.toString()+":"+seconds2.toString())
                }
            } catch (e: Exception) {
            }
        }
    }.start()
}