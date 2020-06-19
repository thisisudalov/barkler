function createFeed(feedList){
  for (var i = 0; i < feedList.length; i++) {
    var p = document.createElement("P");
    var t = document.createTextNode(feedList[i].data);
    p.appendChild(t);
    var ts = document.createElement("div");
    ts.className = "timestamp";
    ts.innerHTML = feedList[i].timestamp;
    var b = document.createElement("B");
    b.innerHTML = "user";
    var elem = document.createElement("div");

    elem.className = "feed";
    elem.appendChild(b);
    elem.appendChild(ts);
    elem.appendChild(p);
    marker.after(elem);
  }
}
function getFeed(){
  fetch("http://127.0.0.1:4567/api/feed/get/q")
  .then(response => response.json())
  .then(json => createFeed(json.feedList));
}
getFeed();
elem = document.getElementById('button');
elem.addEventListener('click', async(evt) => {
  evt.preventDefault();
  const data = document.getElementById('text').value;
  const dataJ = {
    data
  }
  const url = "http://127.0.0.1:4567/api/feed/post";
  try {
  const response = await fetch(url, {
    method: 'POST',
    body: JSON.stringify(dataJ),
    headers: {
      'Content-Type': 'application/json'
    }
  });
  const json = await response.json();
  console.log('Успех:', JSON.stringify(json));
  var p = document.createElement("P");
  var t = document.createTextNode(data);
  p.appendChild(t);
  var ts = document.createElement("div");
  ts.className = "timestamp";
  ts.innerHTML = "Только что";
  var b = document.createElement("B");
  b.innerHTML = "user";
  var elem = document.createElement("div");

  elem.className = "feed";
  elem.appendChild(b);
  elem.appendChild(ts);
  elem.appendChild(p);
  marker.after(elem);
  } catch (error) {
    console.error('Ошибка:', error);
  }
})
