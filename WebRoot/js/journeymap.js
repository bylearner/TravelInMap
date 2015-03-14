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
}

google.maps.event.addDomListener(window, 'load', initialize);