package com.asoftltd.asoftltd.admission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun <E : Enum<E>>  AsAnimatedTabLayout(
    tabItems: List<E>,
    modifier: Modifier = Modifier,
    selectedTabColor: Color = MaterialTheme.colorScheme.onBackground,
    containerColor: Color = Color.Transparent,
    content: @Composable (E) -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Column(modifier = modifier.fillMaxSize()) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = containerColor,
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.fillMaxWidth()
                            .tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        height = if (selectedTabIndex >= 0 && selectedTabIndex < tabItems.size) {
                            4.dp
                        } else {
                            0.dp
                        },
                        color =  if (selectedTabIndex >= 0 && selectedTabIndex < tabItems.size) {
                            selectedTabColor
                        } else {
                            Color.Transparent
                        }
                    )
                },
                modifier = Modifier.weight(1f),

            ) {
                tabItems.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text(
                            text = toSentenceCase(tab.name),
                            color = if (selectedTabIndex == index) selectedTabColor else Color.Gray,
                            overflow = if (selectedTabIndex == index) TextOverflow.Ellipsis else TextOverflow.Visible,
                            maxLines = 1
                        ) },
                    )
                }
            }
            Spacer(Modifier.width(8.dp))

            Button(
                onClick = { /* Handle manage click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text("Manage")
            }
            Spacer(modifier = Modifier.width(16.dp))

            IconButton(
                onClick = { /* Handle add click */ },
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Black
                )
            }
        }

        Spacer(Modifier.height(16.dp))
        content(tabItems[selectedTabIndex])
    }
}