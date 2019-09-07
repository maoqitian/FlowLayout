# FlowLayout
[ ![Download](https://api.bintray.com/packages/maoqitian/mqt/flexibleflowlayout/images/download.svg) ](https://bintray.com/maoqitian/mqt/flexibleflowlayout/_latestVersion)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
## 项目简介
- 一款方便好用，让流式布局实现更简单的开源库，单选，多选，灵活配置，也可纯展示流式布局，流式布局item 也能随意自行配置。
## 项目引入
- 将以下依赖项添加到build.gradle文件
```
dependencies {
    implementation 'com.mao:flexibleflowlayout:1.0.0'
}
```
## Demo 展示
<img src="https://raw.githubusercontent.com/maoqitian/MaoMdPhoto/master/flowlayout/common.jpg"  height="300" width="170">
<img src="https://raw.githubusercontent.com/maoqitian/MaoMdPhoto/master/flowlayout/otherstyle.jpg"  height="300" width="170">
## 如何使用
- xml 布局

```
<mao.com.flexibleflowlayout.TagFlowLayout
        android:id="@+id/tag_fl"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxLines = "1" // 显示的行数
        >
</mao.com.flexibleflowlayout.TagFlowLayout>
```
- 简单指定数据适配器

```
TagFlowLayout tagFlowLayout;
//展示tag 数据 list
private List<String> dataList;
tagFlowLayout.setAdapter(new TagAdapter() {
            @Override
            public int getItemCount() {
                return dataList.size();
            }

            @Override
            public View createView(LayoutInflater inflater, ViewGroup parent, int position) {
               //每个 item 展示布局
                return inflater.inflate(R.layout.flow_text_sq_layout,parent,false);
            }

            @Override
            public void bindView(View view, int position) {
                TextView textView = view.findViewById(R.id.text_tag);
                textView.setText(dataList.get(position));
            }
        });
```
- 也可以像recycleview 一样自己灵活设置adapter(具体可看demo)

```
public class MyTagAdapter extends TagAdapter{

        public void setDataList(List<String> dataList) {
            mDataList.clear();
            mDataList.addAll(dataList);
            notifyDataSetChanged();
        }

        private List<String> mDataList = new ArrayList<>();


        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public View createView(LayoutInflater inflater, ViewGroup parent, int position) {
            return inflater.inflate(R.layout.flow_text_tag_layout,parent,false);
        }

        @Override
        public void bindView(View view, int position) {
            TextView textView = view.findViewById(R.id.flow_text_tag);
            textView.setText(mDataList.get(position));
        }
    }
```

## 属性设置
### xml Attributes
name | format| description
---|---|---
android:maxLines | int | FlowLayout显示最大行数


## 方法
### TagAdapter
method name |  return | description
---|---|---
getItemCount() | int | 子元素的数量
createView() | View | 创建子View
bindView() | void | 绑定数据 根据外部数据确定子view 显示数据
onTagItemViewClick() | void | 每个 ItemView 的点击事件 （用户需要的时候自己实现）
tipForSelectMax() | void | 通知 到达了最大选择数（用户需要的时候自己实现）
onItemSelected() | void | item 被选中 可以根据自己的需求灵活设置 UI 样式
onItemUnSelected() | void | item 不被选中 可以根据自己的需求灵活设置 UI 样式
notifyDataSetChanged() | void | 数据刷新

### TagFlowLayout
method name |  return | description
---|---|---
setMaxSelectCount(int maxSelectCount) | void | 设置可以选择多少个tag  默认单选,设置为零 则没有单选和多选效果，纯展示tag
getSelectPositionItemList | List<Integer> | 获取选中子View 的位置集合
# Thanks
- [FlowLayout](https://github.com/hongyangAndroid/FlowLayout)
## License

```

Copyright 2019 maoqitian

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
