package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.ui.theme.FirstAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            FirstAppTheme {
                AppNav()
            }
        }

    }
}

@Composable
fun ArticleScreen(onNavigate: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ){
        Image(painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .height(180.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.article_title))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.article_intro))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.article_body))

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        Button(onClick = onNavigate) {
            Text(text = "->")
        }
    }
}


@Composable
fun CompletedScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_task_completed), // файл в drawable
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(id = R.string.all_tasks_completed),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.nice_work),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "article") {
        composable("article") { ArticleScreen(onNavigate = { navController.navigate("completed") }) }
        composable("completed") { CompletedScreen() }
    }
}