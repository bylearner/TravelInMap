var map = null;
var locationMarker = null;

function initialize() {
	var mapOptions = {
		zoom: 6,
		center: new google.maps.LatLng(40.0921964, 117.5671306),
		streetViewControl: false,
		minZoom: 3
	};
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
	
	google.maps.event.addListener(map, 'click', function(event) {
		placeMarker(event.latLng);
	});
}

function placeMarker(location) {
	if(locationMarker!=null){
		locationMarker.setPosition(location);
	}
	else{
		locationMarker = new google.maps.Marker({
			position: location,
			map: map,
			title: "your location",
			icon: "image/PeopleIcon.jpg",
			draggable: true
		});
	}
	document.getElementById("locationLat").value=location.lat();
	document.getElementById("locationLng").value=fixLongtitute(location.lng());
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