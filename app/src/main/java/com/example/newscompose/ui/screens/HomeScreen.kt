package com.example.newscompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newscompose.ui.components.Loader
import com.example.newscompose.ui.components.NewsList
import com.example.newscompose.ui.components.TextNormalCompose
import com.example.newscompose.ui.viewmodels.NewsViewModel
import com.example.utilities.ResourceState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val state by newsViewModel.state.collectAsState()

    val pageState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(
        state = pageState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page ->
        when (state) {
            is ResourceState.Loading -> {
                Loader()
            }

            is ResourceState.Success -> {
                val response = (state as ResourceState.Success).data
                NewsList(response, page)
            }

            is ResourceState.Error -> {
                val errorMessage = (state as ResourceState.Error).error
                TextNormalCompose(errorMessage)
            }
        }


    }


}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

