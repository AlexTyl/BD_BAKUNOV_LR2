package com.junior.bd_lr2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);

        ArrayList<Stuff> stuffArrayList = new ArrayList<>();
        StuffTree stuffTree = null;

        for(int i = 0; i < 3000; i++){
            Stuff stuff = new Stuff( (int) (Math.random() * 3000), UUID.randomUUID().toString(), UUID.randomUUID().toString(), (float) Math.random());
            stuffArrayList.add(stuff);

            Log.d("CREATE NEW STUFF", stuff.toString());
        }

        long timeOne = System.currentTimeMillis();
        for (int i = 0; i < stuffArrayList.size(); i++){

            if(i == 0){
                stuffTree = new StuffTree(stuffArrayList.get(i));
            } else {
                stuffTree.insert(new StuffTree(stuffArrayList.get(i)));
            }
        }
        long timeTwo = System.currentTimeMillis();
        Log.d("SORT TREE TIME! STUFF", timeTwo - timeOne + "");
        editText.setText(editText.getText() + "\n\n" + "SORT TREE TIME! STUFF " + (timeTwo - timeOne));
        stuffTree.traverse(new StuffTree.KeyPrinter());

        timeOne = System.currentTimeMillis();
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < stuffArrayList.size() - 1; i++){
                if(stuffArrayList.get(i).getIntStuff() > stuffArrayList.get(i + 1).getIntStuff()){
                    Stuff iStuff = stuffArrayList.get(i);
                    stuffArrayList.set(i, stuffArrayList.get(i + 1));
                    stuffArrayList.set(i + 1, iStuff);
                    flag = true;
                }
            }
        }
        timeTwo = System.currentTimeMillis();
        Log.d("SORT BUBBLE TIME! STUFF", timeTwo - timeOne + "");
        editText.setText(editText.getText() + "\n\n" + "SORT BUBBLE TIME! STUFF " + (timeTwo - timeOne));


        for(int i = 0; i < stuffArrayList.size(); i++){
            Log.d("SORT BUBBLE NEW STUFF", stuffArrayList.get(i).toString());
            }

        timeOne = System.currentTimeMillis();
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(678))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(100))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(200))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(300))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(400))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(1500))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(2000))) + "");
        Log.d("FIND TREE BOOL! STUFF", stuffTree.find(new StuffTree(stuffArrayList.get(2345))) + "");
        timeTwo = System.currentTimeMillis();
        Log.d("FIND TREE TIME! STUFF", timeTwo - timeOne + "");
        editText.setText(editText.getText() + "\n\n" + "FIND TREE BOOL! STUFF " + stuffTree.find(new StuffTree(stuffArrayList.get(678))));
        editText.setText(editText.getText() + "\n\n" + "FIND TREE TIME! STUFF " + (timeTwo - timeOne));

        timeOne = System.currentTimeMillis();
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(678), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(100), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(200), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(300), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(400), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(1500), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(2000), stuffArrayList) + "");
        Log.d("FIND BUBBLE BOOL! STUFF", find(stuffArrayList.get(2345), stuffArrayList) + "");
        timeTwo = System.currentTimeMillis();
        Log.d("FIND BUBBLE TIME! STUFF", timeTwo - timeOne + "");
        editText.setText(editText.getText() + "\n\n" + "FIND BUBBLE BOOL! STUFF " + find(stuffArrayList.get(678), stuffArrayList));
        editText.setText(editText.getText() + "\n\n" + "FIND BUBBLE TIME! STUFF " + (timeTwo - timeOne));
        editText.setEnabled(false);



    }

    public static boolean find(Stuff stuff, ArrayList<Stuff> stuffArrayList) {
          int low = 0, high = stuffArrayList.size(), mid;
          while (low < high) {
              mid = (low + high)/2;
              if (stuff.getIntStuff() == stuffArrayList.get(mid).getIntStuff()) {
                  return true;
              } else {
                  if (stuff.getIntStuff() < stuffArrayList.get(mid).getIntStuff()) {
                      high = mid;
                  } else {
                      low = mid + 1;
                  }
              }
          }
        return false;
    }
}
