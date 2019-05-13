package com.bawei.zhangpuyu20190513.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangpuyu20190513.R;
import com.bawei.zhangpuyu20190513.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ItemsBean> list;

    public ListAdapter(Context context, List<Bean.ItemsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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

        int viewType = getItemViewType(position);
        switch (viewType){
            case 0:
                ViewHolderOne viewHolderOne;
                if(convertView == null){
                    viewHolderOne = new ViewHolderOne();
                    convertView = View.inflate(context, R.layout.list_one,null);
                    viewHolderOne.image_one = convertView.findViewById(R.id.image_one);
                    viewHolderOne.text_view = convertView.findViewById(R.id.text_view);
                    convertView.setTag(viewHolderOne);
                }else{
                    viewHolderOne = (ViewHolderOne) convertView.getTag();
                }
                Glide.with(context).load(list.get(position).getImage()).into(viewHolderOne.image_one);
                viewHolderOne.text_view.setText(list.get(position).getTitle());
                break;

            case 1:
                ViewHolderThree viewHolderThree;
                if(convertView == null){
                    viewHolderThree = new ViewHolderThree();
                    convertView = View.inflate(context, R.layout.list_three,null);
                    viewHolderThree.image_one = convertView.findViewById(R.id.image_one);
                    viewHolderThree.image_two = convertView.findViewById(R.id.image_two);
                    viewHolderThree.image_three = convertView.findViewById(R.id.image_three);
                    viewHolderThree.text_view = convertView.findViewById(R.id.text_view);
                    convertView.setTag(viewHolderThree);
                }else{
                    viewHolderThree = (ViewHolderThree) convertView.getTag();
                }
                Glide.with(context).load(list.get(position).getImages()).into(viewHolderThree.image_one);
                Glide.with(context).load(list.get(position).getImages()).into(viewHolderThree.image_two);
                Glide.with(context).load(list.get(position).getImages()).into(viewHolderThree.image_three);
                viewHolderThree.text_view.setText(list.get(position).getTitle());
                break;
        }


        return convertView;
    }

    class ViewHolderOne{
        ImageView image_one;
        TextView text_view;
    }

    class ViewHolderTwo{
        ImageView image_one,image_two;
        TextView text_view;
    }

    class ViewHolderThree{
        ImageView image_one,image_two,image_three;
        TextView text_view;
    }


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }
}
