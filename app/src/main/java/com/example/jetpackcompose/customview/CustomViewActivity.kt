package com.example.jetpackcompose.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Canvas
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.Paint
import androidx.ui.graphics.PaintingStyle
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.tooling.preview.Preview

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is an extension function of Activity that sets the @Composable function that's
        // passed to it as the root view of the activity. This is meant to replace the .xml file
        // that we would typically set using the setContent(R.id.xml_file) method. The setContent
        // block defines the activity's layout.
        setContent {
            CustomViewComponent()
        }
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun CustomViewComponent() {
    val paint = Paint().apply {
        style = PaintingStyle.fill
    }
    Container(modifier = LayoutSize.Fill) {
        Canvas(modifier = Modifier.None) {
            paint.color = Color.Red
            drawCircle(
                center = Offset(size.width.value / 2, size.height.value / 2),
                radius = 300f,
                paint = paint
            )

            paint.color = Color.Green
            drawCircle(
                center = Offset(size.width.value / 2, size.height.value / 2),
                radius = 200f,
                paint = paint
            )

            paint.color = Color.Blue
            drawCircle(
                center = Offset(size.width.value / 2, size.height.value / 2),
                radius = 100f,
                paint = paint
            )
        }
    }
}

/**
 * Android Studio lets you preview your composable functions within the IDE itself, instead of
 * needing to download the app to an Android device or emulator. This is a fantastic feature as you
 * can preview all your custom components(read composable functions) from the comforts of the IDE.
 * The main restriction is, the composable function must not take any parameters. If your composable
 * function requires a parameter, you can simply wrap your component inside another composable
 * function that doesn't take any parameters and call your composable function with the appropriate
 * params. Also, don't forget to annotate it with @Preview & @Composable annotations.
 */
@Preview
@Composable
fun CustomViewComponentPreview() {
    CustomViewComponent()
}