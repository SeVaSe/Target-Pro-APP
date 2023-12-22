package com.example.targetpro

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random

class StatisticsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val buttonBack: Button = findViewById(R.id.backToMainMenuButton)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE


        val dataPoints = arrayOf(
            610f, 609f, 612f, 618f, 617f, 616f, 613f, 606f, 619f, 607f,
            620f, 621f, 617f, 616f, 609f, 608f, 615f, 621f, 610f, 620f,
            611f, 607f, 619f, 606f, 616f, 608f, 613f, 612f, 608f, 614f,
            621f, 618f, 611f, 622f, 607f, 615f, 609f, 614f, 605f, 619f
        )



        val lineChart = LineChartView(this, dataPoints)


        val layout = findViewById<LinearLayout>(R.id.chartLayout)
        layout.addView(lineChart)

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}

class LineChartView(context: Context, private val dataPoints: Array<Float>) : View(context) {

    private val linePaint = Paint()
    private val axisPaint = Paint()
    private val gridPaint = Paint()
    private val pointPaint = Paint()
    private val textPaint = Paint()

    private var lineWidth = 5f
    private var lineColor = Color.WHITE

    init {
        linePaint.color = lineColor
        linePaint.strokeWidth = lineWidth
        linePaint.isAntiAlias = true

        axisPaint.color = Color.GRAY
        axisPaint.strokeWidth = 5f

        gridPaint.color = Color.LTGRAY
        gridPaint.strokeWidth = 1f
        gridPaint.alpha = 100

        pointPaint.color = Color.RED
        pointPaint.textSize = 30f

        textPaint.color = Color.BLACK
        textPaint.textSize = 40f
        textPaint.isFakeBoldText
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Определение координаты Y для разметки месяцев
        val monthsY = height - 50f

        // Отрисовка линии для разметки
        canvas.drawLine(0f, monthsY, width.toFloat(), monthsY, linePaint)

        // Названия месяцев
        val months = arrayOf(
            "Янв", "Фев", "Мар", "Апр", "Май", "Июн",
            "Июл", "Авг", "Сен", "Окт", "Ноя", "Дек"
        )

        val monthSpacing = width.toFloat() / months.size
        linePaint.textSize = 30f // Размер шрифта
        // Отрисовка текста для каждого месяца
        for (i in months.indices) {
            val text = months[i]
            val x = i * monthSpacing + monthSpacing / 2

            canvas.drawText(text, x, monthsY + 40f, linePaint)
        }


        // Отрисовка сетки
        val stepX = (width.toFloat() - 200f) / (dataPoints.size - 1)
        val stepY = (height.toFloat() - 200f) / (dataPoints.maxOrNull()!! - dataPoints.minOrNull()!!)

        // Горизонтальные линии сетки
        for (i in 1 until dataPoints.size) {
            val startY = height.toFloat() - 100f - i * stepY
            canvas.drawLine(100f, startY, width.toFloat() - 100f, startY, gridPaint)
        }

        // Вертикальные линии сетки
        for (i in 1 until dataPoints.size) {
            val startX = 100f + i * stepX
            canvas.drawLine(startX, height.toFloat() - 100f, startX, 100f, gridPaint)
        }

        // Отрисовка осей
        canvas.drawLine(100f, height.toFloat() - 100f, 100f, 100f, axisPaint)
        canvas.drawLine(100f, height.toFloat() - 100f, width.toFloat() - 100f, height.toFloat() - 100f, axisPaint)

        // Расчет значений и отрисовка точек и линий графика
        for (i in 0 until dataPoints.size) {
            val x = 100f + i * stepX
            val y = height.toFloat() - 100f - (dataPoints[i] - dataPoints.minOrNull()!!) * stepY

            // Отрисовка линий между точками
            if (i > 0) {
                val prevX = 100f + (i - 1) * stepX
                val prevY = height.toFloat() - 100f - (dataPoints[i - 1] - dataPoints.minOrNull()!!) * stepY
                canvas.drawLine(prevX, prevY, x, y, linePaint)
            }
        }

// Отрисовка текста после отрисовки линий
        for (i in 0 until dataPoints.size) {
            val x = 100f + i * stepX
            val y = height.toFloat() - 100f - (dataPoints[i] - dataPoints.minOrNull()!!) * stepY

            // Увеличиваем размер точек
            canvas.drawCircle(x, y, 12f, pointPaint)

            // Отрисовка текста с очками рядом с точками
            val textX = x + 20f
            val textY = y - 20f
            canvas.drawText(dataPoints[i].toInt().toString(), textX, textY, textPaint)
        }
    }
}

