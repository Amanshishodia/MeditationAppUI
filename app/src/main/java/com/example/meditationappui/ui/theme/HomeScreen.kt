package com.example.meditationappui.ui.theme


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationappui.BottomMenuContent
import com.example.meditationappui.Feature
import com.example.meditationappui.R
import com.example.meditationappui.standardQuadFromTo


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep","Insomnia","Depression"))
            currentMeditation()
            FeatureSection(feature = listOf(
                Feature(
                    title="Sleep Meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                Feature(
                    title="Sleep Meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                Feature(
                    title="Calimg Sound",
                    R.drawable.ic_headphone,
                        Beige1,
                    Beige2,
                    Beige3
                ),
                Feature(
                    title="Night Island",
                    R.drawable.ic_headphone,
                    OrangeYellow1,
                    OrangeYellow2,
                    OrangeYellow3
                ),
            ))

        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun GreetingSection(name: String = "Aman") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Text(
                text = "We wish you have a Good Day !",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp, top = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else
                            DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                  Text(text = chips[it],color= TextWhite)
            }
        }
    }
}
@Composable
fun currentMeditation(
    color: Color= LightRed
){
    Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .padding(15.dp)
        .clip(
            RoundedCornerShape(10.dp)
        )
        .background(color)
        .padding(horizontal = 15.dp, vertical = 20.dp)
        .fillMaxWidth()){
       Column {
           Text(
               text = "Daily Thought",
               style = MaterialTheme.typography.headlineSmall,

               )
           Text(
               text = "Meditation - 3~10 Minutes",
               style = MaterialTheme.typography.bodyMedium,
               color = TextWhite
           )
       }
        Box (contentAlignment = Alignment.Center, modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(
                ButtonBlue
            )
            .padding(10.dp)){
Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription ="play", tint = Color.White, modifier = Modifier.size(16.dp) )
        }
    }
}

@Composable
fun FeatureSection(feature: List<Feature>){
       Column(modifier=Modifier.fillMaxWidth()) {
               Text(text = "Features", style = MaterialTheme.typography.headlineMedium, color = Color.White,
                   modifier = Modifier.padding(15.dp)

               )
           LazyVerticalGrid(columns =GridCells.Fixed(2), contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp), modifier = Modifier.fillMaxHeight() ) {
               items(feature.size){
                   FeatureItem(feature = feature[it])
               }

           }


       }
}
@Composable
fun FeatureItem(
feature: Feature

){
    BoxWithConstraints (modifier= Modifier
        .padding(7.5.dp)
        .aspectRatio(1f)
        .clip(RoundedCornerShape(10.dp))
        .background(feature.darkColor)){
         val width=constraints.maxWidth
        val height=constraints.maxHeight

        val mediumColuredPoint1= Offset(0f,height*0.3f)
        val mediumColuredPoint2= Offset(width*0.1f,height*0.3f)
        val mediumColuredPoint3= Offset(width*0.4f,height*0.05f)
        val mediumColuredPoint4= Offset(width*0.75f,height*0.7f)
        val mediumColuredPoint5= Offset(width*1.4f,-height.toFloat())
        val mediumColuredPath= Path().apply {
            moveTo(mediumColuredPoint1.x,mediumColuredPoint1.y)
            standardQuadFromTo(mediumColuredPoint1,mediumColuredPoint2)
            standardQuadFromTo(mediumColuredPoint2,mediumColuredPoint3)
            standardQuadFromTo(mediumColuredPoint3,mediumColuredPoint4)
            standardQuadFromTo(mediumColuredPoint4,mediumColuredPoint5)
lineTo(width.toFloat()+100f,height.toFloat()+100f)
            lineTo(-100f,height.toFloat()+100f)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(path=mediumColuredPath, color = feature.mediumColor)
            drawPath(path= mediumColuredPath, color = feature.ligitColor)
        }
        Box (modifier= Modifier
            .fillMaxSize()
            .padding(15.dp)){
              Text(text = feature.title, style = MaterialTheme.typography.headlineMedium, lineHeight = 26.sp,modifier=Modifier.align(Alignment.TopStart))
            Icon(painter = painterResource(id = feature.iconId), contentDescription = feature.title,tint= Color.White, modifier = Modifier.align(
                Alignment.BottomStart))
            Text(text = "Start", color= TextWhite, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                .clickable { }
                .align(Alignment.BottomEnd)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(ButtonBlue)
                .padding(vertical = 6.dp, horizontal = 15.dp))
        }
    }

}



@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}