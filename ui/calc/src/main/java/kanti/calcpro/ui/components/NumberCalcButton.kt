package kanti.calcpro.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NumberCalcButton(
	modifier: Modifier = Modifier,
	buttonSize: Dp = ButtonDefaults.MinHeight,
	contentRatio: Float = 1f,
	text: String = "",
	onClick: () -> Unit
) = FilledTonalButton(
	onClick = onClick,
	modifier = modifier
		.height(buttonSize)
		.width(buttonSize)
) {
	Text(
		text = text,
		modifier = Modifier.scale(contentRatio)
	)
}

@Composable
fun NumberCalcIconButton(
	modifier: Modifier = Modifier,
	buttonSize: Dp = ButtonDefaults.MinHeight,
	contentRatio: Float = 1f,
	imageVector: ImageVector,
	onClick: () -> Unit
) = FilledTonalIconButton(
	onClick = onClick,
	modifier = modifier
		.height(buttonSize)
		.width(buttonSize)
) {
	Icon(
		imageVector = imageVector,
		contentDescription = null,
		modifier = Modifier.scale(contentRatio)
	)
}

@Preview
@Composable
fun PreviewNumberCalcButton() {
	NumberCalcButton(
		onClick = { /*TODO*/ },
		contentRatio = 1f,
		text = "0"
	)
}

@Preview
@Composable
fun PreviewNumberCalcIconButton() {
	NumberCalcIconButton(
		onClick = { /*TODO*/ },
		imageVector = Icons.Default.Add
	)
}