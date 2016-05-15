cordova = require('cordova');

function IndoorAtlas() {

}

IndoorAtlas.prototype.init = function(successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "IndoorAtlas", "init", []);
};

IndoorAtlas.prototype.getCurrentLocation = function(successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "IndoorAtlas", "getCurrentLocation", []);
};

IndoorAtlas.prototype.setLocationUpdateHandler = function(successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "IndoorAtlas", "setLocationUpdateHandler", []);
};

module.exports = new IndoorAtlas();
