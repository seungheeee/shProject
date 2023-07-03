// Create a map with your custom projection
let map1 = L.map('map1', {
    maxZoom: 10,
    minZoom: 4
}).setView([38, 126], 5);

map1.createPane('labels');

// Set the z-index of the pane
map1.getPane('labels').style.zIndex = 650;

// Solve the problem of having image tiles on top of other map layers
map1.getPane('labels').style.pointerEvents = 'none';

// Add a tile layer from OpenStreetMap using the custom projection
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: 'Map data © <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
    maxZoom: 10,
    //pane: 'labels'
}).addTo(map1);

let data1 = JSON.parse(JSON.stringify(seaJson));
data1 =  convertProjection(sample, epsg4326, data1);
let geoData = L.geoJSON(data1).addTo(map1);

geoData.eachLayer(function (layer) {
    layer.bindPopup(layer.feature.properties.name);
});

// Create a span element for displaying coordinates
let coordi = document.getElementById("coordi");

// Update the coordinates and zoom level when the mouse moves over the map
map1.on('mousemove', function (event) {
    let latLng = [event.latlng.lng, event.latlng.lat];
    let zoomLevel = map1.getZoom();
    coordi.textContent = "lng: " + latLng[0].toFixed(6) + ", lat: " + latLng[1].toFixed(6) + ", Zoom Level: " + zoomLevel;
    coordi.textContent += ",  m: " + proj4(epsg4326, epsg3857, latLng);
});

let geojson = makeWorldFeature(map1,'./DATA/wa.topojson');
geojson.addTo(map1);
// Add some interaction to each feature on the GeoJSON layer
geojson.eachLayer(function (layer) {
    layer.bindPopup(layer.feature.properties.name);
});

function handleZoomEnd() {
    var currentZoom = map1.getZoom();
    if (currentZoom >= 8) {
        makeWorldFeature(map1, '/DATA/sgg.topojson');
    } else {

    }
}

map1.on('zoomend', handleZoomEnd);

/*
var polygon = L.polygon([
    [50, 100],
    [50, 150],
]).addTo(map1);
*/


