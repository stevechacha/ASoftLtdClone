package com.asoftltd.asoftltd.bottomNav

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoftltd.asoftltd.designsystem.theme.AsTheme

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    title: String? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = AsTheme.colors.onBackground,
    unselectedColor: Color = AsTheme.colors.onBackground.copy(alpha = 0.5f),
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    if (alertCount != null && alertCount < 0) {
        throw IllegalArgumentException("Alert count can't be negative")
    }

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(25.dp),
                    tint = if (selected) selectedColor else unselectedColor,
                )
            }
        },
        label = {
            if (title != null) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    fontSize = 8.sp,
                    color = if (selected) selectedColor else unselectedColor,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    style = MaterialTheme.typography.titleMedium

                )
            }
        },
        alwaysShowLabel = true
    )
}