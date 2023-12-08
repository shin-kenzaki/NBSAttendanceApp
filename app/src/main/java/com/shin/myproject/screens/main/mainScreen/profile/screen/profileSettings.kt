package com.shin.myproject.screens.main.mainScreen.profile.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.inappmessaging.model.Text as FirebaseText // Avoid naming conflicts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettings(navController: NavController) {
    Column(
        modifier = Modifier.padding(horizontal = 25.dp) // Add padding to the Column
    ) {
        SettingButtons(
            text = "Delete",
            icon = Icons.Default.Delete,
            onClick = { /* Handle delete button click */ }
        )

        SettingButtons(
            text = "Edit",
            icon = Icons.Default.Edit,
            onClick = { /* Handle edit button click */ }
        )
    }
}

@Composable
fun SettingButtons(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 25.dp),
        colors = ButtonDefaults.buttonColors(Color.Red),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = text)
            Icon(imageVector = icon, contentDescription = null)
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}
