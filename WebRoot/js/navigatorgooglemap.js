var map = null;
var markers = [];

function initialize() {
	var mapOptions = {
		zoom: 6,
		center: new google.maps.LatLng(40.0921964, 117.5671306),
		streetViewControl: false,
		minZoom: 3
	};
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
	/*
	google.maps.event.addListener(map, 'click', function(event) {
		addMarker(event.latLng);
	});*/
	google.maps.event.addListener(map, 'idle', function(event) {
		getAndShowMarkers();
	});
}

//Sets the map on all markers in the array.
function setAllMap(map) {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}

// Removes the markers from the map, but keeps them in the array.
function clearMarkers() {
  setAllMap(null);
}

// Shows any markers currently in the array.
function showMarkers() {
  setAllMap(map);
}

// Deletes all markers in the array by removing references to them.
function deleteMarkers() {
  clearMarkers();
  markers = [];
}

function addMarker(location) {
	var marker = new google.maps.Marker({
		position: location,
		map: map,
		title: "zjy",
		icon: "image/regularMarker.png"
	});
	markers.push(marker);
	var infowindow = new google.maps.InfoWindow({
	    content: "<a href='http://www.google.com'>1212</a>"
	});
	google.maps.event.addListener(marker, 'click', function() {
	    infowindow.open(map,marker);
	});
}

function getAndShowMarkers() {
	var boundNorthEastLat = map.getBounds().getNorthEast().lat();
	var boundNorthEastLng = fixLongtitute(map.getBounds().getSouthWest().lng());
	var boundSouthWestLat = map.getBounds().getNorthEast().lat();
	var boundSouthWestLng = fixLongtitute(map.getBounds().getSouthWest().lng());
	var boundCenterLat = map.getCenter().lat();
	var boundCenterLng = fixLongtitute(map.getCenter().lng());
	
	var request = new XMLHttpRequest();
	request.onreadystatechange=function(){
		if (request.readyState==4 && request.status==200){
			updateMarkers(request.responseText);
		}
	}
	var url = "GetMarkerListByBound?"+"boundNorthEastLat="+boundNorthEastLat+"&boundNorthEastLng="+boundNorthEastLng
									+"&boundSouthWestLat="+boundSouthWestLat+"&boundSouthWestLng="+boundSouthWestLng
									+"&boundCenterLat="+boundCenterLat+"&boundCenterLng="+boundCenterLng;
	request.open("GET",url,true);
	request.send(null);
}

function updateMarkers(responseText) {
	var storylistDiv = document.getElementById("storylist");
	var storylist = JSON.parse(responseText);
	deleteMarkers();
	var out = "";
    for(var i = 0; i < storylist.length; i++) {
    	var markLocation = new google.maps.LatLng(storylist[i].lat, storylist[i].lng);
    	if(map.getBounds().contains(markLocation)){
    		addMarker(markLocation);
            out += " title: " + storylist[i].title + "<br>";
    	}
    }
    storylistDiv.innerHTML = out;
}

function fixLongtitute(passedLongtitute){
	if(passedLongtitute>180){
		return fixLongtitute(passedLongtitute-360);
	}
	else if(passedLongtitute<-180){
		return fixLongtitute(passedLongtitute+360);
	}
	return passedLongtitute;
}

google.maps.event.addDomListener(window, 'load', initialize);