package pe.edu.ulima.pc_1_mt.listadoEquipos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import pe.edu.ulima.pc_1_mt.R;

/**
 * Created by Stefanny on 18/05/2016.
 */
public class ImageAdapter1 extends BaseAdapter {

    private Context mContext;

    public ImageAdapter1(Context c) {
        mContext = c;
    }



    @Override
    public int getCount() {
        return mThumbIds.length;
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

        ImageView imageView;
        if(convertView == null){

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);

        }else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return null;
    }

    private Integer[] mThumbIds = { R.drawable.plus,
            R.drawable.plus, R.drawable.plus,
            R.drawable.plus, R.drawable.plus,
            R.drawable.plus};
}
