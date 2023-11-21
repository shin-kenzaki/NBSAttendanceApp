package com.vpmobiledev.nbscollege.screens.programs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shin.myproject.R

@Composable
fun ProgramsDetailScreen(navController: NavHostController) {
    val programDetailList = listOf(
        ProgramDetail(
            "Bachelor Of Science In Accountancy",
            "Become an accounting expert with the Bachelor of Science in Accountancy (BSA) program. Designed to equip aspiring accountants with fundamental skills in general accounting, this program shapes the students to become analytical, logical, and detailed-oriented professionals in the business field. BSA graduates can further pursue a professional career in accountancy by taking the licensure exam to become Certified Public Accountant (CPA).\n" +
                    "\n",
            listOf("Auditor",
                "Budget Analyst",
                "Cost Estimator",
                "Tax Examiner")
        ),
        ProgramDetail(
            "Bachelor Of Science In Accounting Information System",
            "Innovate the field of accounting with the Bachelor of Science in Accounting Information Systems (BSAIS) program. As a specialized degree, the BSAIS program combines knowledge in business, accounting, and computer systems to help make the accounting processes more efficient with the help of information technology. BSAIS graduates can pursue any career options in accountancy with focus on IT support and are qualified to take assessments leading to certifications in Accounting Information Systems.\n" +
                    "\n",
            listOf("Auditing/Assurance Services",
                "Forensic/Investigative Accounting",
                "Information Technology Services",
                "International Accounting",
                "Personal Financial Planning")
        ),
        ProgramDetail(
            "Bachelor Of Science In Entrepreneurship",
            "Conquer the business world with the Bachelor of Science in Entrepreneurship (BSE) program. This program aims to teach aspiring entrepreneurs in starting and managing a business, identifying business opportunities, and employing entrepreneurial skills necessary to keep the business running. BSE graduates can choose whether to start a small enterprise or pursue employment opportunities in an established business.\n" +
                    "\n",
            listOf("Recruiter",
                "Marketer",
                "Sales development representative",
                "Financial analyst",
                "Sales manager",
                "Business consultant",
                "Financial adviser",
                "Business analyst",)
        ),
        ProgramDetail(
            "Bachelor Of Science In Computer Science",
            "Master the language of technology with the Bachelor of Science in Computer Science (BSCS) program. This program prepares you in designing, writing, and developing algorithmically complex software and hardware designed to perform specific tasks and solve complicated problems. BSCS graduates can look forward to lucrative career options in this technology-driven world.\n" +
                    "\n",
            listOf("Application analyst",
                "Applications developer",
                "Cyber security analyst",
                "Data analyst",
                "Forensic computer analyst",
                "Game designer",
                "Games developer",
                "Machine learning engineer")
        ),
        ProgramDetail(
            "Bachelor Of Science In Tourism Management",
            "Become a world-class tourism professional with the Bachelor of Science in Tourism Management (BSTM) program. This program touches on business, hospitality, and service-oriented aspects of travel and tourism. With tourism being one of the fastest growing sectors both locally and internationally, BSTM graduates can look forward to thriving business opportunities in the tourism industry.\n" +
                    "\n",
            listOf("Area Supervisor",
                "Ground Handling Personnel",
                "Area Manager",
                "Group Coordinator",
                "Administrative Assistant",
                "File Clerk",
                "Airline Purser",
                "Airline Manager",
                "Communications Specialist",
                "Country Manager",
                "Customer Service Representative")
        ),
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.nbslogo),
            contentDescription = "NBS LOGO"
        )
        Text(
            "Welcome to the Program Detail screen",
            style = TextStyle(fontSize = 25.sp, color = Color.Black)
        )
        Text(
            " ",
            style = TextStyle(fontSize = 18.sp, color = Color.Gray)
        )
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            items(programDetailList) { program ->
                ProgramDetailCard(program = program)
            }
        }

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