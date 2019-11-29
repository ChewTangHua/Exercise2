package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun calculateBMI(h: Double, w: Double): Double {
            return  (w / (h*h)) //Math.pow(h, 2.0)
        }

        CalculateBtn.setOnClickListener(){
            val userHeight:Double = InHeight.text.toString().toDouble()
            val userWeight:Double = InWeight.text.toString().toDouble()
            val userBMI:Double = calculateBMI(userHeight, userWeight)

            /*if (userBMI < 18.50){
                ResultImg.setImageResource(R.drawable.under)
            }else if (userBMI <= 24.90){
                ResultImg.setImageResource(R.drawable.normal)
            }else{
                ResultImg.setImageResource(R.drawable.over)
            }*/

            val status:String

            when{
                userBMI < 18.50 ->{
                    ResultImg.setImageResource(R.drawable.under)
                    status = "Under"
                }

                userBMI <= 24.90 ->{
                    ResultImg.setImageResource(R.drawable.normal)
                    status = "Normal"
                }

                else ->{
                    ResultImg.setImageResource(R.drawable.over)
                    status = "Over"
                }
            }

            txtResult.text = "BMI %.2f (%s)".format(userBMI, status)

        }

        ResetBtn.setOnClickListener(){
            InWeight.setText("")
            InHeight.setText("")
            txtResult.setText("")
            ResultImg.setImageResource(R.drawable.empty)

            InHeight.requestFocus()
        }

    }
}
