package com.example.strathweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.strathweather.ui.theme.DarkBlue
import com.example.strathweather.ui.theme.LightGray
import com.example.strathweather.ui.theme.StrathWeatherTheme
import com.example.strathweather.ui.theme.VeryLightGray
import com.example.strathweather.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrathWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        HeaderImage()
        MainInf0()
        InfoTable()
    }
}

@Composable
fun MainInf0(){
    Column(
        modifier = Modifier.padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "11" + '\u00B0',
            color = Yellow,
            fontSize = 48.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
        Text(
            text = "Rainy to Partly Cloudly. \n Winds WSW at 1--15 kph",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 15.dp)
        )
    }
}
@Composable
fun InfoTable(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(
                VeryLightGray
            )
            ){
                Row(Modifier.padding(16.dp)) {
                    InfoItem(
                        iconRes = R.drawable.ic_humidtity,
                        title = "Humidity",
                        subtitle = "85%",
                        modifier = Modifier.weight(1f)
                    )
                    InfoItem(
                        iconRes = R.drawable.ic_sun_full,
                        title = "uv index",
                        subtitle = "2/10",
                        modifier = Modifier.weight(1f)
                    )
                }
                Divider(color = LightGray)
                Row(Modifier.padding(16.dp)) {
                    InfoItem(
                        iconRes =R.drawable.ic_sun_half,
                        title = "Sunset",
                        subtitle = "4.28 PM",
                        modifier = Modifier.weight(1f)
                )
                    InfoItem(
                        iconRes = R.drawable.ic_sun_half,
                        title = "Sunset",
                        subtitle = "4.28 PM",
                        modifier = Modifier.weight(1f)
                    )
            }

    }

}
@Composable
fun InfoItem(iconRes: Int, title: String, subtitle: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_humidtity),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .width(40.dp)
        )
        Column() {
            Text(title, color = Color.Gray)
            Text(subtitle, color= DarkBlue, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun HeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_couple),
        contentDescription = null,
        modifier = Modifier.width(150.dp)
    )
}
@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun DefaultPreview(){
    StrathWeatherTheme() {
        WeatherPage()
    }
}