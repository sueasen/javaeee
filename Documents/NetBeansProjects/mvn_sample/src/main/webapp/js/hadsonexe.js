$(document).ready(function () {
 
  var data = [     //表に流し込むデータを定義します。サーバーからJSONなどで持ってきてもOK
      ['', 'Maserati', 'Mazda', 'Mercedes', 'Mini', 'Mitsubishi'],
      ['2009', 0, 2941, 4303, 354, 5814],
      ['2010', 3, 2905, 2867, 412, 5284],
      ['2012', 2, 2422, 5399, 776, 4151],
      ['2012', 2, 2422, 5399, 776, 4151],
      ['2012', 2, 2422, 5399, 776, 4151]
    ],
    container = document.getElementById('example'),  //後ほど表を展開する要素を指定
    hot;
  
  hot = new Handsontable(container, {      //以下はデータ指定と表示オプション
    data: data,            //さっき作ったdataを指定
    minSpareRows: 1,       //表の一番下にいくつ空行を表示するか
    colHeaders: true,      //カラムの名前を表示するかどうか
    contextMenu: true      //セルを右クリックしたときのメニューをすべて表示
  });
  
  
  function bindDumpButton() {    //以下は基本的にいじりません
  
      Handsontable.Dom.addEvent(document.body, 'click', function (e) {
  
        var element = e.target || e.srcElement;
  
        if (element.nodeName == "BUTTON" && element.name == 'dump') {
          var name = element.getAttribute('data-dump');
          var instance = element.getAttribute('data-instance');
          var hot = window[instance];
          console.log('data of ' + name, hot.getData());
        }
      });
    }
  bindDumpButton();    //関数実行
 
});
