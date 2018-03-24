## WidgetsLikeGoolePlay
![ic_launcher](https://user-images.githubusercontent.com/11782272/37563574-e69073de-2aa9-11e8-8207-8270e92d4f14.png)
       
  Inspired by Google play store Widgets, project made on MVVM pattern by using Android binding and recycler views.
  That shows items HORIZONTALLY nad VERTICALLY.  
  
### Carousal Widget.
![carousal](https://user-images.githubusercontent.com/11782272/37563055-291c28e4-2a9e-11e8-9a2e-5823beaaf2a6.gif)

Using carousal Widget.

      <com.salman.zach.widgetlikegoogleplay.playWidgets.widgets.PlayCarousalWidget
        android:id="@+id/carousalWidget"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />        
        
        
### Infinite List Widget.
![list](https://user-images.githubusercontent.com/11782272/37563056-2ca39b78-2a9e-11e8-8f94-f04df4c385dd.gif)

 Using Infinite List Widget.

        <com.salman.zach.widgetlikegoogleplay.playWidgets.widgets.PlayListingWidget
        android:id="@+id/listWidget"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
        
        
 Then set a View model which implements ViewModel Interface from Base to widget.   
        
       carousalWidget.buildWidget(viewModel);   
         
Set widget title,description and Banner Image.

         // Background Color will Generate by Banner Image 
        carousalWidget.setBannerImage(R.drawable.js_banner);   
        // Set Tital 
        carousalWidget.setTitle("Super Hero Movies !");
        // Set Description 
        carousalWidget.setDescription("Search Latest Super Hero Movies");
        
        
        
License
-------

    Copyright 2018 Salman Zach

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
