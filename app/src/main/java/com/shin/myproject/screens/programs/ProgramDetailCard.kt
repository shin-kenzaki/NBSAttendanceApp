package com.vpmobiledev.nbscollege.screens.programs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProgramDetailCard(program: ProgramDetail) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation =  10.dp,
        ),
        content = {
            Text(program.name, style = TextStyle(fontSize = 20.sp, color = Color.Black)
                , modifier = Modifier.padding(16.dp))
            Text(program.fullDetail, style = TextStyle(fontSize = 20.sp, color = Color.Black)
                , modifier = Modifier.padding(16.dp))
            Text(text = "Career Opportunities: ", style = TextStyle(fontSize = 20.sp, color = Color.Black)
                , modifier = Modifier.padding(16.dp)
            )
            program.careers.forEach { career ->
                Text(career, style = TextStyle(fontSize = 18.sp, color = Color.Black)
                    , modifier = Modifier.padding(7.dp))
            }
        }
    )
}
