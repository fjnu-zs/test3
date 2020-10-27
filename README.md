# 1.ListViewDemo
## 主要代码
### activity
``` Java
private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat"};
    private int[] imgIds = new int[] {
            R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text1);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> newItem = new HashMap<>();
            newItem.put("header",imgIds[i]);
            newItem.put("name",names[i]);
            listItems.add(newItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.activity_item,new String[]{
                "header","name"
        },new int[]{
                R.id.header,R.id.name
        });
        ListView listView = findViewById(R.id.myList);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast= Toast.makeText(TextActivity1.this,names[i],Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
```
### Layout
```Java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".TextActivity1"
    android:orientation="horizontal">
    <ListView
        android:id="@+id/myList"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </ListView>
</LinearLayout>
```
```Java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ItemActivity">
    <TextView
        android:id="@+id/name"
        android:layout_width="0dp"
        android:layout_weight="1"
        android:layout_height="wrap_content"
        android:padding="3dp"
        android:textSize="20sp"
        android:textColor="#000"
        android:gravity="left"
        tools:ignore="Suspicious0dp" />

    <ImageView
        android:id="@+id/header"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:paddingRight="10dp"/>
</LinearLayout>
```
## demo
![](https://github.com/fjnu-zs/test3/blob/master/iamge/%E5%AE%9E%E9%AA%8C1.png)


# 2.自定义对话框AlertDialog
## 主要代码
``` Java
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".LoginActivity">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ANDROID APP"
        android:background="#F8D805"
        android:layout_gravity="center_horizontal"
        android:textSize="30sp"
        android:gravity="center"/>
    <TableRow
        android:layout_marginTop="20dp">
        <EditText
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:hint="UserName"
            android:inputType="phone"
            android:selectAllOnFocus="true" />
    </TableRow>
    <TableRow>
    <EditText
        android:layout_weight="1"
        android:layout_height="match_parent"
        android:hint="Password"
        android:inputType="phone"
        android:selectAllOnFocus="true" />
    </TableRow>
    <TableRow
        android:layout_marginTop="20dp"
        android:padding="2dp">
        <Button
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:text="Cancel"
            android:background="@drawable/shape" />
        <Button
            android:layout_weight="1"
            android:layout_height="match_parent"
            android:background="@drawable/shape"
            android:text="Sign in"/>
    </TableRow>
</TableLayout>
```
``` Java
public void clickText2(View view){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setView(R.layout.activity_login);
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }
```
## demo
![](https://github.com/fjnu-zs/test3/blob/master/iamge/%E5%AE%9E%E9%AA%8C2.png)


# XML定义菜单
## 主要代码
``` Java
private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text2);
        txt = findViewById(R.id.txt);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_demo1, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        if(mi.isCheckable()){
            mi.setChecked(true);
        }
        switch (mi.getItemId()){
            case R.id.font_10: txt.setTextSize(10*2); break;
            case R.id.font_16: txt.setTextSize(16*2); break;
            case R.id.font_20: txt.setTextSize(20*2); break;
            case R.id.red_font: txt.setTextColor(Color.RED); break;
            case R.id.black_font: txt.setTextColor(Color.BLACK); break;
            case R.id.plain_item:
                Toast.makeText(TextActivity2.this,"单击普通菜单项",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
```
``` Java
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:title="字体大小">
        <menu>
            <item
                android:id="@+id/font_10"
                android:title="10号字">
            </item>
            <item
                android:id="@+id/font_16"
                android:title="16号字">
            </item>
            <item
                android:id="@+id/font_20"
                android:title="20号字">
            </item>
        </menu>
    </item>
    <item
        android:id="@+id/plain_item"
        android:title="普通菜单项">
    </item>
    <item android:title="字体颜色">
        <menu>
            <item
                android:id="@+id/black_font"
                android:title="黑色">
            </item>
            <item
                android:id="@+id/red_font"
                android:title="红色">
            </item>
        </menu>
    </item>
</menu>
```
## demo
![](https://github.com/fjnu-zs/test3/blob/master/iamge/%E5%AE%9E%E9%AA%8C3.png)


# ActionMode的上下文菜单
## 主要代码
``` Java
private ListView listView;
    private List<Item> list;
    private AdapterCur adapter;
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","dfi","sdh","sdfho","efjsod"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text3);

        listView = findViewById(R.id.myList2);
        list = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            list.add(new Item(names[i],false));
        }
        adapter = new AdapterCur(list,TextActivity3.this);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            int num = 0;
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                // 调整选定条目
                if (checked == true) {
                    list.get(position).setBo(true);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num++;
                } else {
                    list.get(position).setBo(false);
                    //实时刷新
                    adapter.notifyDataSetChanged();
                    num--;
                }
                // 用TextView显示
                mode.setTitle("  " + num + " Selected");
            }


            /*
             * 参数：ActionMode是长按后出现的标题栏
             * 		Menu是标题栏的菜单内容
             */
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // 设置长按后所要显示的标题栏的内容
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_demo2, menu);
                num = 0;
                adapter.notifyDataSetChanged();
                return true;

            }


            /*
             * 可在此方法中进行标题栏UI的创建和更新
             */
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                adapter.notifyDataSetChanged();
                return false;
            }

            public void refresh(){
                for(int i = 0; i < 6; i++){
                    list.get(i).setBo(false);
                }
            }
            public void delete(){
                for(int i=0;i<list.size();i++){
                    if(list.get(i).isBo()){
                        list.remove(i);
                    }
                }
            }
            /*
             * 可在此方法中监听标题栏Menu的监听，从而进行相应操作
             * 设置actionMode菜单每个按钮的点击事件
             */
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    //全选
                    case R.id.action_setting:
                        num = 0;
                        refresh();
                        adapter.notifyDataSetChanged();
                        mode.finish(); // 偷了个懒，每个菜单按钮都设置返回，结束多选模式
                        return true;
                    //删除
                    case R.id.action_delete:
                        adapter.notifyDataSetChanged();
                        num = 0;
                        delete();
                        mode.finish();// 偷了个懒，每个菜单按钮都设置返回，结束多选模式
                        return true;
                    default:
                        refresh();
                        adapter.notifyDataSetChanged();
                        num = 0;
                        return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                refresh();
                adapter.notifyDataSetChanged();

            }

        });
    }
```
## demo
![](https://github.com/fjnu-zs/test3/blob/master/iamge/%E5%AE%9E%E9%AA%8C4.png)
