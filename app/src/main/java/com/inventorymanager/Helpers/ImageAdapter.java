package com.inventorymanager.Helpers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}



/*
https://stackoverflow.com/questions/27818786/fetch-data-from-sqlite-and-display-in-gridview

public class MyAdapter extends BaseAdapter {
Context context;
ArrayList<Employee> empList;
private static LayoutInflater inflater = null;

public MyAdapter(Context context, ArrayList<Employee> empList) {
    this.context = context;
    this.empList = empList;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public int getCount() {
    // TODO Auto-generated method stub
    return empList.size();
}

@Override
public Object getItem(int position) {
    // TODO Auto-generated method stub
    return position;
}

@Override
public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    if (convertView == null)
        convertView = inflater.inflate(R.layout.layout_grid_item, null);

    TextView codeTextView = (TextView) convertView.findViewById(R.id.tv_emp_id);
    TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_emp_name);
    TextView emailTextView = (TextView) convertView.findViewById(R.id.tv_emp_email);
    TextView addressTextView = (TextView) convertView.findViewById(R.id.tv_emp_address);

    Employee e = new Employee();
    e = empList.get(position);
    codeTextView.setText("Code: " + String.valueOf(e.getCode()));
    nameTextView.setText("Name: " + e.getName());
    emailTextView.setText("Email: " + e.getEmail());
    addressTextView.setText("Address: " + e.getAddress());
    return convertView;
}

}
*/


/*
https://www.mkyong.com/android/android-gridview-example/
package com.mkyong.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mkyong.android.R;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] mobileValues;

	public ImageAdapter(Context context, String[] mobileValues) {
		this.context = context;
		this.mobileValues = mobileValues;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.mobile, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(mobileValues[position]);

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String mobile = mobileValues[position];

			if (mobile.equals("Windows")) {
				imageView.setImageResource(R.drawable.windows_logo);
			} else if (mobile.equals("iOS")) {
				imageView.setImageResource(R.drawable.ios_logo);
			} else if (mobile.equals("Blackberry")) {
				imageView.setImageResource(R.drawable.blackberry_logo);
			} else {
				imageView.setImageResource(R.drawable.android_logo);
			}

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		return mobileValues.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}


*/
