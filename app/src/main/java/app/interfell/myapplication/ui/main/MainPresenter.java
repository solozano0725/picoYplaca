package app.interfell.myapplication.ui.main;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import app.interfell.myapplication.R;

public class MainPresenter implements MainContract.MainPresenter {

    private MainContract.MainView mainView;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public ArrayAdapter pullSpinnerDay(ArrayAdapter adapter, Context c) {
        return setAdapterData(adapter, c, R.array.days);
    }

    @Override
    public ArrayAdapter pullSpinnerDayNumber(ArrayAdapter adapter, Context c) {
        return setAdapterData(adapter, c, R.array.plateNumber);
    }

    private ArrayAdapter setAdapterData(ArrayAdapter adapter, Context c, int array) {
        try {
            adapter = new ArrayAdapter(c,
                    android.R.layout.simple_spinner_item,
                    hadlePullSpinner(c.getResources().getStringArray(array)));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        } catch (Exception e) {
            mainView.errorMsg(e.getMessage());
        }
        return adapter;
    }

    private List<String> hadlePullSpinner(String[] list) {
        List<String> listR = new ArrayList<>();
        try {
            listR = Arrays.asList(list);
        } catch (Exception e) {
            mainView.errorMsg(e.getMessage());
        }
        return listR;
    }

    @Override
    public TimePickerDialog hadlePullCalendarHour(Calendar mCalendar, Context c, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        TimePickerDialog mTimePickerDialog = null;
        try {
            mTimePickerDialog = new TimePickerDialog(
                    c,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    onTimeSetListener,
                    mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), true);
            mTimePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        } catch (Exception e) {
            mainView.errorMsg(e.getMessage());
        }
        return mTimePickerDialog;
    }

}
