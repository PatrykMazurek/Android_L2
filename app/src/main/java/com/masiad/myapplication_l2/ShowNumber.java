package com.masiad.myapplication_l2;

import android.content.Context;
import android.widget.Toast;

import java.util.Random;

public class ShowNumber implements Runnable{

    private Context context;

    public ShowNumber(Context context){
        this.context = context;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int number = rand.nextInt(100);
        String name = Thread.currentThread().getName();
        System.out.println(name + " wylosował " + number);
        try {
            Thread.sleep(rand.nextInt(5000) + 1000);
            Toast.makeText(context.getApplicationContext(),
                    name + " wylosował " + number,
                    Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
