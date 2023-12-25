package com.example.newscompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newscompose.R
import com.example.newscompose.data.entity.Article
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
fun NewsList(response: NewsResponse, page: Int) {
    LazyColumn {


        items(response.articles) { articale ->

            TextNormalCompose(value = articale.author ?: "NA")


        }
    }


}

@Composable
fun NewsRowComponent(page: Int, article: Article) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "Image Title",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.place_holder),
            error = painterResource(id = R.drawable.place_holder)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextHeadingCompose(article.title ?: "Title")

        Spacer(modifier = Modifier.height(10.dp))

        TextNormalCompose(article.description ?: "Description of Article....")

        Spacer(modifier = Modifier.weight(1f))

        AuthorRowComposer(article.author, article.source?.name)
    }
}

@Composable
fun AuthorRowComposer(authorName: String?, sourceName: String?) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 14.dp)
    ) {
        Text(text = authorName ?: "")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = sourceName ?: "")
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
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40
        )
    )
}

@Composable
fun TextHeadingCompose(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewNewsRowComponent() {
    val article = Article(
        author = "Essam Mohamed",
        title = "Essam Mohamed sw",
        description = null,
        url = null,
        urlToImage = "https://www.istockphoto.com/photo/natural-lake-by-the-sea-gm1469950152-500965427",
        publishedAt = null,
        content = null,
        source = null
    )
    NewsRowComponent(page = 0, article = article)

}