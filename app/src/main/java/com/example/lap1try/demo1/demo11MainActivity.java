package com.example.lap1try.demo1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lap1try.R;

import java.util.ArrayList;

public class demo11MainActivity extends AppCompatActivity {
    EditText txtId,txtTitle,txtContent,txtDate,txtType;
    Button btnThem,btnSua,btnXoa;
    ListView listView;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<KhoaHoc> listKH = new ArrayList<>();
    KhoaHocDAO khoaHocDAO;
    Context context = this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_demo11_main);
        txtId = findViewById(R.id.edt_Id);
        txtType = findViewById(R.id.edt_type);
        txtContent = findViewById(R.id.edt_content);
        txtDate = findViewById(R.id.edt_date);
        txtTitle = findViewById(R.id.edt_title);
        btnSua = findViewById(R.id.btn_update);
        btnThem = findViewById(R.id.btn_add);
        btnXoa = findViewById(R.id.btn_delete);
        //listV
        listView = findViewById(R.id.listV);
        khoaHocDAO = new KhoaHocDAO(context);
        listKH.clear();
        list.clear();
        listKH = khoaHocDAO.getListKhoaHoc();
        for (KhoaHoc kh:listKH){
            list.add(kh.getId()+" - "+kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType());

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

    btnThem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setId(Integer.parseInt(txtId.getText().toString()));
        khoaHoc.setTitle(txtTitle.getText().toString());
        khoaHoc.setContent(txtContent.getText().toString());
        khoaHoc.setDate(txtDate.getText().toString());
        khoaHoc.setType(Integer.parseInt(txtType.getText().toString()));
        khoaHocDAO.addKhoaHoc(khoaHoc);
        listKH.clear();
        list.clear();
        listKH = khoaHocDAO.getListKhoaHoc();
        for (KhoaHoc kh:listKH){
            list.add(kh.getId()+" - "+kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType());

        }
        adapter.notifyDataSetChanged();
    }
        });
    btnSua.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setId(Integer.parseInt(txtId.getText().toString()));
        khoaHoc.setTitle(txtTitle.getText().toString());
        khoaHoc.setContent(txtContent.getText().toString());
        khoaHoc.setDate(txtDate.getText().toString());
        khoaHoc.setType(Integer.parseInt(txtType.getText().toString()));
        khoaHocDAO.updateKhoaHoc(khoaHoc);
        listKH.clear();
        list.clear();
        listKH = khoaHocDAO.getListKhoaHoc();
        for (KhoaHoc kh:listKH){
            list.add(kh.getId()+" - "+kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType());

        }
        adapter.notifyDataSetChanged();
    }
        });
    btnXoa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       int id = Integer.parseInt(txtId.getText().toString());
       khoaHocDAO.deleteKhoaHoc(id);
        listKH.clear();
        list.clear();
        listKH = khoaHocDAO.getListKhoaHoc();
        for (KhoaHoc kh:listKH){
            list.add(kh.getId()+" - "+kh.getTitle()+" - "+kh.getContent()+" - "+kh.getDate()+" - "+kh.getType());

        }
        adapter.notifyDataSetChanged();
    }
    });
    }
}