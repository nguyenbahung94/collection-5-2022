package com.example.buildexample82022.utils

import android.content.Context
import android.os.Environment
import android.provider.ContactsContract
import com.example.buildexample82022.R
import java.io.File
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

object Common {
    @JvmStatic
    private fun getFormattedDateAndTime(timestamp: Long?): String? {
        val sameDay = isSameDay(timestamp)
        val date = Date(timestamp!!)
        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val fullDateFormat = SimpleDateFormat("dd MMM")
        try {
            return if (sameDay) {
                simpleDateFormat.format(date)
            } else fullDateFormat.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }


    fun isSameDay(timestamp: Long?): Boolean {
        val calendarForCurrent = Calendar.getInstance()
        val calendarForScheduled = Calendar.getInstance()
        val currentDate = Date()
        val date = Date(timestamp!!)
        calendarForCurrent.time = currentDate
        calendarForScheduled.time = date
        return calendarForCurrent[Calendar.YEAR] == calendarForScheduled[Calendar.YEAR] &&
                calendarForCurrent[Calendar.DAY_OF_YEAR] == calendarForScheduled[Calendar.DAY_OF_YEAR]
    }

    @JvmStatic
    fun isSameYear(timestamp: Long?): Boolean {
        val calendarForCurrent = Calendar.getInstance()
        val calendarForScheduled = Calendar.getInstance()
        val currentDate = Date()
        val date = Date(timestamp!!)
        calendarForCurrent.time = currentDate
        calendarForScheduled.time = date
        return calendarForCurrent[Calendar.YEAR] == calendarForScheduled[Calendar.YEAR]
    }


    @JvmStatic
    fun daysBetween(startDate: Date?, endDate: Date?): Long {
        val sDate = getDatePart(startDate)
        val eDate = getDatePart(endDate)
        var daysBetween: Long = 0
        while (sDate.before(eDate)) {
            sDate.add(Calendar.DAY_OF_MONTH, 1)
            daysBetween++
        }
        return daysBetween
    }


    fun getDatePart(date: Date?): Calendar {
        val cal = Calendar.getInstance() // get calendar instance
        cal.time = date
        cal[Calendar.HOUR_OF_DAY] = 0 // set hour to midnight
        cal[Calendar.MINUTE] = 0 // set minute in hour
        cal[Calendar.SECOND] = 0 // set second in minute
        cal[Calendar.MILLISECOND] = 0 // set millisecond in second
        return cal // return the date part
    }


    @JvmStatic
    fun getAppDirectory(context: Context): File? {
        var picDir: File? = null
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            var appName = context.applicationInfo.loadLabel(context.packageManager).toString()
            if (appName == null || appName.isEmpty()) {
                appName = context.getString(R.string.app_name)
            }
            picDir = File(Environment.getExternalStorageDirectory(), appName)
            if (!picDir.exists()) {
                if (!picDir.mkdirs()) {
                    return context.cacheDir
                }
            }
        }
        if (picDir == null) {
            picDir = context.cacheDir
        }
        return picDir
    }

    // Get all contacts
    fun getContactsFromDevice(context: Context): List<Contact> {
        val contentResolver = context.contentResolver
        val deviceContacts: MutableList<Contact> = ArrayList()
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val phoneNumber = cursor.getString(
                        cursor
                            .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    )
                    val displayName = cursor.getString(
                        cursor
                            .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                    )
                    val contact = Contact()
                    contact.name = displayName
                    contact.phone = phoneNumber
                    deviceContacts.add(contact)
                } while (cursor.moveToNext())
            }
            if (cursor != null && !cursor.isClosed) {
                cursor.close()
            }
        }
        return deviceContacts
    }
}




class Contact : Serializable {
    var name: String? = null
    var phone: String? = null
    var type = 0

    constructor() {}
    constructor(name: String?, phone: String?) {
        this.name = name
        this.phone = phone
    }
}