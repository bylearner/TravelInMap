var map = null;
<<<<<<< HEAD
var storyIds = [];
var storyTitles = [];
var locations = [];

function initialize() {
	var mapOptions = {
		zoom: 14,
=======
var markers = [];

function initialize() {
	var mapOptions = {
		zoom: 6,
>>>>>>> origin/master
		center: new google.maps.LatLng(40.0921964, 117.5671306),
		streetViewControl: false,
		minZoom: 3
	};
	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
<<<<<<< HEAD
	addMarkers();
}

function addMarkers(){
	var i = 0;
	for(i=0; i<storyIds.length; i++){
		addMarker(locations[i],storyTitles[i],storyIds[i],i+1);
	}
}

function addMarker(location,title,id,index) {
	var marker = new google.maps.Marker({
		position: location,
		map: map,
		title: "location",
		icon: "image/regularMarker.png"
	});
	var url = "Journey?storyId=" + id;
	var infowindow = new google.maps.InfoWindow({
	    content: "<a href='"+url+"'>"+"Day "+index+"</a>"
	});
	google.maps.event.addListener(marker, 'click', function() {
	    infowindow.open(map,marker);
	});
	if (currentstoryid==id){
		marker.setIcon("image/flag.ico");
		map.setCenter(location);
		infowindow.open(map,marker);
	}
}


=======
}

>>>>>>> origin/master
google.maps.event.addDomListener(window, 'load', initialize);