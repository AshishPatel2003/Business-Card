package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Card("Ashish Kumar Patel", "+91 75679 56523", "@AndroidDev", "ashishkumarpatel2003@gmail.com")
                }
            }
        }
    }
}

@Composable
fun Card(name: String, phoneno: String, share: String, email: String){

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFF073042))
    ) {
        Spacer(modifier = Modifier.height(180.dp))
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = null, modifier = Modifier.height(60.dp))
            Text(text = "android", fontSize = 24.sp, color = Color.White, fontFamily = FontFamily(Font(R.font.poppins_regular)))
            Text(text = name, fontSize = 40.sp, color = Color.White)
            Text(text = "Android Developer Extraordinaire", color = Color(0xFF3ddc84), fontWeight = FontWeight.SemiBold)
        }
        Spacer(modifier = Modifier.height(180.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            Details(Icons.Default.Phone, Color(0xFF3ddc84), phoneno)
            Details(Icons.Default.Share, Color(0xFF3ddc84), share)
            Details(Icons.Default.Email, Color(0xFF3ddc84), email)
        }
    }
}

@Composable
fun Details(icon: ImageVector, color: Color, value: String){
    Divider(color = Color(0xFF3d687b), thickness = 2.dp)
//    Spacer(modifier = Modifier.height(2.dp))
    Row(
        modifier = Modifier
            .padding(start = 35.dp, end = 35.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth()
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(26.dp))
        Text(text = value, fontSize = 17.sp, color = Color.White, modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 0.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Card("Ashish Kumar Patel", "+91 75679 56523", "@AndroidDev", "ashishkumarpatel2003@gmail.com")
    }
}