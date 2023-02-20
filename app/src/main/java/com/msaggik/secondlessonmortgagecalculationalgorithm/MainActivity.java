package com.msaggik.secondlessonmortgagecalculationalgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/** Расчет накоплений на покупку */
public class MainActivity extends AppCompatActivity {

    float apartmentPrice = 14_000;              // вся стоимость
    float account = 1_000;                      // счёт пользователя (первоначальный)
    float wage = 2_500.0F;                      // стипендия в месяц
    float percentBank = 5;                      // годовая процентная ставка по остатку на счету



    public float count( ) {
        account = account + (account / 100 * percentBank / 12) + wage;
        return account;
    }

    private TextView countOut;
    private TextView manyMonthOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countOut = findViewById(R.id.countOut);
        manyMonthOut = findViewById(R.id.manyMonthOut);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        int i=0;
        String monthIncrease="";
        while (account <= apartmentPrice) {
            i++;
            monthIncrease = monthIncrease+ "Месяц " + i + " - " +  df.format(count()) + " монет \n";
        }
        manyMonthOut.setText(  monthIncrease      );
        countOut.setText(i+ " мес. ожидания");
    }

}
