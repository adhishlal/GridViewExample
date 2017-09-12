package grid.com.appiness.gridviewexample;

/**
 * Created by adhishlal on 04/09/17.
 */


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import static android.view.View.GONE;
        import static android.view.View.VISIBLE;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public CustomGrid(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        final LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);


            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            final ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);

            final LinearLayout llDeselect = (LinearLayout) grid.findViewById(R.id.llDeselect);
            final LinearLayout llSelect = (LinearLayout) grid.findViewById(R.id.llSelect);

            llDeselect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    llDeselect.setVisibility(GONE);
                    llSelect.setVisibility(View.VISIBLE);
                }
            });

            llSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    llSelect.setVisibility(GONE);
                    llDeselect.setVisibility(VISIBLE);
                }
            });

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}