package com.example.insomniac.ui.dashboard

import android.icu.util.Calendar
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.insomniac.R
import com.example.insomniac.databinding.FragmentDashboard2Binding
import java.lang.Exception
import java.text.SimpleDateFormat

class DashboardFragment2 : Fragment() {
    private var _binding: FragmentDashboard2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val run = true //set it to false if you want to stop the timer
//    private val mHandler = Handler()

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
}