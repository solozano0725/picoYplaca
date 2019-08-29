package app.interfell.myapplication.ui.main;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

import app.interfell.myapplication.R;
import app.interfell.myapplication.data.ModelContract;
import app.interfell.myapplication.data.ModelPresenter;
import app.interfell.myapplication.ui.recyclerview.RecyclerViewAdapter;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements MainContract.MainView,
        ModelContract.ModelView,
        TimePickerDialog.OnTimeSetListener{

    private Spinner spinnerDay, spinnerNumberDay;
    private Button btnGo;
    private ImageButton btnCalendar;

    private RecyclerView rv;
    private RecyclerViewAdapter adapterRV;
    private LinearLayoutManager mLayoutManager;

    private ArrayAdapter adapter;
    private MainPresenter mainPresenter;
    private ModelPresenter modelPresenter;
    private TimePickerDialog timePickerDialog;
    private TextView txtHour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeView();
        mainPresenter = new MainPresenter(this);
        modelPresenter = new ModelPresenter(this,this);

        pullSpinnerDay();
        pullSpinnerDayNumber();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pullCalendarHour();
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDataToRecyclerView(adapterRV);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeView(){
        spinnerDay = findViewById(R.id.spinnerDay);
        spinnerNumberDay= findViewById(R.id.spinnerNumber);
        btnCalendar= findViewById(R.id.calendarHour);
        btnGo= findViewById(R.id.btnGo);
        txtHour = findViewById(R.id.txtHour);

        rv = findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(mLayoutManager);
        adapterRV = new RecyclerViewAdapter(getApplicationContext());
    }

    @Override
    public void pullSpinnerDay() {
        spinnerDay.setAdapter(mainPresenter.pullSpinnerDay(adapter, this));
    }

    @Override
    public void pullSpinnerDayNumber() {
        spinnerNumberDay.setAdapter(mainPresenter.pullSpinnerDayNumber(adapter, this));
    }

    @Override
    public void pullCalendarHour() {
        timePickerDialog = mainPresenter.hadlePullCalendarHour(Calendar.getInstance(), MainActivity.this, MainActivity.this);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        txtHour.setText(hourOfDay+":"+minute);
    }

    @Override
    public void successMsg(String message) {
        Toasty.success(getApplicationContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void errorMsg(String message) {
        Toasty.error(getApplicationContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void warningMsg(String message) {
        Toasty.warning(getApplicationContext(), message, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void setDataToRecyclerView(RecyclerViewAdapter adapterRV) {
        adapterRV = modelPresenter.setDataToRecyclerView(adapterRV);
        rv.setAdapter(adapterRV);
    }
}
