package com.example.targetpro

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.targetpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workoutButton1: Button = findViewById(R.id.gotoWorkout1Button)
        val workoutButton2: Button = findViewById(R.id.gotoWorkout2Button)
        val workoutButton3: Button = findViewById(R.id.gotoWorkout3Button)
        val workoutButton4: Button = findViewById(R.id.gotoWorkout4Button)
        val workoutButton5: Button = findViewById(R.id.gotoWorkout5Button)
        val workoutButton6: Button = findViewById(R.id.gotoWorkout6Button)
        val workoutButton7: Button = findViewById(R.id.gotoWorkout7Button)

        val mainMenuButton: Button = findViewById(R.id.mainMenuButton)
        val statisticsButton: Button = findViewById(R.id.statisticsButton)


        workoutButton1.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 1) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Упражнения на физическую подготовку") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "КАРДИО-ТРЕНИРОВКА:\n" +
                    "1. Интервальный бег: бег на максимальной скорости в течение 30-60 секунд, за которыми следует медленный бег в течение 1-2 минут. Длительность от 30мин-1часу. С 2 остановками на 5ти минутный отдых\n" +
                    "2. Бег с доп-весом: бег в спокойном темпе на расстояние 3-6км, с дополнительным весом от 10-20кг. Допускается 1 остановка на 5 минут, для отдыха\n"+
                    "3. Эллипсоидный тренажер: тренировка с изменением интенсивности каждые 3-5 минут, чередуя высокую скорость и более спокойное движение в течение 20-30 минут\n\n\n\n" +


                    "СИЛОВЫЕ УПРАЖНЕНИЯ \n" +
                    "1. Отжимания: 160раз, 20 раз за подход\n" +
                    "2. Отжимания с доп-весом: 60раз, 10 раз за подход. Вес: от 15кг-30кг\n" +
                    "3. Планка: 3-5мин. 3 подхода\n" +
                    "4. Жим лежа: 30кг по 10 раз, 3 подхода. 60кг по 5 раз, 4 подхода\n" +
                    "5. Подтягивания широкие: 30раз, за 3 подхода, с дополнительным весом от 5-10кг\n\n\n\n" +


                    "УПРАЖНЕНИЯ НА СТАБИЛЬНОСТЬ И БАЛАНС\n" +
                    "1. Стойка на одной ноге: от 3-5мин с закрытыми глазами, повторять 5-10 раз, возможно утяжеление до 5кг\n" +
                    "2. Использование балансёра: удерживать баланс в течении 3-5 мин, 5-10 подходов\n" +
                    "3. Приседания на одной ноге: 15раз, по 5-8 подходов"
            ) // Дополнительные подробности
            startActivity(intent)
        }

        workoutButton2.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 2) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Упражнения на технику стрельбы\n") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "1. Прорабатывание выстрела с последующим контролем всех движений. После выстрела удерживать диоптр на мишеньке 5сек. Повторять 30 выстрелов\n" +
            "2. Стрельба по белой мишеньки, проботки вывода мушки на мишеньку, с акцентом на спуск. Стрелять на кучность. 50 выстрелов\n" +
            "3. Стрельба без спортивного костюма. Выстрел производить за один заход, не откладывать. Выдерживать до максимально лучшего результата. 20 выстрелов\n\n"+
            "ВСЕ УПРАЖНЕНИЯ ВЫПОЛНЯЮТСЯ С ПРИМЕНЕНИЕ SCATT") // Дополнительные подробности
            startActivity(intent)
        }
        workoutButton3.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 3) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Упражнения на точность") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "1. Удержание перед выстрелом. При наведении мушки на мишень, удерживать мушку на десятке в течении 10-20сек, после производить выстрел. 50 выстрелов\n" +
            "2. Стрельба на зачетные выстрелы, с учетом только десяток. 20 выстрелов") // Дополнительные подробности
            startActivity(intent)
        }

        workoutButton4.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 4) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Улучшение концентрации") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "1. Удержание внимания на одном объекте продолжительное время, ваша задача возвращать внимание, когда оно уходит от вас. 10 минут, по 3 подхода\n" +
            "2. Стрельба в затычках, полная фокусировка 10 выстрелов. После стрельба без затычек 20 выстрелов, производить выстрелы не отвлекаясь так же, как и в затычках. 6 подходов") // Дополнительные подробности
            startActivity(intent)
        }
        workoutButton5.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 5) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Тренировки на управление дыханием") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "1. Тренировка дыхания по счету, производить вдох в течении 5 сек, после не выдыхать в течении 10 секунд. 5 подходов\n" +
            "2. Стреляйте на выдохе или на момент паузы после выдоха. Это помогает снизить колебания оружия. Важно находить свой ритм дыхания и следовать ему на протяжении всей серии выстрелов\n" +
            "3. Сосредотачивайтесь на своем дыхании и контролируйте его во время прицеливания и стрельбы. Стремитесь к плавности и стабильности.\n"+
            "4. После выстрела быстро вдыхайте и выдыхайте, чтобы восстановить нормальный ритм дыхания перед следующим выстрелом.") // Дополнительные подробности
            startActivity(intent)
        }

        workoutButton6.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 6) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Тренировка быстрой реакции") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "1. Произведение выстрела с произвольным вводом мушки на уровень мишени, производя выстрел на моменте как мушка на мишене (в центре). 30 выстрелов\n" +
            "2. Произведение выстрела, при перовм моменте после правильно вывода мушки на прицел. 20 выстрелов") // Дополнительные подробности
            startActivity(intent)
        }

        workoutButton7.setOnClickListener {
            val intent = Intent(this, WorkoutDetailsActivity::class.java)
            intent.putExtra("workoutNumber", 7) // Отправка номера тренировки
            intent.putExtra("workoutDescription", "Тренировка на стрессоустойчивость") // Отправка описания тренировки
            intent.putExtra("exerciseDetails", "1. Выполнение тренировочной стрельбы, с посторонними шумами и разрдражающими факторами. Нельзя использовать затычки. 80 выстрелов\n"+
            "2. Выполнение контрольной стрельбы, с имитацией соревнований. Выполняется по стандартам олимпийских стрельб - ВП60 и ВП40") // Дополнительные подробности
            startActivity(intent)
        }



        mainMenuButton.setOnClickListener {
            Toast.makeText(this, "Вы уже в главном меню", Toast.LENGTH_SHORT).show()

        }

        statisticsButton.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            startActivity(intent)
        }
    }
}




