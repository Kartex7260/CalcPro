package kanti.calcpro.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun SecondaryCalcButton(
	modifier: Modifier = Modifier,
	buttonSize: Dp = ButtonDefaults.MinHeight,
	contentRatio: Float = 1f,
	text: String = "",
	onClick: () -> Unit
) = Button(
	onClick = onClick,
	colors = ButtonDefaults.buttonColors(
		containerColor = MaterialTheme.colorScheme.secondary,
		contentColor = MaterialTheme.colorScheme.onSecondary
	),
	modifier = modifier
		.height(buttonSize)
		.width(buttonSize)
) {
	Text(
		text = text,
		modifier = Modifier.scale(contentRatio)
	)
}

@Preview
@Composable
fun PreviewSecondaryCalcButton() {
	SecondaryCalcButton {

	}
}