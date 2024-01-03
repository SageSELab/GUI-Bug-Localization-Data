package com.easyfitness.bodymeasures;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.easyfitness.BtnClickListener;
import com.easyfitness.DAO.bodymeasures.DAOBodyMeasure;
import com.easyfitness.R;
import com.easyfitness.enums.SizeUnit;
import com.easyfitness.enums.Unit;
import com.easyfitness.enums.WeightUnit;
import com.easyfitness.utils.DateConverter;
import com.easyfitness.utils.UnitConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static android.text.format.DateFormat.getDateFormat;

public class BodyMeasureCursorAdapter extends CursorAdapter {

    BtnClickListener mClickListener = null;
    private LayoutInflater mInflater;
    private Context mContext = null;

    public BodyMeasureCursorAdapter(Context context, Cursor c, int flags, BtnClickListener mD) {
        super(context, c, flags);
        mContext = context;
        mClickListener = mD;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView t0 = view.findViewById(R.id.LIST_BODYMEASURE_ID);
        t0.setText(cursor.getString(0));

        TextView t1 = view.findViewById(R.id.LIST_BODYMEASURE_DATE);
        Date date = DateConverter.DBDateStrToDate(cursor.getString(cursor.getColumnIndex(DAOBodyMeasure.DATE)));
        String dateStr = DateConverter.dateToLocalDateStr(date, mContext);
        t1.setText(dateStr);

        float measure = cursor.getFloat(cursor.getColumnIndex(DAOBodyMeasure.MEASURE));
        Unit unit = Unit.fromInteger(cursor.getInt(cursor.getColumnIndex(DAOBodyMeasure.UNIT)));
        /*switch (unit) {
            case INCH:
                measure = SizeUnit.CmToInch(measure);
                break;
            case LBS:
                measure = UnitConverter.KgtoLbs(measure);
                break;
            case STONES:
                measure = UnitConverter.KgtoStones(measure);
                break;
        }*/

        String t2Str = String.format("%.1f", measure) + unit.toString();

        TextView t2 = view.findViewById(R.id.LIST_BODYMEASURE_WEIGHT);
        t2.setText(t2Str);

        CardView cdView = view.findViewById(R.id.CARDVIEW);

        int mFirstColorOdd = 0;
        if (cursor.getPosition() % 2 == mFirstColorOdd) {
            cdView.setBackgroundColor(context.getResources().getColor(R.color.record_background_even));
        } else {
            cdView.setBackgroundColor(context.getResources().getColor(R.color.background));
        }

        ImageView editImg = view.findViewById(R.id.editButton);
        editImg.setTag(cursor.getLong(cursor.getColumnIndex(DAOBodyMeasure.KEY)));
        editImg.setOnClickListener(v -> {
            if (mClickListener != null)
                mClickListener.onBtnClick(v);
        });

        ImageView deletImg = view.findViewById(R.id.deleteButton);
        deletImg.setTag(cursor.getLong(cursor.getColumnIndex(DAOBodyMeasure.KEY)));
        deletImg.setOnClickListener(v -> {
            if (mClickListener != null)
                mClickListener.onBtnClick(v);
        });

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.bodymeasure_row, parent, false);
    }

}
