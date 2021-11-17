package com.example.insomniac.ui.dashboard

import android.app.Application
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.insomniac.R
import com.example.insomniac.databinding.FragmentDashboardBinding
import com.example.insomniac.model.UserViewModel
import com.example.insomniac.model.stats.StatsAwake
import java.text.SimpleDateFormat
import com.example.insomniac.model.user.User
import androidx.lifecycle.ViewModelProvider
import com.example.insomniac.model.stats.StatsSleep
import java.nio.file.Files.size


class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
//    private var run = true
    lateinit var awake: StatsAwake
    lateinit var userviewmodel: UserViewModel;
    lateinit var user: List<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        StartAwake(view)

        userviewmodel = UserViewModel(requireActivity().application)
        user = userviewmodel.getAllUsers()
        val myuser: User = user.get(0)
        val name: String = myuser.name
        val tempUsername: TextView = view.findViewById(R.id.greetUser)
        tempUsername.setText("Hi " + name + "!")

        lateinit var sleep: List<StatsSleep>
        lateinit var awake2: List<StatsAwake>
//        val time_awake = userviewmodel.getLastStatsAwake()
        sleep= userviewmodel.getLastStatsSleep()
        awake2= userviewmodel.getLastStatsAwake()
//        if (sleep.size ==0 || awake2.size==0){
//            //TODO
//        }else{
//            val aslp: StatsSleep=sleep.get(sleep.size-1)
//            val aslp_val:String = aslp.CurrentStopTime
//            val aslptest: TextView = view.findViewById(R.id.Time_Slp)
////            aslptest.setText(""+ aslp_val+"")
//
//            val awake_: StatsAwake=awake2.get(sleep.size-1)
//            val awake_val:String = awake_.CurrentStartTime
//            val starttest: TextView = view.findViewById(R.id.Time_Slp)
////            Log.i("Testing",aslp_val)
////            starttest.setText(""+ awake_val+"")
//        }

//        val stopstime: String = aslp.CurrentStopTime

//        Log.i("Testing",stopstime)

//        val myuser: User = user.get(0)
//        val name: String = myuser.name
//        val tempUsername: TextView = view.findViewById(R.id.greetUser)
//        tempUsername.setText("Hi " + name + "!")


        val sdf = SimpleDateFormat("dd/M/yyyy")
        val sdf2 = SimpleDateFormat(" hh:mm:ss a")
        val c = Calendar.getInstance()
        val currentTime=sdf2.format(c.time).toString()
        val currentDate=sdf.format(c.time).toString()


        view.findViewById<Button>(R.id.start_sleep).setOnClickListener {
            userviewmodel = UserViewModel(requireActivity().application)
            awake=StatsAwake(0,currentDate,currentTime)
            userviewmodel.insertAwake(awake)
//            run=false;
            findNavController().navigate(R.id.action_navigation_dashboard_to_dashboardFragment2)
        }
    }

//    override fun onPause() {
//        super.onPause()
//        view?.let { StartAwake(it) }
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        view?.let { StartAwake(it) }
//    }

//    private fun StartAwake(view: View)= Thread {
//        var seconds=0
//        while (run) {
//            try {
//                Thread.sleep(1000)
//                Handler(Looper.getMainLooper()).post {
//
//                    seconds += 1
//                    var hours = seconds/3600
//                    var minutes=(seconds%3600)/60
//                    var seconds2=(seconds%60)
//                    Log.i("test",hours.toString()+" "+minutes.toString()+" "+seconds.toString()+" "+seconds2.toString())
//                    val showCount=view.findViewById<TextView>(R.id.Time_Awake)
//                    showCount.text=(hours.toString()+":"+minutes.toString()+":"+seconds2.toString() )
//                }
//            } catch (e: Exception) {
//            }
//        }
//    }.start()


//    override fun onDestroyView() {
//        super.onDestroyView()
////        _binding = null
//    }
}
