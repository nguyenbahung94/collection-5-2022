package com.example.buildexample82022.utils

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.location.Location
import android.net.Uri
import android.text.InputType
import android.text.format.DateFormat
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.buildexample82022.HiltApplication
import com.example.buildexample82022.R
import com.google.android.gms.maps.model.LatLng
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.Normalizer
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

private val stripAccentsRegex = "\\p{InCombiningDiacriticalMarks}+".toRegex()
val appDateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())

object AppUtils {
    val DATE_FORMAT = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    fun removeAccent(str: String?): String {
        if (str == null) return ""
        return Normalizer.normalize(str, Normalizer.Form.NFD).replace(stripAccentsRegex, "")
    }
    fun getDayOfWeek(date: Date?, context: Context, isShortDate: Boolean = false): String {
        if (date == null) {
            return ""
        } else {
            val calendar = Calendar.getInstance()
            calendar.time = date
            val day: String = if (isShortDate) {
                when (calendar.get(Calendar.DAY_OF_WEEK)) {
                    Calendar.SUNDAY -> "CN"
                    Calendar.MONDAY -> "T2"
                    Calendar.TUESDAY -> "T3"
                    Calendar.WEDNESDAY -> "T4"
                    Calendar.THURSDAY -> "T5"
                    Calendar.FRIDAY -> "T6"
                    else -> "T7"
                }
            } else {
                when (calendar.get(Calendar.DAY_OF_WEEK)) {
                    Calendar.SUNDAY -> context.getString(R.string.sunday)
                    Calendar.MONDAY -> context.getString(R.string.monday)
                    Calendar.TUESDAY -> context.getString(R.string.tuesday)
                    Calendar.WEDNESDAY -> context.getString(R.string.wednesday)
                    Calendar.THURSDAY -> context.getString(R.string.thursday)
                    Calendar.FRIDAY -> context.getString(R.string.friday)
                    else -> context.getString(R.string.saturday)
                }
            }
            return day
        }
    }

    fun showMonth(date: Date, context: Context): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val month: String
        month = when (calendar.get(Calendar.MONTH)) {
            Calendar.JANUARY -> context.getString(R.string.jan)
            Calendar.FEBRUARY -> context.getString(R.string.feb)
            Calendar.MARCH -> context.getString(R.string.mar)
            Calendar.APRIL -> context.getString(R.string.apr)
            Calendar.MAY -> context.getString(R.string.may)
            Calendar.JUNE -> context.getString(R.string.jun)
            Calendar.JULY -> context.getString(R.string.jul)
            Calendar.AUGUST -> context.getString(R.string.aug)
            Calendar.SEPTEMBER -> context.getString(R.string.sep)
            Calendar.OCTOBER -> context.getString(R.string.oct)
            Calendar.NOVEMBER -> context.getString(R.string.nov)
            else -> context.getString(R.string.dec)
        }

        return "$month.${calendar.get(Calendar.YEAR)}"
    }
    fun dpToPx(dp: Int): Int {
        val displayMetrics = HiltApplication.applicationContext().resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }

    fun isCurrentDate(date: Date): Boolean {
        val current = Calendar.getInstance()
        val format1 = DATE_FORMAT.format(current.time)
        val format2 = DATE_FORMAT.format(date)
        return format1 == format2
    }

    fun calculateDistance(start: LatLng, end: LatLng?): Float? {
        return if (end != null) {
            val p1 = Location("")
            p1.latitude = start.latitude
            p1.longitude = start.longitude

            val p2 = Location("")
            p2.latitude = end.latitude
            p2.longitude = end.longitude

            p1.distanceTo(p2)
        } else
            null
    }

    fun isFutureTime(date: String?): Boolean {
        return if (date.isNullOrEmpty()) {
            false
        } else {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
            val now = Calendar.getInstance()
            val appStartTime = Calendar.getInstance()
            appStartTime.time = sdf.parse(date)
            appStartTime.after(now)
        }
    }

    fun isDateInRange(startDate: Date, endDate: Date, checkDate: Date): Boolean {
        val start = Calendar.getInstance()
        start.time = startDate
        start.set(Calendar.HOUR_OF_DAY, 0)
        start.set(Calendar.MINUTE, 0)
        start.set(Calendar.SECOND, 0)

        val end = Calendar.getInstance()
        end.time = endDate
        end.set(Calendar.HOUR_OF_DAY, 23)
        end.set(Calendar.MINUTE, 0)
        end.set(Calendar.SECOND, 0)

        val check = Calendar.getInstance()
        check.time = checkDate
        check.set(Calendar.SECOND, 30)
        return (check.after(start)) and (check.before(end))
    }

    fun isDateAfter(startDate: Date, checkDate: Date): Boolean {
        val start = Calendar.getInstance()
        start.time = startDate
        start.set(Calendar.HOUR_OF_DAY, 0)
        start.set(Calendar.MINUTE, 0)
        start.set(Calendar.SECOND, 0)

        val check = Calendar.getInstance()
        check.time = checkDate
        check.set(Calendar.SECOND, 30)
        return (check.after(start))
    }

    fun showCalendarDate(date: Date, context: Context): String {
        val dayOfWeek = getDayOfWeek(date, context)
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        return "$dayOfWeek, ${sdf.format(date)}"
    }


    fun formatDate(dateStr: String?, fromPattern: String, toPattern: String): String {
        return if (dateStr.isNullOrEmpty()) {
            ""
        } else {
            try {
                val formatter = SimpleDateFormat(fromPattern, Locale.getDefault())
                val date = formatter.parse(dateStr)
                DateFormat.format(toPattern, date).toString()
            } catch (e: Exception) {
                ""
            }
        }
    }

    fun formatDate(date: Date?, toPattern: String): String {
        return if (date == null)
            ""
        else {
            try {
                val formatter = SimpleDateFormat(toPattern, Locale.getDefault())
                formatter.format(date)
            } catch (e: Exception) {
                ""
            }
        }
    }

    fun getCurrentDate(pattern: String, hour: Int = 0): String {
        val sdf = SimpleDateFormat(pattern, Locale.US)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.HOUR, hour)
        return sdf.format(calendar.time)
    }

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun formatDoubleToString(double: Double): String {
        val df = DecimalFormat("##.##")
        df.roundingMode = RoundingMode.CEILING
        df.decimalFormatSymbols = DecimalFormatSymbols(Locale.US)
        return df.format(double)
    }

    fun sendSMS(context: Context, phone: String?) {
        phone?.let {
            val smsIntent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", it, null))
            if (smsIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(smsIntent)
            }
        }
    }

    fun callPhone(context: Context, phone: String?) {
        phone?.let {
            val smsIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$it"))
            context.startActivity(smsIntent)
        }
    }

    fun hideKeyBroad(view: View) {
        val inputMethod =
            view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethod.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun convertLongToTime(time: String): String {
        val date = appDateFormatter.parse(time)
        return DateFormat.format("HH:mm", date).toString()
    }

    fun converLongToDate(timestamp: String): String {
        val date = appDateFormatter.parse(timestamp)
        return DateFormat.format("dd/MM/yyyy", date).toString()
    }

    fun displayDateTime(timestamp: String): String {
        return "${getDate(timestamp)}  •  ${getTime(timestamp)}"
    }

    fun displayDateTimeRange(startTimestamp: String, endTimestamp: String): String {
        return "${getDate(startTimestamp)}  •  ${getTime(startTimestamp)} - ${getTime(endTimestamp)}"
    }

    private fun getDate(value: String): String {
        return converLongToDate(value)
    }

    private fun getTime(value: String): String {
        val time = value.split("T")[1]
        return time.substringBeforeLast(':')
    }


    fun disableEditEdittext(context: Context, edt: EditText) {
        edt.inputType = InputType.TYPE_NULL
        edt.isFocusable = false
        edt.setOnClickListener {
            Toast.makeText(
                context,
                "Has disableEditEdittext",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun isValidDate(value: String): Boolean {
        val checkDate: Date? =
            try {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dateFormat.isLenient = false
                dateFormat.parse(value)
            } catch (ex: Exception) {
                null
            }
        return checkDate != null
    }


    fun ellipsizeFromStart(
        textHolder: TextView,
        viewWidth: Int,
        content: String?,
        maxLines: Int = 2
    ) {
        val width = viewWidth * maxLines
        if (width > 0 && content != null) {
            val bound = Rect()
            textHolder.paint.getTextBounds("M", 0, 1, bound)
            val totalChars = width / bound.width()
            val startIndex = content.length - totalChars + 3
            if (content.length > totalChars && startIndex < content.length) {
                textHolder.text = "…" + content.substring(startIndex).trim()
            } else {
                textHolder.text = content
            }
        } else {
            textHolder.text = content
        }
    }


}
