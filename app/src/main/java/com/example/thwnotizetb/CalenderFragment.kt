package com.example.thwnotizetb

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.example.thwnotizetb.databinding.FragmentCalenderBinding
import java.util.*


class CalenderFragment : Fragment() {

    private var _binding: FragmentCalenderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCalenderBinding.inflate(inflater, container, false)
        return binding.root
    }


    val cal = Calendar.getInstance()

    val title = binding.etTermin
    val beschreibung = binding.etBeschreibung
    val ort = binding.etOrt

    val hinzufuegen = binding.addBt

    .setOnClickListener {
        addEvent(title.text.toString(), ort.text.toString(), beschreibung.text.toString(), cal.timeInMillis, cal.timeInMillis + 1800000);
    }

}

fun addEvent(title: String, location: String, description: String, begin: Long, end: Long) {

    val intent = Intent(Intent.ACTION_INSERT)


        .putExtra(CalendarContract.Events.TITLE, title)
        .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
        .putExtra(CalendarContract.Events.DESCRIPTION, description)
        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
        .setDataAndType(CalendarContract.Events.CONTENT_URI,"vnd.android.cursor.dir/event" )



    startActivity(intent)
}




















