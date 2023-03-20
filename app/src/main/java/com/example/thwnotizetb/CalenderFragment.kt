package com.example.thwnotizetb

import android.content.ContentValues
import android.content.Context
import android.media.metrics.Event
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


    //Kalender ID abrufen
   private fun getCalender(context: Context): Long {

        val projection = arrayOf(CalendarContract.Calendars._ID)
        val uri: Uri = CalendarContract.Calendars.CONTENT_URI

        context.contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
            val calendarIdIndex: Int = cursor.getColumnIndexOrThrow(CalendarContract.Calendars._ID)
            if (cursor.moveToNext()) {
                return cursor.getLong(calendarIdIndex)
            }
        }
        //wenn keine Kaleender-Id gefunden wurde
        throw RuntimeException("Kein Kalender gefunden")
   }

        //Erstellen von Termin im Gerätekalender mit der Kalender-ID und Termindetails
    fun createEvent(context: Context, event: Event) {
           // var timeStart = startDate
          //  var timeEnd = endDate
            var title = binding.etTermin
            var description = binding.etBeschreibung
            var eventLocation = binding.etOrt


              fun addEvent(toString: String, toString1: String, toString2: String) {

              }
                    fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                     super.onViewCreated(view, savedInstanceState)
                    binding.addBt.setOnClickListener {addEvent(
                        title.text.toString(),
                        eventLocation.text.toString(),
                        description.text.toString(),
                       // timeStart.startDate.timeInMillis,
                       // timeEnd.endDate.timeInMillis + 1800000
                    ) }
                    }
                    val values = ContentValues().apply {
                        //put(CalendarContract.Events.DTSTART, timeStart)
                        //put(CalendarContract.Events.DTEND, timeEnd)
                        put(CalendarContract.Events.TITLE, "title")
                        put(CalendarContract.Events.EVENT_LOCATION, "eventLocation")
                        put(CalendarContract.Events.DESCRIPTION, "description")
                        put(CalendarContract.Events.CALENDAR_ID, "calender_id")
                        put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().id)
                    }
                    context.contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)
            }
    }









































































