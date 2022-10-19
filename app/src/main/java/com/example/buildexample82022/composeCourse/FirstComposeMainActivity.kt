package com.example.buildexample82022.composeCourse

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buildexample82022.composeCourse.ui.theme.BuildExample82022Theme
import kotlin.random.Random

class FirstComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DefaultPreview()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuildExample82022Theme {

        //effects
        var text by remember{
            mutableStateOf("")
        }





        //constraintlayout
/*

        val contraints = ConstraintSet {
            val greenBox = createRefFor("greenBox")
            val redBox = createRefFor("redBox")
            val guildLine = createGuidelineFromTop(0.5f)

            constrain(greenBox) {
                top.linkTo(guildLine)
                start.linkTo(parent.start)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            constrain(redBox) {
                top.linkTo(parent.top)
                start.linkTo(greenBox.end)
                end.linkTo(parent.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
            createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
        }
        ConstraintLayout(contraints, modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                    .layoutId("greenBox")
            )
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .layoutId("redBox")
            )
        }
*/


        //list
/*
        LazyColumn{
            itemsIndexed(
                listOf("this","is","jetpack","Compose")
            ){index, item ->
                Text(
                    text = "$item($index)", fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )
            }

        }*/


        /*  //textfield button show sanckbar
          val scaffoldState = rememberScaffoldState()
          var textFieldState by remember {
              mutableStateOf(" ")
          }
          val scope = rememberCoroutineScope()

          Scaffold(
              modifier = Modifier.fillMaxSize(),
              scaffoldState = scaffoldState
          ) {
              Column(
                  horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .fillMaxSize()
                      .padding(horizontal = 30.dp)
              ) {
                  TextField(value = textFieldState, label = {
                      Text("Enter your name")
                  }, onValueChange = {
                      textFieldState = it
                  },
                      singleLine = true,
                      modifier = Modifier.fillMaxWidth()
                  )

                  Spacer(modifier = Modifier.height(15.dp))

                  Box(
                      modifier = Modifier.fillMaxWidth(),
                      contentAlignment = Alignment.CenterEnd
                  ) {
                      Button(onClick = {
                          scope.launch {
                              scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                          }
                      }) {
                          Text(text = "Pls greet me")
                      }
                  }
              }
          }*/

        //state
        /*   Column(Modifier.fillMaxSize()) {

               val color = remember {
                   mutableStateOf(Color.Yellow)
               }
               ColorBox(
                   Modifier
                       .fillMaxSize()
                       .weight(1f)
               ){
                   color.value = it
               }
               Box(
                   modifier = Modifier
                       .background(color = color.value)
                       .weight(1f)
                       .fillMaxSize()
               ) {

               }
           }*/


        /* // style text and custom font style android
         val fontFamily = FontFamily(
             Font(com.example.buildexample82022.R.font.raleway_italic, FontWeight.Medium),
             Font(com.example.buildexample82022.R.font.raleway_regular, FontWeight.Medium),
             Font(com.example.buildexample82022.R.font.raleway_light, FontWeight.Light),
             Font(com.example.buildexample82022.R.font.raleway_medium, FontWeight.Medium),
             Font(com.example.buildexample82022.R.font.raleway_mediumitalic, FontWeight.Medium),
             Font(com.example.buildexample82022.R.font.raleway_semibold, FontWeight.SemiBold)
         )
         Box(
             modifier = Modifier
                 .fillMaxSize()
                 .background(Color(0xFF101010))
         ) {
             Text(
                 text = buildAnnotatedString {
                     withStyle(
                         style = SpanStyle(
                             color = Color.Green,
                             fontSize = 50.sp
                         )
                     ) {
                         append("J")
                     }
                     append("etpack ")
                     withStyle(
                         style = SpanStyle(
                             color = Color.Green,
                             fontSize = 50.sp
                         )
                     ) {
                         append("C")
                     }
                     append("ompose")
                 },
                 color = Color.White,
                 fontSize = 30.sp,
                 fontFamily = fontFamily,
                 fontWeight = FontWeight.Bold,
                 fontStyle = FontStyle.Italic,
                 textAlign = TextAlign.Center,
                 textDecoration = TextDecoration.Underline

             )
         }*/


        /*//show image
        val painter = painterResource(id = com.example.buildexample82022.R.drawable.squirtle)
        val description = "Kermit playing in the snow"
        val title = "kermit is playing in the snow"

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(0.dp, 10.dp, 0.dp, 10.dp)
        ) {
            ImageCard(mpainter = painter, mcontentDescription = description, mtitle = title)
        }*/


        /* Column(
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
         }*/


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

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(modifier = modifier
        .background(color = Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )

        })
}


@Composable
fun ImageCard(
    mpainter: Painter,
    mcontentDescription: String,
    mtitle: String,
    mmodifier: Modifier = Modifier
) {
    Card(
        modifier = mmodifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        backgroundColor = Color.Blue,

        ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = mpainter,
                contentDescription = mcontentDescription,
                contentScale = ContentScale.FillWidth,
                modifier = mmodifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(mtitle, style = TextStyle(color = Color.White, fontSize = 16.sp))

            }
        }

    }
}
