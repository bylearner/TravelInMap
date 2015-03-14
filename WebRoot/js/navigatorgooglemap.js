var map = null;
var markers = [];
var clientMarker = null;

function initialize() {
	var mapOptions = {
		zoom: 11,
		center: new google.maps.LatLng(39.904211, 116.407395),
		//center: searchLocation,
		streetViewControl: false,
		minZoom: 3
	};
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
	search(searchText);
	
	clientMarker = new google.maps.Marker({
		position: map.getCenter(),
		map: map,
		title: "your location",
		icon: "image/PeopleIcon.jpg",
		draggable: true
	});

	google.maps.event.addListener(map, 'idle', function(event) {
		adjustClientMarkerLocation();
		getAndShowMarkers();
	});
}

function adjustClientMarkerLocation() {
	if(!map.getBounds().contains(clientMarker.getPosition())){
		clientMarker.setPosition(map.getCenter());
	}
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

function addMarker(location,title,id) {
	var marker = new google.maps.Marker({
		position: location,
		map: map,
		title: "location",
		icon: "image/regularMarker.png"
	});
	markers.push(marker);
	var url = "Journey?storyId=" + id;
	var infowindow = new google.maps.InfoWindow({
	    content: "<a href='"+url+"' target= '_blank'>"+title+"</a>"
	});
	google.maps.event.addListener(marker, 'click', function() {
	    infowindow.open(map,marker);
	});
}

function getAndShowMarkers() {
	var boundNorthEastLat = map.getBounds().getNorthEast().lat();
	var boundNorthEastLng = fixLongtitute(map.getBounds().getNorthEast().lng());
	var boundSouthWestLat = map.getBounds().getSouthWest().lat();
	var boundSouthWestLng = fixLongtitute(map.getBounds().getSouthWest().lng());
	
	var request = new XMLHttpRequest();
	request.onreadystatechange=function(){
		if (request.readyState==4 && request.status==200){
			updateMarkers(request.responseText);
		}
	};
	var url = "GetMarkerListByBound?"+"boundNorthEastLat="+boundNorthEastLat+"&boundNorthEastLng="+boundNorthEastLng
									+"&boundSouthWestLat="+boundSouthWestLat+"&boundSouthWestLng="+boundSouthWestLng;
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
    		addMarker(markLocation, decodeURIComponent(storylist[i].title), storylist[i].id);
    		var url = "Journey?storyId=" + storylist[i].id;
            out += "<a href='"+url+"' target= '_blank'>"+decodeURIComponent(storylist[i].title)+"</><br>";
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

function search(searchText){
	//var searchText = document.getElementById("searchText").value;
	var geocoder = new google.maps.Geocoder();

	geocoder.geocode( { 'address': searchText}, function(results, status) {
		if(status == google.maps.GeocoderStatus.OK) {
			map.setCenter(results[0].geometry.location);
			//map.setZoom(11);
			clientMarker.setCenter(results[0].geometry.location);
			//alert(results[0].geometry.location);
			//return results[0].geometry.location;
		}
		else{
			//alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}

google.maps.event.addDomListener(window, 'load', initialize);