package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bean.Equipo;
import pe.edu.ulima.pc_1_mt.R;
import pe.edu.ulima.pc_1_mt.listadoEquipos.ListadoEquiposActivity;


public class ListadoEquiposAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<Equipo> mEquipos;
    private Context mContext;

    public ListadoEquiposAdapter(Context context, List<Equipo> equipos) {
        mInflater = LayoutInflater.from(context);
        mEquipos = equipos;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mEquipos.size();
    }

    @Override
    public Object getItem(int position) {
        return mEquipos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mEquipos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = mInflater.inflate(R.layout.item_listado_equipos, null);
            viewHolder = new ViewHolder();

            viewHolder.tviNombreEquipo = (TextView) view.findViewById(R.id.tviNombreEquipo);
            viewHolder.iviPlus = (ImageView) view.findViewById(R.id.iviPlus);
            viewHolder.iviUser = (ImageView) view.findViewById(R.id.iviUser);
            viewHolder.iviShare = (ImageView) view.findViewById(R.id.iviShare);
            viewHolder.iviFoto = (ImageView) view.findViewById(R.id.iviFoto);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Equipo equipo = mEquipos.get(position);
        viewHolder.tviNombreEquipo.setText(equipo.getNombre());
        Picasso.with(mContext).load(equipo.getUrlFoto()).into(viewHolder.iviFoto);

        return view;
    }

    class ViewHolder{

        TextView tviNombreEquipo;
        ImageView iviPlus;
        ImageView iviUser;
        ImageView iviShare;
        ImageView iviFoto;
    }
}
