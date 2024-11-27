package com.devkt.practical_exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devkt.practical_exam.ui.theme.Practical_examTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practical_examTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EventEase(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EventEase(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        // Row at the top
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_arrow_back_24),
                contentDescription = null
            )
            Text(
                text = "EventEase",
                modifier = Modifier.padding(start = 10.dp)
            )
            Image(
                painter = painterResource(R.drawable.icons8_share),
                contentDescription = null,
                modifier = Modifier.padding(start = 180.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.event),
            contentDescription = "Event Image",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        )
        Row {
            Text(
                text = "Tech Conference 2024",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        Row {
            Text(
                text = "Mehsana,Gujarat | 2.5 km away",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        Row {
            Text(
                text = "This is a dtailed description of the event...",
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        Row {
            Text(
                text = "Event Schedule",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
        Row {
            HorizontalScrollCardView()
        }
    }
}

@Composable
fun HorizontalScrollCardView() {
    val times = listOf("9 : 00 AM", "10 : 00 AM", "11 : 00 AM")
    val events = listOf("Start\n\nEvent", "Keynote\n\nSpeech", "News\n\nSession")

    val schedule = times.zip(events)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(schedule) { (time, event) ->
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = time,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = event,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practical_examTheme {
        EventEase()
    }
}