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
import java.text.DateFormatSymbols

class StatisticsFragment : Fragment() {

    companion object {
        fun newInstance() = StatisticsFragment()

    }

    private lateinit var viewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statistics_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StatisticsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentDateTime(view)
    }

    /**
     * Calculates sleep efficiency
     * Reference for formula used: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4751425/
     */
    private fun calculatePercentages(view: View){
        // TODO Retrieve these values using the ViewModel to pull from the Room DB
        // These are currently placeholders so the equation could be written
        var totalSleepTime = 0
        var totalRecordingTime = 0

        val sleepEfficiency = (totalSleepTime/totalRecordingTime) * 100
        val deepSleepTime = (totalSleepTime * 0.23)

        val deepSleepView = view.findViewById<TextView>(R.id.statistics_total_sleep_time)
        deepSleepView.text = ("Deep Sleep Time $deepSleepTime")
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
        }
    }
