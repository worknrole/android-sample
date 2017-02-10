package com.worknrole.sample.framework.view.list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wornrole.sample.R;

import java.util.List;

/**
 * Created by worknrole on 24/01/17.
 *
 * Adapter used to displayed the list inside the {@link com.worknrole.sample.framework.activity.MainActivity}
 */
public class SampleAdapter extends ArrayAdapter<Pair<String, Intent>> {

    public SampleAdapter(Context context, List<Pair<String, Intent>> sampleList) {
        super(context, 0, sampleList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_item_view, parent, false);
        }

        SampleViewHolder viewHolder = (SampleViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new SampleViewHolder();
            viewHolder.mLayout = convertView.findViewById(R.id.itemLayout);
            viewHolder.mTitle = (TextView) convertView.findViewById(R.id.sampleTitle);
            convertView.setTag(viewHolder);
        }

        final Pair<String, Intent> item = getItem(position);
        viewHolder.mTitle.setText(item.first);
        viewHolder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(item.second);
            }
        });

        return convertView;
    }

    private class SampleViewHolder {
        private View mLayout;
        public TextView mTitle;
    }
}
