const PORT = 4000;
const restaurantRouter = require('./restaurantRouter');

function routes(app) {
    app.use('/api/restaurant/', restaurantRouter);
    app.listen(PORT);
}

module.exports = routes;