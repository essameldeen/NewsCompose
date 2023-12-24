package com.example.newscompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newscompose.data.entity.NewsResponse
import com.example.newscompose.ui.theme.Purple40


@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(70.dp)
                .padding(10.dp),
            color = Purple40
        )
    }

}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {


        items(response.articles) { articale ->

            TextNormalCompose(value = articale.author ?: "NA")


        }
    }

}

@Composable
fun TextNormalCompose(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
    )
}