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

import android.util.Log;
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

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;

import app.interfell.myapplication.R;
import app.interfell.myapplication.data.ModelContract;
import app.interfell.myapplication.data.ModelPresenter;
import app.interfell.myapplication.data.db.model.HistoryModel;
import app.interfell.myapplication.data.db.model.PeakAndPlateModel;
import app.interfell.myapplication.ui.history.HistoryFragment;
import app.interfell.myapplication.ui.recyclerview.RecyclerViewAdapter;
import app.interfell.myapplication.utils.Utils;
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
    private TextView txtHour, txtNews, txtContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainPresenter = new MainPresenter(this);
        modelPresenter = new ModelPresenter(this);

        initializeView();

        pullSpinnerDay();
        pullSpinnerDayNumber();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> getSupportFragmentManager().beginTransaction()
                .add(R.id.layoutP, new HistoryFragment())
                .addToBackStack(null)
                .commit());

        btnCalendar.setOnClickListener(v -> pullCalendarHour());
        btnGo.setOnClickListener(v -> {
            modelPresenter.isPeakAndPlate(getData());
            adapterRV.notifyDataSetChanged();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeView(){
        spinnerDay = findViewById(R.id.spinnerDay);
        spinnerNumberDay= findViewById(R.id.spinnerNumber);
        txtHour = findViewById(R.id.txtHour);
        txtNews = findViewById(R.id.txtNews);
        txtContra = findViewById(R.id.txtContra);
        btnCalendar= findViewById(R.id.calendarHour);
        btnGo= findViewById(R.id.btnGo);

        rv = findViewById(R.id.rv);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(mLayoutManager);
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
        txtHour.setText(Utils.setFormatHour(hourOfDay)+":"+Utils.setFormatHour(minute));
        txtHour.invalidate();
        txtHour.requestLayout();
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
    public void setDataToRecyclerView(LinkedHashMap<Integer, String> hashMapPP) {
        adapterRV = new RecyclerViewAdapter(hashMapPP);
        rv.setAdapter(adapterRV);
    }

    @Override
    public PeakAndPlateModel getData() {
        PeakAndPlateModel p = new PeakAndPlateModel();
        p.setDAY(spinnerDay.getSelectedItem().toString());
        p.setNUMBER_DAY(Integer.parseInt(spinnerNumberDay.getSelectedItem().toString()));
        p.setHOUR(txtHour.getText().toString());
        return p;
    }

    public HistoryModel getDataQuery(PeakAndPlateModel p){
        HistoryModel h = new HistoryModel();
        h.setDATE(Utils.getDateTimeSystem());
        h.setDATA_IN(p.toString());
        return h;
    }

    @Override
    public void setPeakAndPlate(int cass) {
        switch (cass) {
            case 1:
                setInfo(getResources().getString(R.string.case_1),
                        R.color.errorColor,
                        getResources().getString(R.string.part_1) + "\n"
                                + getResources().getString(R.string.part_2) + "\n"
                                + getResources().getString(R.string.part_3) + "\n"
                                + getResources().getString(R.string.part_4));
                break;
            case 2:
                setInfo(getResources().getString(R.string.case_2),
                        R.color.errorColor,
                        getResources().getString(R.string.part_1) + "\n"
                                + getResources().getString(R.string.part_2) + "\n"
                                + getResources().getString(R.string.part_3) + "\n"
                                + getResources().getString(R.string.part_4));
                break;
            case 3:
                setInfo(getResources().getString(R.string.case_3),
                        R.color.successColor,
                        getResources().getString(R.string.part_1) + "\n"
                                + getResources().getString(R.string.part_22) + "\n"
                                + getResources().getString(R.string.part_3) + "\n"
                                + getResources().getString(R.string.part_4));
                break;
            default:
        }
    }

    private void setInfo(String title, int color, String message){
        txtContra.setText(title);
        txtContra.setTextColor(getResources().getColor(color));
        txtNews.setText(message);

        txtContra.invalidate();
        txtContra.requestLayout();

        txtNews.invalidate();
        txtNews.requestLayout();
    }

}
