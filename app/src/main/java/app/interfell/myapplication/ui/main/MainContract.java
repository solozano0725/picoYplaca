package app.interfell.myapplication.ui.main;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.Calendar;
import java.util.List;

public interface MainContract {

    interface MainView{
        void pullSpinnerDay();
        void pullSpinnerDayNumber();
        void pullCalendarHour();
        void successMsg(String message);
        void errorMsg(String message);
        void warningMsg(String message);

    }

    interface MainPresenter{
        ArrayAdapter pullSpinnerDay(ArrayAdapter adapter, Context c);
        ArrayAdapter pullSpinnerDayNumber(ArrayAdapter adapter, Context c);
        TimePickerDialog hadlePullCalendarHour(Calendar mCalendar, Context c, TimePickerDialog.OnTimeSetListener onTimeSetListener);
    }
}
