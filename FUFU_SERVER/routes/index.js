const PORT = 4000;
const restaurantRouter = require('./restaurantRouter');
const userRouter = require('./userRouter')

function routes(app) {
    app.use('/api/restaurant/', restaurantRouter);
    app.use('/api/user/', userRouter);
    app.listen(PORT);
}

module.exports = routes;