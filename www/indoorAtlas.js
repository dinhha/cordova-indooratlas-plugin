var exec = require('cordova/exec');

function IndoorAtlas() {

}

IndoorAtlas.prototype.init = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "IndoorAtlas", "init", []);
};

IndoorAtlas.prototype.getCurrentLocation = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "IndoorAtlas", "getCurrentLocation", []);
};

IndoorAtlas.prototype.setLocationUpdateHandler = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "IndoorAtlas", "setLocationUpdateHandler", []);
};

module.exports = new IndoorAtlas();
