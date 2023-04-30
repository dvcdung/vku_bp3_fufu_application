const db = require('../config/db');

const RestarantModel = () => {
    const restarantModel = {};

    restarantModel.getRestaurant = async (userId) => {
        let restaurantList = [];
        restaurantList = await new Promise((resolve, reject) => {
            let sql = "select * from restaurant where userId=?";
            db.query(
                sql,
                [userId],
                (err, result) => {
                    if(err) throw err;
                    resolve(result)
                }
            )
        })
        .then((result) => restaurantList = result)
        .catch((err) => console.log(err));

        return restaurantList;
    }

    return restarantModel;
}

module.exports = RestarantModel;