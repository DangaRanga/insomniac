package com.example.insomniac.ui.statistics

import android.icu.util.Calendar
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.insomniac.R
import com.example.insomniac.model.UserViewModel
import com.example.insomniac.model.stats.StatsAwake
import com.example.insomniac.model.stats.StatsSleep
import java.text.DateFormatSymbols

class StatisticsFragment : Fragment() {

    companion object {
        fun newInstance() = StatisticsFragment()

    }

    lateinit var userviewmodel: UserViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statistics_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentDateTime(view)
        displaySleepTime(view)
        // calculatePercentages(view)
    }

    /**
     * Calculates sleep efficiency
     * Reference for formula used: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4751425/
     */
    private fun calculatePercentages(view: View){
        // TODO Retrieve these values using the ViewModel to pull from the Room DB
        // These are currently placeholders so the equation could be write
        var totalRecordingTime = 0

        // val sleepEfficiency = (totalSleepTime/totalRecordingTime) * 100
       // val deepSleepTime = (totalSleepTime * 0.23)

       // val deepSleepView = view.findViewById<TextView>(R.id.statistics_total_sleep_time)
        // deepSleepView.text = ("Deep Sleep Time $deepSleepTime")
    }
    private fun currentDateTime(view: View){
        // Initializing key variables
        val monthName = arrayOf(
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"
        )
        val c = Calendar.getInstance()

        // Retrieve the current month in a readable format
        val month = monthName[c.get(Calendar.MONTH)]
        val day = c.get(Calendar.DATE)

        // Set the date for the main header
        val headerTitleView = view.findViewById<TextView>(R.id.statistics_current_date)
        headerTitleView.text = ("$month $day")


        // Retrieve the day of the week for the first card
        val dayOfWeek: Int = c.get(Calendar.DAY_OF_WEEK)
        val weekday: String = DateFormatSymbols().shortWeekdays[dayOfWeek]
        val subHeaderTitleView = view.findViewById<TextView>(R.id.statistics_current_day)
        subHeaderTitleView.text = (weekday)


        // Update time awake
        var totalSleepTime: List<StatsSleep> = listOf()
        try {
             totalSleepTime = userviewmodel.getLastStatsSleep()
        }catch (e: Exception){
            println("Database is empty")
            totalSleepTime = listOf()
        }


        if( totalSleepTime.isNotEmpty()){
            println(totalSleepTime)
        }
        // val timeAwakeView = view.findViewById<TextView>(R.id.statistics_total_sleep_time)
        }


        private fun displaySleepTime(view: View){
            // Initialize key variables
            var awakeTime: List<StatsAwake> = listOf()
            var totalSleepTime: List<StatsSleep> = listOf()
            //var sleep: List<StatsSleep> = listOf()

            // Attempt to retrieve last sleep time
            try{
                totalSleepTime = userviewmodel.getLastStatsSleep()
            }catch (e: Exception){

            }

            // Attempt to retrieve awake time
            try{
                awakeTime = userviewmodel.getLastStatsAwake()
            }catch(e: Exception){

            }

            if (totalSleepTime.isEmpty() ||  awakeTime.isEmpty()){
                //TODO
            }else{
                val lastSleepTime: StatsSleep =totalSleepTime[totalSleepTime.size-1]
                val lastAwakeTime: StatsAwake = awakeTime[awakeTime.size-1]

                // Retrieve current start time and current stop time
                val sleepStopVal:String = lastSleepTime.CurrentStopTime
                val startAwakeVal: String = lastAwakeTime.CurrentStartTime

                // Show units
                val sleepStopUnits: List<String> = sleepStopVal.split(":")
                val awakeValUnits: List<String> = startAwakeVal.split(":")

                // Extract sleep stop units
                val sleepHours: Int = sleepStopUnits[0].toInt() //first element
                val sleepMinutes: Int = sleepStopUnits[1].toInt()


                // Extract sleep awake units
                val awakeHours: Int = awakeValUnits[0].toInt()
                val awakeMinutes: Int = awakeValUnits[1].toInt()

                // Perform calculation on total time slept
                val timeSlept = (awakeHours + awakeMinutes) - (sleepHours + sleepMinutes)
                println(timeSlept)

                // Perform calculation on deep sleep time
                val deepSleep = timeSlept * 0.23


                // Set respective text views
                val timeAwakeView = view.findViewById<TextView>(R.id.statistics_total_sleep_time)
                timeAwakeView.text = ("Time Slept: $timeSlept.toString()")

                val deepSleepView = view.findViewById<TextView>(R.id.statistics_deep_sleep)
                deepSleepView.text = "Deep Sleep: $deepSleep.toString()"
            }
        }
    }
