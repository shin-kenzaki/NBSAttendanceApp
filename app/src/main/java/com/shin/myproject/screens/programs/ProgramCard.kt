

package com.vpmobiledev.nbscollege.screens.programs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ViewCompact
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProgramCard(program: ProgramList,
                navController: NavController
                ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp),
         elevation = CardDefaults.cardElevation(
            defaultElevation =  10.dp,
        ),
        content = {
            Text(program.name, modifier = Modifier.padding(16.dp))
            Text(program.shortDescription, modifier = Modifier.padding(16.dp))
            Button(
                onClick = {
                    navController.navigate(program.route)
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
                    Text("Read More", fontSize = 19.sp, modifier = Modifier.padding(1.dp))
                    Icon(
                        Icons.Rounded.ViewCompact,
                        contentDescription = "View Detail Screen"
                    )
                }
            }
        }
    )
}
