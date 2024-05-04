package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FullScreenPreview()
                }
            }
        }
    }
}

@Composable
fun SingleViewQuadrant(text1: String, text2: String, color: Long, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(color))
            //.fillMaxSize()
    ) {
        Text(
            text = text1,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .paddingFromBaseline(bottom = 16.dp)
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify,
            modifier = modifier
        )
    }
}

@Composable
fun ComposeQuadrantApp() {
    val colors = listOf(
        0xFFEADDFF,
        0xFFD0BCFF,
        0xFFB69DF8,
        0xFFF6EDFF
    )

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            SingleViewQuadrant(
                stringResource(R.string.first_text_one),
                stringResource(R.string.first_text_two),
                colors[0],
                modifier = Modifier.weight(1f)
            )
            SingleViewQuadrant(
                stringResource(R.string.second_text_one),
                stringResource(R.string.second_text_two),
                colors[1],
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            SingleViewQuadrant(
                stringResource(R.string.third_text_one),
                stringResource(R.string.third_text_two),
                colors[2],
                modifier = Modifier.weight(1f)
            )
            SingleViewQuadrant(
                stringResource(R.string.fourth_text_one),
                stringResource(R.string.fourth_text_two),
                colors[3],
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun FullScreenPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}