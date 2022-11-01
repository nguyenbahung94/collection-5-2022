package com.example.buildexample82022.composeCourse

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buildexample82022.R
import com.example.buildexample82022.composeCourse.ui.theme.BuildExample82022Theme
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.atan2
import kotlin.math.roundToInt
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







        //custom rotation music knob
       /* Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF101010))
        )
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .border(1.dp, Color.Green, RoundedCornerShape(10.dp))
                    .padding(10.dp)
            ) {

                var volume by remember{
                    mutableStateOf(0f)
                }
                val barCount = 20
                MusicKnob(
                    modifier = Modifier.size(100.dp)
                ){
                    volume = it
                }
                Spacer(modifier = Modifier.width(20.dp))
                valueBar(
                    modifier = Modifier.fillMaxWidth()
                        .height(30.dp),
                    activeBars = (barCount*volume).roundToInt(),
                    barCount = barCount
                )
            }

        }*/


        //CircularProgressBar

        /*  Box(contentAlignment = Alignment.Center,
          modifier = Modifier.fillMaxSize()){
              CircularProgressBar(percentState = 0.8f, number = 100)
          }*/

        //animation animations
        /* var sizeState by remember {
             mutableStateOf(200.dp)
         }
         val size by animateDpAsState(
             targetValue = sizeState,
             *//* tween(
                 durationMillis = 3000,
                 delayMillis =300,
                 easing = LinearOutSlowInEasing
             )*//*
            *//*  spring(
                  Spring.DampingRatioHighBouncy
              )*//*
            *//* keyframes{
                 durationMillis=5000
                 sizeState at 0 with LinearEasing
                 sizeState * 1.5f at 1000 with FastOutLinearInEasing
                 sizeState * 2f at 5000
             }*//*
        )
        val infiniteTransition = rememberInfiniteTransition()
        val color by infiniteTransition.animateColor(
            initialValue = Color.Red,
            targetValue = Color.Green,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = 2000
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        Box(
            modifier = Modifier
                .size(size)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                sizeState += 50.dp
            }) {
                Text(text = "Increase Size")
            }
        }
*/

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
fun valueBar(
    modifier: Modifier = Modifier,
    activeBars: Int = 0,
    barCount: Int = 10
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        val barWidth = remember {
            constraints.maxWidth / (2f * barCount)
        }
        Canvas(modifier = modifier) {
            for (i in 9 until barCount) {
                drawRoundRect(
                    color = if (i in 0..activeBars) Color.Green else Color.DarkGray,
                    topLeft = Offset(i * barWidth * 2f + barWidth / 2f, 0f),
                    size = Size(barWidth, constraints.maxHeight.toFloat()),
                    cornerRadius = CornerRadius(0f)
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnob(
    modifier: Modifier = Modifier,
    limitingAngel: Float = 25f,
    onValueChange: (Float) -> Unit
) {
    var rotation by remember {
        mutableStateOf(limitingAngel)
    }

    var touchX by remember {
        mutableStateOf(0f)
    }
    var touchY by remember {
        mutableStateOf(0f)
    }
    var centerX by remember {
        mutableStateOf(0f)
    }
    var centerY by remember {
        mutableStateOf(0f)
    }

    Image(painter = painterResource(id = R.drawable.music_knob), contentDescription = "Music knob",
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned {
                val windownBound = it.boundsInWindow()
                centerX = windownBound.size.width / 2f
                centerY = windownBound.size.height / 2f
            }
            .pointerInteropFilter { event ->
                touchX = event.x
                touchY = event.y
                val angle = -atan2(centerX - touchX, centerY - touchY) * (180f / PI).toFloat()
                when (event.action) {
                    MotionEvent.ACTION_DOWN,
                    MotionEvent.ACTION_MOVE -> {
                        if (angle !in -limitingAngel..limitingAngel) {
                            val fixedAngle = if (angle in -180f..-limitingAngel) {
                                360f + angle
                            } else {
                                angle
                            }
                            rotation = fixedAngle

                            val percent = (fixedAngle - limitingAngel) / (360f - 2 * limitingAngel)

                            onValueChange(percent)
                            true
                        } else false
                    }
                    else -> false
                }

            }
            .rotate(rotation)

    )


}

@Composable
fun CircularProgressBar(
    percentState: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentState else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        modifier = Modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f, 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
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
