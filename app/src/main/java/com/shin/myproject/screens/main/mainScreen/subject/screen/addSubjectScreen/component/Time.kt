package com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.AmPm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun clock(title: String, onTimeSelected: (Int, Int, AmPm) -> Unit) {
    val clockState = rememberSheetState()

    ClockDialog(
        state = clockState,
        config = ClockConfig(
            is24HourFormat = false // Set this to false for 12-hour format
        ),
        selection = ClockSelection.HoursMinutes { hours, minutes ->
            val amPm = if (hours < 12) AmPm.AM else AmPm.PM
            val formattedHours = if (hours > 12) hours - 12 else hours
            Log.d("Selected Time", "$formattedHours:$minutes $amPm")
            onTimeSelected(formattedHours, minutes, amPm)
        }
    )

    Button(
        onClick = { clockState.show() }
    ) {
        Text(text = "Select $title")
    }
}