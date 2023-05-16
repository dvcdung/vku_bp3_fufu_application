const db = require('../config/db')

const reviewModel = () => {
    const reviewModelObj = {};

    reviewModelObj.getReviewByUserId = async (resId, userId) => {
        let reviewList = [];
        await new Promise((resolve, reject) => {
            let sql = "SELECT R.reviewId, R.resId, R.userId, U.userFullName, R.revPoint, R.revComment, R.createdAt FROM review R INNER JOIN user U ON R.userId = U.userId  WHERE (R.resId = ?) AND (R.userId = ?)";
            db.query (
                sql,
                [resId, userId],
                (err, result) => {
                    if(err) throw err;
                    resolve(result)
                }
            )
        })
        .then((result) => reviewList = result)
        .catch((err) => console.log(err));
        return reviewList;
    }
    reviewModelObj.getReviewByResId = async (resId, userId) => {
        let reviewList = [];
        await new Promise((resolve, reject) => {
            let sql = "SELECT R.reviewId, R.resId, R.userId, U.userFullName, R.revPoint, R.revComment, R.createdAt FROM review R INNER JOIN user U ON R.userId = U.userId  WHERE (R.resId = ?) AND (R.userId <> ?)";
            db.query (
                sql,
                [resId,userId],
                (err, result) => {
                    if(err) throw err;
                    resolve(result);
                }
            )
        })
        .then((result) => reviewList = result)
        .catch((err) => console.log(err));
        return reviewList;
    }

    return reviewModelObj;
}

module.exports = reviewModel