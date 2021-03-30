package com.example.btandroid7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    int option = 1;
//    private RadioGroup convertGroup ;
//    private EditText edtInput ;
//    private EditText edtOutput ;
//    private Button btnConvert;
//    private TextView history;
    WebView web_view;
    View rootview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        web_view = (WebView) findViewById(R.id.webView1);

        

        List<Food> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        final String[] items = {"Đặt món qua tin nhắn", "Hiển thị món ăn", "Hiển thị địa điểm"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);



        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage("0979536507", null, "Tôi muốn đặt món ăn", null, null);
                        break;
                    case 1:
                        Intent iGetUrl = new Intent( getApplicationContext(), DetailFood.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("urlKey", "https://banhkembo.com/sanpham/banh-kem-pho-mai-hoang-kim-vuong-size-20-cm-18-20-ngu%cc%9bo%cc%9bi/");
                        iGetUrl.putExtras(bundle);
                        startActivity(iGetUrl);
                        break;
                    case 2:

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/wJN1NeKm6ztp4Mkt7"));
                        startActivity(intent);


                        break;

                    default:
                        break;

                }
            }
        });

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                AlertDialog alert = builder.create();
                alert.show();
//                Object o = listView.getItemAtPosition(position);
//                Food country = (Food) o;

            }
        });







        
//        this.convertGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        this.edtInput = (EditText) findViewById(R.id.edtInput);
//        this.edtOutput = (EditText) findViewById(R.id.edtOutput);
//        this. btnConvert = (Button) findViewById(R.id.convert);
//        this.history = (TextView) findViewById(R.id.history);


//        convertGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                doOnDifficultyLevelChanged(group, checkedId);
//            }
//        });
//
//        btnConvert.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                DecimalFormat f = new DecimalFormat("##.0");
//                if(option == 1) {
//                    double input = Double.valueOf(edtInput.getText().toString());
//                    edtOutput.setText(f.format(convertFahrenheitToCelsius(input)));
//                    history.append("F sang C: " + edtInput.getText() +" -> "  + f.format(convertFahrenheitToCelsius(input)) + "\n");
//                }else {
//                    double input = Double.valueOf(edtInput.getText().toString());
//                    edtOutput.setText(f.format(convertCelsiusToFahrenheit(input)));
//                    history.append("C sang F: " + edtInput.getText() +" -> "  + f.format(convertCelsiusToFahrenheit(input))+  "\n");
//                }
//            }
//        });
    }






    private List<Food> getListData() {
        List<Food> list = new ArrayList<Food>();
        Food food1 = new Food("cake1", "Bánh kem 1", "100");
        Food food2 = new Food("cake2", "Bánh kem 2", "200");
        Food food3 = new Food("cake3", "Bánh kem 3", "150");


        list.add(food1);
        list.add(food2);
        list.add(food3);

        return list;
    }
//    private double convertFahrenheitToCelsius(double f){
//        double result = (f - 32.0) * 5.0/9.0;
//        return result;
//    }
//
//    private double convertCelsiusToFahrenheit(double c){
//        double result = (c * 9.0/5.0) + 32.0;
//        return result;
//    }
//
//    private void doOnDifficultyLevelChanged(RadioGroup group, int checkedId) {
//        int checkedRadioId = group.getCheckedRadioButtonId();
//
//        if(checkedRadioId== R.id.radioFToC) {
//            option = 1;
//            edtInput.setText("");
//            edtOutput.setText("");
//        } else if(checkedRadioId== R.id.radioCToF ) {
//            option = 2;
//            edtInput.setText("");
//            edtOutput.setText("");
//        }
//    }
}