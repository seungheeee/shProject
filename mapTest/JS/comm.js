const sample = "+proj=lcc +lat_1=10.1666666 +lat_0=-2.1 +lon_0=126.10561 +x_0=-17044 +y_0=-23139 +a=6371008.77 +b=6371008.77 +units=m +no_defs";
const epsg4326 = "+proj=longlat +datum=WGS84 +no_defs +type=crs";
const epsg102012 = "+proj=lcc +lat_0=0 +lon_0=105 +lat_1=30 +lat_2=62 +x_0=0 +y_0=0 +datum=WGS84 +units=m +no_defs +type=crs";
const epsg3857 = "+proj=merc +a=6378137 +b=6378137 +lat_ts=0 +lon_0=0 +x_0=0 +y_0=0 +k=1 +units=m +nadgrids=@null +wktext +no_defs +type=crs";

const convertProjection = (FromProj, toProj, featureCollection, ) => {
    let data = featureCollection;
    data.features.forEach(function(feature) {
        feature.geometry.coordinates = feature.geometry.coordinates.map(function(polygon) {
            return polygon.map(function(ring) {
                if(typeof ring[0] === "number"){
                    return proj4(FromProj, toProj, ring);
                }else{
                    return ring.map(function(point) {
                        return proj4(FromProj, toProj, point);
                    });
                }
            });
        });
    });
    return data;
};

function makeWorldFeature(map, url){
    //extend Leaflet to create a GeoJSON layer from a TopoJSON file
    L.TopoJSON = L.GeoJSON.extend({
        addData: function (data) {
            var geojson, key;
            if (data.type === "Topology") {
                for (key in data.objects) {
                    if (data.objects.hasOwnProperty(key)) {
                        geojson = topojson.feature(data, data.objects[key]);
                        L.GeoJSON.prototype.addData.call(this, geojson);
                    }
                }
                return this;
            }
            data.geometry.coordinates = data.geometry.coordinates.map(function(polygon) {
                return polygon.map(function(ring) {
                    if(typeof ring[0] === "number"){
                        return proj4(sample, epsg4326, ring);
                    }else{
                        return ring.map(function(point) {
                            return proj4(sample, epsg4326, point);
                        });
                    }
                });
            });
            L.GeoJSON.prototype.addData.call(this, data);
            return this;
        }
    });
    L.topoJson = function (data, options) {
        return new L.TopoJSON(data, options);
    };
    //create an empty geojson layer
//with a style and a popup on click
    var geojson = L.topoJson(null, {
        style: function(feature){
            return {
                color: "blue",
                opacity: 1,
                weight: 1,
                fillColor: '#35495d',
                fillOpacity: 0.8
            }
        },
        onEachFeature: function (feature, layer) {
            // If this feature has a property named 'name'
            if (feature.properties && feature.properties.ENAME) {
                // Bind a tooltip to the layer showing the name
                layer.bindTooltip(feature.properties.ENAME);
            }
        }
    })

//define a function to get and parse geojson from URL
    async function getGeoData(url) {
        let response = await fetch(url);
        let data = await response.json();
        //console.log(data)
        return data;
    }

//fetch the geojson and add it to our geojson layer
    getGeoData(url).then(data => geojson.addData(data));

    return geojson;
}