const reviewModel = require("../../model/Review")

const reviewController = () => {
    const reviewControllerObj = {}

    reviewControllerObj.getReviewByUserId = async (req, res) => {
        res.status(200);
        res.send(await reviewModel().getReviewByUserId(req.params.resId, req.params.userId));
    }
    reviewControllerObj.getReviewByResId = async (req, res) => {
        res.status(200);
        res.send(await reviewModel().getReviewByResId(req.params.resId, req.params.userId));
    }

    return reviewControllerObj;
}

module.exports = reviewController;