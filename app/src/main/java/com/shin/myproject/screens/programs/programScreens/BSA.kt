package com.vpmobiledev.nbscollege.screens.programs.programScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BSAScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "Bachelor Of Science In Accountancy",
            style = TextStyle(fontSize = 24.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            "Become an accounting expert with the Bachelor of Science in Accountancy (BSA) program. Designed to equip aspiring accountants with fundamental skills in general accounting, this program shapes the students to become analytical, logical, and detailed-oriented professionals in the business field. BSA graduates can further pursue a professional career in accountancy by taking the licensure exam to become Certified Public Accountant (CPA).",
            style = TextStyle(fontSize = 24.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            "Career Opportunities: ",
            style = TextStyle(fontSize = 24.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text("Auditor\n" +
            "Budget Analyst\n" +
            "Cost Estimator\n" +
            "Tax Examiner\n ",
            style = TextStyle(fontSize = 20.sp, color = Color.Black)
        )
        Button(
            onClick = {
//                navController.navigate(SubjectsRoute.ProgramListScreen.name)
            },
            modifier = Modifier
                .absolutePadding(
                    left = 40.dp,
                    right = 40.dp,
                    bottom = 25.dp,
                    top = 25.dp
                )
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Back to Programs", fontSize = 19.sp, modifier = Modifier.padding(1.dp))
            }
        }
    }
}