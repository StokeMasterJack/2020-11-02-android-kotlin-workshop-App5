package akw.app5

import akw.app5.ui.App5Theme
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.padding(20.dp)
                ) {
                    MainNav()
                }
            }
        }
    }
}


@Composable
fun MainNav() {

    val nav: NavHostController = rememberNavController()

    val onNav: (route: String) -> Unit = {
        nav.navigate(it)
    }

    NavHost(navController = nav, startDestination = "Screen1") {
        composable("Screen1") { Screen1(onNav) }
        composable("Screen2") { Screen2(onNav) }
        composable("Screen3") { Screen3(onNav) }
    }
}

@Composable
fun VSpace(preferredHeight: Int = 10) {
    Spacer(modifier = Modifier.preferredHeight(preferredHeight.dp))
}

@Composable
fun HSpace(preferredWidth: Int = 10) {
    Spacer(modifier = Modifier.preferredWidth(preferredWidth.dp))
}

@Composable
fun Head(onNav: (screen: String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = { onNav("Screen1") }) {
            Text(
                text = "Screen1"
            )
        }
        HSpace()
        Button(onClick = { onNav("Screen2") }) {
            Text(
                text = "Screen2"
            )
        }
        HSpace()
        Button(onClick = { onNav("Screen3") }) {
            Text(
                text = "Screen3"
            )
        }
    }
}

@Composable
fun Screen1(onNav: (screen: String) -> Unit) {
    Column {
        Head(onNav = onNav)
        Text(text = "Screen1")
    }
}

@Composable
fun Screen2(onNav: (screen: String) -> Unit) {
    Column {
        Head(onNav = onNav)
        Text(text = "Screen3")
    }
}

@Composable
fun Screen3(onNav: (screen: String) -> Unit) {
    Column {
        Head(onNav = onNav)
        Text(text = "Screen2")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App5Theme {
        MainNav()
    }
}