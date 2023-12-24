package com.example.newscompose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newscompose.ui.components.Loader
import com.example.newscompose.ui.components.NewsList
import com.example.newscompose.ui.components.TextNormalCompose
import com.example.newscompose.ui.viewmodels.NewsViewModel
import com.example.utilities.ResourceState


@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val state by newsViewModel.state.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        when (state) {
            is ResourceState.Loading -> {
                Loader()
            }

            is ResourceState.Success -> {
                val response = (state as ResourceState.Success).data
                NewsList(response)
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

