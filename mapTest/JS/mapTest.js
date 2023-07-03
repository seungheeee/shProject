var crs = new L.Proj.CRS("", sample,
    {
        origin: [0, 0],
        resolutions: [ 83990.28020479999941,
            41990.64010239999971,
            20990.82005119999985,
            10490.91002559999993,
            5240.955012799999963,
            2620.477506399999982
        ]
    })

var map2 = L.map('map2', {
    minZoom: 0,
    maxZoom: 5,
    crs: crs,//L.CRS.EPSG4326,
}).setView([38, 126], 0);

// Define the two corners of the rectangle
var corner1 = L.latLng(23, 108); // Example coordinates for one corner
var corner2 = L.latLng(50, 153); // Example coordinates for the opposite corner

// Create the LatLngBounds object
var bounds = L.latLngBounds(corner1, corner2);
map2.fitBounds(bounds);
var rectangle = L.rectangle(bounds, {color: "#ff7800", weight: 1}).addTo(map2);

L.marker([50, 108]).bindPopup('Latitude: 50, Longitude: 108').addTo(map2);
L.marker([50, 153]).bindPopup('Latitude: 50, Longitude: 153').addTo(map2);
L.marker([23, 108]).bindPopup('Latitude: 23, Longitude: 108').addTo(map2);
L.marker([23, 153]).bindPopup('Latitude: 23, Longitude: 153').addTo(map2);

let data2 = JSON.parse(JSON.stringify(seaJson));
data2 = convertProjection(sample, epsg4326, data2);
L.geoJSON(data2).addTo(map2);

// Create a span element for displaying coordinates
let coordi2 = document.getElementById("coordi2");

// Update the coordinates and zoom level when the mouse moves over the map
map2.on('mousemove', function (event) {
    let latLng = [event.latlng.lng, event.latlng.lat];
    let zoomLevel = map2.getZoom();
    coordi2.textContent = "lng: " + latLng[0].toFixed(6) + ", lat: " + latLng[1].toFixed(6) + ", Zoom Level: " + zoomLevel;
    //coordi2.textContent += ", m: " + proj4(sample, epsg4326, [event.latlng.lng, event.latlng.lat]);
});

function onMapClick(event) {
    var latLng = event.latlng;
    var popupContent = 'Latitude: ' + latLng.lat.toFixed(6) + '<br>Longitude: ' + latLng.lng.toFixed(6);

    L.popup()
        .setLatLng(latLng)
        .setContent(popupContent)
        .openOn(map2);
}

map2.on('click', onMapClick);

geojson = makeWorldFeature(map2,'./DATA/wa.topojson');
geojson.addTo(map2);
/*
var polygon = L.polygon([
    [50, 100],
    [50, 150],
]).addTo(map2);

 */