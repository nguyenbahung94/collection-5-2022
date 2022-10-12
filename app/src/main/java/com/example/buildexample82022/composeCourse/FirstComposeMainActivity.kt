package com.example.buildexample82022.composeCourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildexample82022.composeCourse.ui.theme.BuildExample82022Theme
import kotlinx.coroutines.CoroutineStart

class FirstComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuildExample82022Theme {


        Column(
            modifier = Modifier
                .background(Color.Green)
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .border(5.dp, color = Color.Red)
                .padding(5.dp)
                .border(5.dp, color = Color.Green)
                .padding(5.dp)
                .border(5.dp, color = Color.Yellow)
        ){
            Text(text = "Default1", modifier = Modifier.border(5.dp,Color.Gray)
                .padding(5.dp)
                .offset(20.dp,20.dp)
                .border(5.dp, color = Color.Black)
                .padding(10.dp))

            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Default2",modifier = Modifier.clickable {

            })
        }


        /////////
        /*Row(modifier = Modifier
            .width(200.dp)
            .fillMaxHeight(1f)
            .background(Color.Green),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Hello1")
            Text(text = "Hello2")
            Text(text = "Hello3")
            Text(text = "Hello4")
        }*/

       /* Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround) {
            Text(text = "Hello1")
            Text(text = "Hello2")
            Text(text = "Hello3")
            Text(text = "Hello4")
        }*/

    }
}
