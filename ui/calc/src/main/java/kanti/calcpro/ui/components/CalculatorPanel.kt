package kanti.calcpro.ui.components

import android.content.res.Configuration
import androidx.annotation.IntRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kanti.calcpro.core.CalcElement

enum class DeleteType {
	One,
	All
}

@Composable
fun CalculatorPanel(
	modifier: Modifier = Modifier,
	onClick: (CalcElement) -> Unit,
	onDelete: (DeleteType) -> Unit,
	onCalculation: () -> Unit,
	@IntRange(from = 0, to = 100) shapeRatio: Int = 10,
	width: Dp = LocalConfiguration.current.screenWidthDp.dp
) {
	val shape = RoundedCornerShape(
		topStartPercent = shapeRatio,
		topEndPercent = shapeRatio
	)

	Surface(
		modifier = modifier,
		shape = shape
	) {
		val buttonSizeRatio = 0.90f
		val paddingRatio = 0.20f

		val buttonFullSize = width / 4
		val buttonSize = buttonFullSize * buttonSizeRatio
		val padding = buttonFullSize * paddingRatio / 2
		val contentRation = buttonSize / ButtonDefaults.MinHeight

		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					all = padding,
				)
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				SecondaryCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "C"
				) { onDelete(DeleteType.All) }

				OperationCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = ""
				) {  }

				OperationCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = ""
				) {  }

				OperationCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "/"
				) { onClick(CalcElement.DIVIDE) }
			}

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = padding),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "1"
				) { onClick(CalcElement.ONE) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "2"
				) { onClick(CalcElement.TWO) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "3"
				) { onClick(CalcElement.THREE) }

				OperationCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "*"
				) { onClick(CalcElement.MULTIPLY) }
			}

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = padding),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "4"
				) { onClick(CalcElement.FOUR) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "5"
				) { onClick(CalcElement.FIVE) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "6"
				) { onClick(CalcElement.SIX) }

				OperationCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "-"
				) { onClick(CalcElement.SUBTRACT) }
			}

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = padding),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "7"
				) { onClick(CalcElement.SEVEN) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "8"
				) { onClick(CalcElement.EIGHT) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "9"
				) { onClick(CalcElement.NINE) }

				OperationCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "+"
				) { onClick(CalcElement.ADD) }
			}

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = padding),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = ","
				) { onClick(CalcElement.COMMA) }

				NumberCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "0"
				) { onClick(CalcElement.ZERO) }

				NumberCalcIconButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					imageVector = Icons.Default.ArrowBack
				) { onDelete(DeleteType.One) }

				MainCalcButton(
					buttonSize = buttonSize,
					contentRatio = contentRation,
					text = "="
				) { onCalculation() }
			}
		}
	}
}

@Preview(
	name = "Standard width",
	uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_UNDEFINED,
)
@Preview(
	name = "Width: 320",
	device = "spec:width=320dp,height=891dp",
)
@Preview(
	name = "Width: 540",
	device = "spec:width=540dp,height=891dp"
)
@Composable
fun PreviewCalculatorPanelLight() {
	CalculatorPanel(
		onClick = {},
		onDelete = {},
		onCalculation = {}
	)
}