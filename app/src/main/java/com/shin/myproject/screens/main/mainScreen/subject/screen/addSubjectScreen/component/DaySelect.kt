package com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shin.myproject.data.mainscreenModel.subjectModel.DayListItem

@Composable
fun daySelect(onDaysSelected: (List<DayListItem>) -> Unit) {
    var items by remember {
        mutableStateOf(
            listOf(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
            ).map {
                DayListItem(
                    title = "$it",
                    isSelected = false
                )
            }
        )
    }

    LazyRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(items.size) { i ->
        Row(
                modifier = Modifier
                    .fillMaxWidth(2f)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
            Checkbox(
                checked = items[i].isSelected,
                onCheckedChange = {
                    items = items.mapIndexed { j, item ->
                        if (i == j) {
                            item.copy(isSelected = !item.isSelected)
                        } else item
                    }
                    onDaysSelected(items.filter { it.isSelected })
                },
                    modifier = Modifier.size(24.dp),
                )
                Text(
                    text = items[i].title,
                    modifier = Modifier.size(24.dp),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}